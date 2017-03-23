/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package th.co.geniustree.dip.csclient.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 *
 * @author pramoth
 */
public class DataExchangeBase {

    private String reference1;

    private String reference2;

    private BigDecimal amount;
    
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime paymentDateTime = LocalDateTime.now();

    private String txId;

    public DataExchangeBase() {

    }

    public DataExchangeBase(String reference1, String reference2, BigDecimal amount, LocalDateTime paymentDateTime) {
        this.reference1 = reference1;
        this.reference2 = reference2;
        this.amount = amount;
        this.paymentDateTime = paymentDateTime;
    }

    public DataExchangeBase(String reference1, String reference2, BigDecimal amount, LocalDateTime paymentDateTime, String txId) {
        this.reference1 = reference1;
        this.reference2 = reference2;
        this.amount = amount;
        this.paymentDateTime = paymentDateTime;
        this.txId = txId;
    }

    public String getTxId() {
        return txId;
    }

    public void setTxId(String txId) {
        this.txId = txId;
    }

    public String getReference1() {
        return reference1;
    }

    public void setReference1(String reference1) {
        this.reference1 = reference1;
    }

    public String getReference2() {
        return reference2;
    }

    public void setReference2(String reference2) {
        this.reference2 = reference2;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public LocalDateTime getPaymentDateTime() {
        return paymentDateTime;
    }

    public void setPaymentDateTime(LocalDateTime paymentDateTime) {
        this.paymentDateTime = paymentDateTime;
    }
}
