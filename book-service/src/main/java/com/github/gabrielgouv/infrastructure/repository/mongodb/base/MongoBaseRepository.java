package com.github.gabrielgouv.infrastructure.repository.mongodb.base;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;

import javax.inject.Inject;
import java.lang.reflect.ParameterizedType;

public class MongoBaseRepository<T> {

    protected static final String ID_FIELD = "_id";

    private final MongoClient mongoClient;
    private final String databaseName;
    private final String collectionName;
    private final Class<T> typeOfT;

    @Inject
    @SuppressWarnings("unchecked")
    public MongoBaseRepository(final MongoClient mongoClient, final String databaseName, final String collectionName) {
        this.mongoClient = mongoClient;
        this.databaseName = databaseName;
        this.collectionName = collectionName;
        this.typeOfT = (Class<T>) ((ParameterizedType) getClass()
                        .getGenericSuperclass())
                        .getActualTypeArguments()[0];
    }

    protected MongoCollection<T> getCollection() {
        return mongoClient.getDatabase(databaseName)
                .getCollection(collectionName, typeOfT);
    }

}
