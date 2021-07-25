package com.github.gabrielgouv.application.service;

import com.github.gabrielgouv.application.dto.book.*;

public interface BookApplicationService {

    CreateBookOutputDTO createBook(CreateBookInputDTO createBookInputDTO);

    DeleteBookOutputDTO deleteBook(String bookId);

    UpdateBookOutputDTO updateBook(UpdateBookInputDTO updateBookInputDTO);

}
