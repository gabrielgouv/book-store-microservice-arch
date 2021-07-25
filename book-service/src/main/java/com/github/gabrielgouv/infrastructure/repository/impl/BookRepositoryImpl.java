package com.github.gabrielgouv.infrastructure.repository.impl;

import com.github.gabrielgouv.domain.entity.Book;
import com.github.gabrielgouv.domain.repository.BookRepository;

import javax.inject.Singleton;

@Singleton
public class BookRepositoryImpl implements BookRepository {

    @Override
    public Book persistBook(Book book) {
        return null;
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
