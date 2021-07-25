package com.github.gabrielgouv.infrastructure.repository.mongodb.impl;

import com.github.gabrielgouv.domain.entity.Book;
import com.github.gabrielgouv.domain.repository.BookRepository;
import com.github.gabrielgouv.infrastructure.repository.mongodb.base.MongoBaseRepository;
import com.mongodb.client.MongoClient;

import javax.inject.Inject;
import javax.inject.Singleton;

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
        return persist(book);
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
