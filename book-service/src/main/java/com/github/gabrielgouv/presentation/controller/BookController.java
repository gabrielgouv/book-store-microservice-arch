package com.github.gabrielgouv.presentation.controller;

import com.github.gabrielgouv.application.dto.book.*;

public interface BookController {

    CreateBookOutputDTO createBook(CreateBookInputDTO createBookInputDTO);

    DeleteBookOutputDTO deleteBook(String bookId);

    UpdateBookOutputDTO updateBook(UpdateBookInputDTO updateBookInputDTO);

}
