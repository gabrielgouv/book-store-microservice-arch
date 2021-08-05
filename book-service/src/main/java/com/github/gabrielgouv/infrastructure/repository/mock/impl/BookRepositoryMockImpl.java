package com.github.gabrielgouv.infrastructure.repository.mock.impl;

import com.github.gabrielgouv.domain.entity.Book;
import com.github.gabrielgouv.domain.repository.BookRepository;

import javax.inject.Named;
import javax.inject.Singleton;
import java.util.List;
import java.util.Optional;

@Named("mock")
@Singleton
public class BookRepositoryMockImpl implements BookRepository {

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

    @Override
    public List<Book> getAllBooks() {
        return null;
    }

    @Override
    public Optional<Book> getBook(String id) {
        return Optional.empty();
    }

}
