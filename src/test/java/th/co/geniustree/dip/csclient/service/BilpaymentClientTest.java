/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package th.co.geniustree.dip.csclient.service;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JSR310Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.util.Base64;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;
import th.co.geniustree.dip.csclient.model.DataExchangeBase;
import th.co.geniustree.dip.csclient.model.ConfirmDataRequest;
import th.co.geniustree.dip.csclient.model.DataExchange;
import th.co.geniustree.dip.csclient.model.DataResponse;

/**
 *
 * @author pramoth
 */
public class BilpaymentClientTest {

    private BilpaymentClient billpaymentService;

    @Before
    public void setUp() {
        //For logging.You may dont need.
        OkHttpClient client = createOkHttpClient("","");
       
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://epayment.ipthailand.go.th")
                .client(client)
                .addConverterFactory(JacksonConverterFactory.create())
                .build();
        billpaymentService = retrofit.create(BilpaymentClient.class);
    }

    private OkHttpClient createOkHttpClient(String username,String password) {
        //Logging Intercepter
        HttpLoggingInterceptor bodyLog = new HttpLoggingInterceptor();
        bodyLog.setLevel(HttpLoggingInterceptor.Level.BODY);
        //Create Http client
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(bodyLog)
                .addInterceptor(createAuthenIntercepter(username,password))
                .build();
        return client;
    }
    
    private Interceptor createAuthenIntercepter(String username, String password) {
        return new Interceptor() {
            @Override
            public okhttp3.Response intercept(Interceptor.Chain chain) throws IOException {
                System.out.println("set authen header intercepter.");
                // basic authen need credential in form of "Basic base64(username:password)"
                //and put it in http header "Authorization" 
                String authenCode = Base64.getEncoder().encodeToString((username+":"+password).getBytes(StandardCharsets.US_ASCII));
                Request request = chain
                        .request()
                        .newBuilder()
                        .header("Authorization","Basic "+authenCode)
                        .build();
            return chain.proceed(request);
            }
        };
    }

    /**
     * Test of request method, of class BilpaymentClient.
     */
    @Test
    public void testRequest() throws IOException {
        Call<DataResponse> result = billpaymentService.request("000000000000000999", "201701301130590", new BigDecimal("2000"), "10001");
        Response<DataResponse> execute = result.execute();
        System.out.println(execute.headers());
        if (execute.isSuccessful()) {
            System.out.println("Handle successful here");
            DataResponse body = execute.body();
            System.out.println(body);
        } else {
            System.out.println("Handle error here");
        }
    }
    /**
     * Test of request method, of class BilpaymentClient.
     */
    @Test
    public void testConfirm() throws IOException {
        ConfirmDataRequest request = new ConfirmDataRequest();
        request.setAmount(new BigDecimal("2000"));
        request.setPaymentDateTime(LocalDateTime.now());
        request.setTxId("12345");
        Call<DataExchange> result = billpaymentService.confirm("000000000000000999", "201701301130590",request);
        Response<DataExchange> execute = result.execute();
        System.out.println(execute.headers());
        if (execute.isSuccessful()) {
            System.out.println("Handle successful here");
            DataExchange body = execute.body();
            System.out.println(body);
        } else {
            System.out.println("Handle error here");
        }
    }

}
