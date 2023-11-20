package com.enigma.rmsederhanaapp.dto;

public class TransactionDetailRequest {
    private Integer foodId;
    private Integer quantity;

    public TransactionDetailRequest(Integer foodId, Integer quantity) {
        this.foodId = foodId;
        this.quantity = quantity;
    }

    public TransactionDetailRequest() {
    }

    public Integer getFoodId() {
        return foodId;
    }

    public void setFoodId(Integer foodId) {
        this.foodId = foodId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "TransactionDetailRequest{" +
                "foodId=" + foodId +
                ", quantity=" + quantity +
                '}';
    }
}
