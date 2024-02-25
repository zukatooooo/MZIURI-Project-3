package com.mziuri.service;

public class DatabaseManagerService {
    private static DatabaseManagerService databaseManagerServiceObject = null;

    private DatabaseManagerService() {
    }

    public static DatabaseManagerService instance() {
        if (databaseManagerServiceObject == null) {
            databaseManagerServiceObject = new DatabaseManagerService();
        }
        return databaseManagerServiceObject;
    }
}
