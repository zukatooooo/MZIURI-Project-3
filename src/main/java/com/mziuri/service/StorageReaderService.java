package com.mziuri.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mziuri.storage.Product;
import com.mziuri.storage.StorageConfig;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.hibernate.Session;

import java.io.File;
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

    public void addProductsFromJsonFile(String path) {
        try {
            File jsonFile = new File(path);
            ObjectMapper objectMapper = new ObjectMapper();
            StorageConfig storageConfig = objectMapper.readValue(jsonFile, StorageConfig.class);

            EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("chemi-unit");
            EntityManager entityManager = entityManagerFactory.createEntityManager();
            EntityTransaction transaction = entityManager.getTransaction();

            for (int i = 0; i < storageConfig.getProducts().length; i++){
                System.out.println(storageConfig.getProducts()[i].toString());
            }

            transaction.begin();

//            CriteriaBuilder cb = entityManager.getCriteriaBuilder();
//            CriteriaQuery<Product> cr = cb.createQuery(Product.class);
//            Root<Product> root = cr.from(Product.class);



            transaction.commit();

            entityManager.close();
            entityManagerFactory.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
