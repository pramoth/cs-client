/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package th.co.geniustree.dip.csclient.model;

import java.time.LocalDateTime;

/**
 *
 * @author pramoth
 */
public class DataExchange extends DataExchangeBase {
    
    private LocalDateTime confirmDateTime;

    private ResponseStatus status;

    private String errorMessage;

    private LocalDateTime time;

    public DataExchange() {

    }

    public LocalDateTime getConfirmDateTime() {
        return confirmDateTime;
    }

    public void setConfirmDateTime(LocalDateTime confirmDateTime) {
        this.confirmDateTime = confirmDateTime;
    }

    public ResponseStatus getStatus() {
        return status;
    }

    public void setStatus(ResponseStatus status) {
        this.status = status;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }
}
