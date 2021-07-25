package com.github.gabrielgouv.domain.repository;

import com.github.gabrielgouv.domain.entity.Book;

public interface BookRepository {

    Book persistBook(Book book);

    boolean deleteBook(String bookId);

    Book updateBook(Book book);

}
