package com.github.gabrielgouv.domain.service;

import com.github.gabrielgouv.domain.entity.Book;

public interface BookDomainService {

    Book createBook(Book book);

    boolean deleteBook(String bookId);

    Book updateBook(Book book);

}
