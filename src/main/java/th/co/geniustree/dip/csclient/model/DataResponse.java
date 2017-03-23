/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package th.co.geniustree.dip.csclient.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 *
 * @author pramoth
 */
public class DataResponse extends DataExchangeBase {

        private ResponseStatus status;

        private String errorMessage;

        public DataResponse() {

        }

        public DataResponse(String reference1, String reference2, BigDecimal amount, ResponseStatus status, String errorMessage, LocalDateTime paymentDate) {
            super(reference1, reference2, amount, paymentDate);
            this.status = status;
            this.errorMessage = errorMessage;
        }

        public DataResponse(String reference1, String reference2, BigDecimal amount, LocalDateTime paymentDateTime, String txId, String logId, ResponseStatus status, String errorMessage) {
            super(reference1, reference2, amount, paymentDateTime, txId);
            this.status = status;
            this.errorMessage = errorMessage;
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
            return LocalDateTime.now();
        }
    }
