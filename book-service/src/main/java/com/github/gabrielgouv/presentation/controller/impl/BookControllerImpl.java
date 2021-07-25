package com.github.gabrielgouv.presentation.controller.impl;

import com.github.gabrielgouv.application.dto.book.*;
import com.github.gabrielgouv.application.service.BookApplicationService;
import com.github.gabrielgouv.presentation.controller.BookController;
import io.micronaut.http.annotation.*;

import javax.inject.Inject;


@Controller("/books")
public class BookControllerImpl implements BookController {

    private final BookApplicationService bookApplicationService;

    @Inject
    public BookControllerImpl(final BookApplicationService bookApplicationService) {
        this.bookApplicationService = bookApplicationService;
    }

    @Post
    @Override
    public CreateBookOutputDTO createBook(@Body CreateBookInputDTO createBookInputDTO) {
        System.out.println(createBookInputDTO);
        return bookApplicationService.createBook(createBookInputDTO);
    }

    @Delete("/{bookId}")
    @Override
    public DeleteBookOutputDTO deleteBook(@PathVariable String bookId) {
        return bookApplicationService.deleteBook(bookId);
    }

    @Put
    @Override
    public UpdateBookOutputDTO updateBook(@Body UpdateBookInputDTO updateBookInputDTO) {
        return bookApplicationService.updateBook(updateBookInputDTO);
    }

}
