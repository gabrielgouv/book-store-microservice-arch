package com.github.gabrielgouv.presentation.controller;

import com.github.gabrielgouv.application.dto.book.*;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.*;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@Controller("/books")
public interface BookController {

    /**
     * @param createBookInputDTO Book model to register a new book
     * @return Created book with generated ID
     */
    @Post(consumes = MediaType.APPLICATION_JSON, produces = MediaType.APPLICATION_JSON)
    @Tag(name = "Books")
    @ApiResponse(responseCode = "400", description = "Invalid model")
    HttpResponse<CreateBookOutputDTO> createBook(@Body CreateBookInputDTO createBookInputDTO);

    /**
     * @param bookId ID of the book to remove
     * @return A object with delete confirmation
     */
    @Delete(uri = "/{bookId}", produces = MediaType.APPLICATION_JSON)
    @Tag(name = "Books")
    @ApiResponse(responseCode = "400", description = "Invalid parameter")
    HttpResponse<DeleteBookOutputDTO> deleteBook(@PathVariable String bookId);

    /**
     * @param updateBookInputDTO Book model to update
     * @return Updated book
     */
    @Put(produces = MediaType.APPLICATION_JSON)
    @Tag(name = "Books")
    @ApiResponse(responseCode = "400", description = "Invalid model")
    @ApiResponse(responseCode = "404", description = "Book not found")
    HttpResponse<UpdateBookOutputDTO> updateBook(@Body UpdateBookInputDTO updateBookInputDTO);

}
