package com.mziuri.storage;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
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

    @JsonCreator
    public Product(@JsonProperty("prod_id") int id, @JsonProperty("prod_name") String name, @JsonProperty("prod_price") float price, @JsonProperty("prod_amount") int amount) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.amount = amount;
    }

    public Product() {
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", amount=" + amount +
                '}';
    }
}
