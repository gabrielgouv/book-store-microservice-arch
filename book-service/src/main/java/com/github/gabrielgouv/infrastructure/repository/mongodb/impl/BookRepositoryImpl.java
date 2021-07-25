package com.github.gabrielgouv.infrastructure.repository.mongodb.impl;

import com.github.gabrielgouv.domain.entity.Book;
import com.github.gabrielgouv.domain.repository.BookRepository;
import com.github.gabrielgouv.infrastructure.repository.mongodb.base.MongoBaseRepository;
import com.mongodb.client.MongoClient;
import com.mongodb.client.result.InsertOneResult;
import org.bson.BsonValue;

import static com.mongodb.client.model.Filters.eq;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.UUID;

@Singleton
public class BookRepositoryImpl extends MongoBaseRepository<Book> implements BookRepository {

    public static final String BOOKS_DATABASE_NAME = "books";
    public static final String BOOKS_COLLECTION_NAME = "books";

    @Inject
    public BookRepositoryImpl(final MongoClient mongoClient) {
        super(mongoClient, BOOKS_DATABASE_NAME, BOOKS_COLLECTION_NAME);
    }

    @Override
    public Book persistBook(Book book) {
        final String bookId = UUID.randomUUID().toString();
        book.setId(bookId);
        InsertOneResult result = getCollection().insertOne(book);
        if (!result.wasAcknowledged()) {
            throw new RuntimeException("Cannot insert a new book");
        }
        BsonValue insertedId = result.getInsertedId();
        if (insertedId == null) {
            throw new RuntimeException("Cannot get inserted book id");
        }
        Book insertedBook = getCollection().find(eq(ID_FIELD, bookId)).first();
        if (insertedBook == null) {
            throw new RuntimeException("Book id::" + insertedId.asObjectId().getValue() + " was inserted but could not be returned");
        }
        return insertedBook;
    }

    @Override
    public boolean deleteBook(String bookId) {
        return false;
    }

    @Override
    public Book updateBook(Book book) {
        return null;
    }

}
