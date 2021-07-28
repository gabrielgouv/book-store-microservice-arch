package com.github.gabrielgouv.infrastructure.repository.mongodb.base;

import com.github.gabrielgouv.domain.entity.base.BaseEntity;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.InsertOneResult;
import com.mongodb.client.result.UpdateResult;
import lombok.extern.slf4j.Slf4j;
import org.bson.BsonValue;

import javax.inject.Inject;
import java.lang.reflect.ParameterizedType;
import java.time.LocalDateTime;
import java.util.UUID;

import static com.mongodb.client.model.Filters.eq;

@Slf4j
@SuppressWarnings("unchecked")
public class MongoBaseRepository<T extends BaseEntity<String>> {

    protected static final String ID_FIELD = "_id";

    private final MongoClient mongoClient;
    private final String databaseName;
    private final String collectionName;
    private final Class<T> typeOfT;

    @Inject
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
        entity.setCreatedAt(LocalDateTime.now());
        final InsertOneResult result = getCollection().insertOne(entity);
        if (!result.wasAcknowledged()) {
            throw new RuntimeException("Cannot insert a new entity");
        }
        final BsonValue insertedId = result.getInsertedId();
        if (insertedId == null) {
            throw new RuntimeException("Cannot get inserted entity id");
        }
        log.info("Entity " + entity.getClass().getSimpleName() + "::" + insertedId.asString().getValue() + " was inserted");
        final T insertedEntity = getCollection().find(eq(ID_FIELD, generatedId)).first();
        if (insertedEntity == null) {
            throw new RuntimeException("Entity " + entity.getClass().getSimpleName()  + "::" + insertedId.asObjectId().getValue()
                    + " was inserted but could not be returned");
        }
        return insertedEntity;
    }

    protected T update(T entity) {
        entity.setUpdatedAt(LocalDateTime.now());
        final UpdateResult result = getCollection().replaceOne(eq(ID_FIELD, entity.getId()), entity);
        final long modifiedCount = result.getModifiedCount();
        log.info("Entity " + entity.getClass().getSimpleName() + "::" + entity.getId() + " was updated");
        if (modifiedCount < 1) {
            throw new RuntimeException("Cannot find entity " + entity.getClass().getSimpleName() + "::"
                    + entity.getId() + " to update");
        }
        if (modifiedCount > 1) {
            log.warn("Inconsistency: More than one entity was updated!");
        }
        final T updatedEntity = getCollection().find(eq(ID_FIELD, entity.getId())).first();
        if (updatedEntity == null) {
            throw new RuntimeException("Entity " + entity.getClass().getSimpleName() + "::" + entity.getId()
                    + " was updated but could not be returned");
        }
        return updatedEntity;
    }

    protected boolean delete(String id) {
        final DeleteResult result = getCollection().deleteOne(eq(ID_FIELD, id));
        final long deletedCount = result.getDeletedCount();
        if (deletedCount < 1) {
            throw new RuntimeException("Cannot find entity ::" + id + " to delete");
        }
        if (deletedCount > 1) {
            log.warn("Inconsistency: More than one entity was deleted!");
        }
        log.info("Entity ::" + id + " was deleted");
        return true;
    }

    protected boolean logicalDelete(String id) {
        final T foundEntity = getCollection().find(eq(ID_FIELD, id)).first();
        if (foundEntity == null) {
            throw new RuntimeException("Cannot find entity ::" + id + " to logically delete");
        }
        final LocalDateTime now = LocalDateTime.now();
        foundEntity.setUpdatedAt(now);
        foundEntity.setDeletedAt(now);
        final UpdateResult result = getCollection().replaceOne(eq(ID_FIELD, id), foundEntity);
        final long modifiedCount = result.getModifiedCount();
        log.info("Entity " + foundEntity.getClass().getSimpleName() + "::" + foundEntity.getId() + " was logically deleted");
        if (modifiedCount < 1) {
            throw new RuntimeException("Cannot logically delete ::" + id);
        }
        return true;
    }

    private String generateId() {
        return UUID.randomUUID().toString();
    }

}
