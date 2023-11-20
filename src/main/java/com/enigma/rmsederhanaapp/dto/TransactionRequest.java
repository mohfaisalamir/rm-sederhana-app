package com.enigma.rmsederhanaapp.dto;

import java.util.List;

public class TransactionRequest {
    private Integer visitorId;
    private List<TransactionDetailRequest> transactionDetails;

    public TransactionRequest(Integer visitorId, List<TransactionDetailRequest> transactionDetails) {
        this.visitorId = visitorId;
        this.transactionDetails = transactionDetails;
    }

    public TransactionRequest() {
    }

    public Integer getVisitorId() {
        return visitorId;
    }

    public void setVisitorId(Integer visitorId) {
        this.visitorId = visitorId;
    }

    public List<TransactionDetailRequest> getTransactionDetails() {
        return transactionDetails;
    }

    public void setTransactionDetails(List<TransactionDetailRequest> transactionDetails) {
        this.transactionDetails = transactionDetails;
    }

    @Override
    public String toString() {
        return "TransactionRequest{" +
                "visitorId=" + visitorId +
                ", transactionDetails=" + transactionDetails +
                '}';
    }
}
