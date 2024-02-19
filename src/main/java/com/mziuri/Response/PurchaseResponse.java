package com.mziuri.Response;

public class PurchaseResponse {
    private String name;
    private Integer remainingAmount;

    public PurchaseResponse(String name, Integer remainingAmount) {
        this.name = name;
        this.remainingAmount = remainingAmount;
    }
}
