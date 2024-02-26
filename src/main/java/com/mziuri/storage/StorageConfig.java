package com.mziuri.storage;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class StorageConfig {
    private Product[] products;
    private String password;

    @JsonCreator
    public StorageConfig(@JsonProperty("products") Product[] products, @JsonProperty("password") String password) {
        this.products = products;
        this.password = password;
    }

    public StorageConfig() {
    }

    public Product[] getProducts() {
        return products;
    }

    public String getPassword() {
        return password;
    }
}
