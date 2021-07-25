package com.github.gabrielgouv.domain.service.impl;

import com.github.gabrielgouv.domain.entity.Book;
import com.github.gabrielgouv.domain.repository.BookRepository;
import com.github.gabrielgouv.domain.service.BookDomainService;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class BookDomainServiceImpl implements BookDomainService {

    private final BookRepository bookRepository;

    @Inject
    public BookDomainServiceImpl(final BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Book createBook(Book book) {
        return this.bookRepository.persistBook(book);
    }

    @Override
    public boolean deleteBook(String bookId) {
        return this.bookRepository.deleteBook(bookId);
    }

    @Override
    public Book updateBook(Book book) {
        return this.bookRepository.updateBook(book);
    }

}
