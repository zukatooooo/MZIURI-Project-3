package com.mziuri.service;

import com.mziuri.storage.Product;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.json.JSONArray;
import jakarta.persistence.Persistence;
import org.json.JSONObject;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class StorageReaderService {
    private static StorageReaderService storageReaderServiceObject = null;

    private StorageReaderService() {
    }

    public static StorageReaderService instance() {
        if (storageReaderServiceObject == null) {
            storageReaderServiceObject = new StorageReaderService();
        }
        return storageReaderServiceObject;
    }

    // TODO: fix addProductsFromJsonFile function.

    public void addProductsFromJsonFile(String jsonFilePath) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("chemi-unit");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        try {
            String jsonContent = new String(Files.readAllBytes(Paths.get(jsonFilePath)));
            JSONArray jsonArray = new JSONArray(jsonContent);
            entityManager.getTransaction().begin();
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonProduct = jsonArray.getJSONObject(i);
                int id = jsonProduct.getInt("prod_id");
                String name = jsonProduct.getString("prod_name");
                float price = (float) jsonProduct.getDouble("prod_price");
                int amount = jsonProduct.getInt("prod_amount");
                Product product = new Product(id, name, price, amount);
                entityManager.persist(product);
            }
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
                entityManager.close();
                entityManagerFactory.close();
            }
            e.printStackTrace();
        }
    }
}
