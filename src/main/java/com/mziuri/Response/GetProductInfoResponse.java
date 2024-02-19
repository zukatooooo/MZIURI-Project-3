package com.mziuri.Response;

public class GetProductInfoResponse {
    private String name;
    private Float price;
    private Integer amount;

    public GetProductInfoResponse(String name, Float price, Integer amount) {
        this.name = name;
        this.price = price;
        this.amount = amount;
    }
}
