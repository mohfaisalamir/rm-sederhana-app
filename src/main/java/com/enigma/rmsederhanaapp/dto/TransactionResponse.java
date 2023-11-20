package com.enigma.rmsederhanaapp.dto;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class TransactionResponse {
    private Integer TransactionId;
    private Date transDate;
    private String visitorName;
    private List<TransactionDetailResponse> transactionDetails;

    public TransactionResponse(Integer transactionId, Date transDate, String visitorName) {
        TransactionId = transactionId;
        this.transDate = transDate;
        this.visitorName = visitorName;
        this.transactionDetails = new ArrayList<>();
    }

    public TransactionResponse() {
    }
    public void addTransactionDetail(TransactionDetailResponse transactionDetailResponse) {
        this.transactionDetails.add(transactionDetailResponse);
    }

    public Integer getTransactionId() {
        return TransactionId;
    }

    public void setTransactionId(Integer transactionId) {
        TransactionId = transactionId;
    }

    public Date getTransDate() {
        return transDate;
    }

    public void setTransDate(Date transDate) {
        this.transDate = transDate;
    }

    public String getVisitorName() {
        return visitorName;
    }

    public void setVisitorName(String visitorName) {
        this.visitorName = visitorName;
    }

    public List<TransactionDetailResponse> getTransactionDetails() {
        return transactionDetails;
    }

    public void setTransactionDetails(List<TransactionDetailResponse> transactionDetails) {
        this.transactionDetails = transactionDetails;
    }

    @Override
    public String toString() {
        return "TransactionResponse{" +
                "TransactionId=" + TransactionId +
                ", transDate=" + transDate +
                ", visitorName='" + visitorName + '\'' +
                ", transactionDetails=" + transactionDetails +
                '}';
    }
}
