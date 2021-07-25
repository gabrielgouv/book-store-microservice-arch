package com.github.gabrielgouv.presentation.controller.impl;

import com.github.gabrielgouv.application.dto.book.*;
import com.github.gabrielgouv.application.service.BookApplicationService;
import com.github.gabrielgouv.presentation.controller.BookController;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.*;

import javax.inject.Inject;


@Controller("/books")
public class BookControllerImpl implements BookController {

    private final BookApplicationService bookApplicationService;

    @Inject
    public BookControllerImpl(final BookApplicationService bookApplicationService) {
        this.bookApplicationService = bookApplicationService;
    }

    @Post(consumes = MediaType.APPLICATION_JSON, produces = MediaType.APPLICATION_JSON)
    @Override
    public HttpResponse<CreateBookOutputDTO> createBook(@Body CreateBookInputDTO createBookInputDTO) {
        return HttpResponse.ok(bookApplicationService.createBook(createBookInputDTO));
    }

    @Delete(uri = "/{bookId}", produces = MediaType.APPLICATION_JSON)
    @Override
    public HttpResponse<DeleteBookOutputDTO> deleteBook(@PathVariable String bookId) {
        return HttpResponse.ok(bookApplicationService.deleteBook(bookId));
    }

    @Put(produces = MediaType.APPLICATION_JSON)
    @Override
    public HttpResponse<UpdateBookOutputDTO> updateBook(@Body UpdateBookInputDTO updateBookInputDTO) {
        return HttpResponse.ok(bookApplicationService.updateBook(updateBookInputDTO));
    }

}
