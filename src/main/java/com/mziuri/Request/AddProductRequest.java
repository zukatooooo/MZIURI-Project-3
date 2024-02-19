package com.mziuri.Request;

public class AddProductRequest {
    private String password;
    private String name;
    private Integer amount;

    public AddProductRequest(String password, String name, Integer amount) {
        this.password = password;
        this.name = name;
        this.amount = amount;
    }
}
