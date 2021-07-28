package com.github.gabrielgouv.domain.repository;

import com.github.gabrielgouv.domain.entity.Book;

import java.util.List;
import java.util.Optional;

public interface BookRepository {

    Book persistBook(Book book);

    boolean deleteBook(String bookId);

    Book updateBook(Book book);

    List<Book> getAllBooks();

    Optional<Book> getBook(String id);

}
