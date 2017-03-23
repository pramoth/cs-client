/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package th.co.geniustree.dip.csclient.service;

import java.math.BigDecimal;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;
import th.co.geniustree.dip.csclient.model.DataExchange;
import th.co.geniustree.dip.csclient.model.ConfirmDataRequest;
import th.co.geniustree.dip.csclient.model.DataResponse;

/**
 *
 * @author pramoth
 */
public interface BilpaymentClient {
    @GET("/api/ws/counter-service/{reference1}/{reference2}")
    Call<DataResponse> request(@Path("reference1")String ref1,@Path("reference2")String ref2,@Query("amount") BigDecimal amount,@Query("txId") String txId);
    
    @POST("/api/ws/counter-service/{reference1}/{reference2}")
    Call<DataExchange> confirm(@Path("reference1")String ref1,@Path("reference2")String ref2,@Body ConfirmDataRequest data);
}
