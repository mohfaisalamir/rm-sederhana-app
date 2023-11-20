package com.enigma.rmsederhanaapp.dto;

public class TransactionDetailResponse {
    private String foodName;
    private Long foodPrice;
    private Integer qty;
    private Long subTotal;

    public TransactionDetailResponse(String foodName, Long foodPrice, Integer qty, Long subTotal) {
        this.foodName = foodName;
        this.foodPrice = foodPrice;
        this.qty = qty;
        this.subTotal = subTotal;
    }

    public TransactionDetailResponse() {
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public Long getFoodPrice() {
        return foodPrice;
    }

    public void setFoodPrice(Long foodPrice) {
        this.foodPrice = foodPrice;
    }

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }

    public Long getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(Long subTotal) {
        this.subTotal = subTotal;
    }

    @Override
    public String toString() {
        return "TransactionDetailResponse{" +
                "foodName='" + foodName + '\'' +
                ", foodPrice=" + foodPrice +
                ", qty=" + qty +
                ", subTotal=" + subTotal +
                '}';
    }
}
