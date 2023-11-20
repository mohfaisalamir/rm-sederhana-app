package com.enigma.rmsederhanaapp.entity;

import java.sql.Date;

public class Transaction {
    private Integer id;
    private Date transDate;
    private Integer visitorId;

    public Transaction(Integer id, Date transDate, Integer visitorId) {
        this.id = id;
        this.transDate = transDate;
        this.visitorId = visitorId;
    }

    public Transaction() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getTransDate() {
        return transDate;
    }

    public void setTransDate(Date transDate) {
        this.transDate = transDate;
    }

    public Integer getCustomerId() {
        return visitorId;
    }

    public void setCustomerId(Integer visitorId) {
        this.visitorId = visitorId;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + id +
                ", transDate=" + transDate +
                ", visitorId=" + visitorId +
                '}';
    }
}
