package com.mziuri.storage;

import jakarta.persistence.*;

@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "prod_name")
    private String name;

    @Column(name = "prod_price")
    private float price;

    @Column(name = "prod_amount")
    private int amount;

    public Product(int id, String name, float price, int amount) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.amount = amount;
    }

    public Product() {
    }
}
