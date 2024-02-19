package com.mziuri.Response;

public class AddProductResponse {
    private String name;
    private Integer remainingAmount;

    public AddProductResponse(String name, Integer remainingAmount) {
        this.name = name;
        this.remainingAmount = remainingAmount;
    }
}
