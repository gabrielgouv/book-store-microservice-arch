package com.github.gabrielgouv.infrastructure.repository.mongodb.base;

import com.github.gabrielgouv.domain.entity.base.BaseEntity;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.result.InsertOneResult;
import org.bson.BsonValue;

import javax.inject.Inject;
import java.lang.reflect.ParameterizedType;
import java.util.UUID;

import static com.mongodb.client.model.Filters.eq;

public class MongoBaseRepository<T extends BaseEntity> {

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

    protected T persist(T entity) {
        final String generatedId = generateId();
        entity.setId(generatedId);
        InsertOneResult result = getCollection().insertOne(entity);
        if (!result.wasAcknowledged()) {
            throw new RuntimeException("Cannot insert a new entity");
        }
        BsonValue insertedId = result.getInsertedId();
        if (insertedId == null) {
            throw new RuntimeException("Cannot get inserted entity id");
        }
        T insertedEntity = getCollection().find(eq(ID_FIELD, generatedId)).first();
        if (insertedEntity == null) {
            throw new RuntimeException("Entity id::" + insertedId.asObjectId().getValue() + " was inserted but could not be returned");
        }
        return insertedEntity;
    }

    private String generateId() {
        return UUID.randomUUID().toString();
    }

}
