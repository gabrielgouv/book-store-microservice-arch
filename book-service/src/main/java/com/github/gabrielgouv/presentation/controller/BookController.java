package com.github.gabrielgouv.presentation.controller;

import com.github.gabrielgouv.application.dto.book.*;
import io.micronaut.http.HttpResponse;

public interface BookController {

    HttpResponse<CreateBookOutputDTO> createBook(CreateBookInputDTO createBookInputDTO);

    HttpResponse<DeleteBookOutputDTO> deleteBook(String bookId);

    HttpResponse<UpdateBookOutputDTO> updateBook(UpdateBookInputDTO updateBookInputDTO);

}
