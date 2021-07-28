package com.github.gabrielgouv.application.service;

import com.github.gabrielgouv.application.dto.book.*;

import java.util.List;
import java.util.Optional;

public interface BookApplicationService {

    CreateBookOutputDTO createBook(CreateBookInputDTO createBookInputDTO);

    DeleteBookOutputDTO deleteBook(String bookId);

    UpdateBookOutputDTO updateBook(UpdateBookInputDTO updateBookInputDTO);

    List<BookInfoOutputDTO> getAllBooks();

    Optional<BookInfoOutputDTO> getBook(String id);

}
