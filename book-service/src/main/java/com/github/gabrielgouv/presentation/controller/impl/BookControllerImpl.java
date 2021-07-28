package com.github.gabrielgouv.presentation.controller.impl;

import com.github.gabrielgouv.application.dto.book.*;
import com.github.gabrielgouv.application.service.BookApplicationService;
import com.github.gabrielgouv.presentation.controller.BookController;
import io.micronaut.http.HttpResponse;

import javax.inject.Inject;
import java.util.List;
import java.util.Optional;

public class BookControllerImpl implements BookController {

    private final BookApplicationService bookApplicationService;

    @Inject
    public BookControllerImpl(final BookApplicationService bookApplicationService) {
        this.bookApplicationService = bookApplicationService;
    }

    @Override
    public HttpResponse<CreateBookOutputDTO> createBook(CreateBookInputDTO createBookInputDTO) {
        return HttpResponse.ok(bookApplicationService.createBook(createBookInputDTO));
    }

    @Override
    public HttpResponse<DeleteBookOutputDTO> deleteBook(String bookId) {
        return HttpResponse.ok(bookApplicationService.deleteBook(bookId));
    }

    @Override
    public HttpResponse<UpdateBookOutputDTO> updateBook(UpdateBookInputDTO updateBookInputDTO) {
        return HttpResponse.ok(bookApplicationService.updateBook(updateBookInputDTO));
    }

    @Override
    public HttpResponse<List<BookInfoOutputDTO>> getAllBooks() {
        return HttpResponse.ok(bookApplicationService.getAllBooks());
    }

    @Override
    public HttpResponse<BookInfoOutputDTO> getBook(String bookId) {
        final Optional<BookInfoOutputDTO> bookInfoOutputDTO = bookApplicationService.getBook(bookId);
        if (bookInfoOutputDTO.isPresent()) {
            return HttpResponse.ok(bookInfoOutputDTO.get());
        }
        return HttpResponse.notFound();
    }

}
