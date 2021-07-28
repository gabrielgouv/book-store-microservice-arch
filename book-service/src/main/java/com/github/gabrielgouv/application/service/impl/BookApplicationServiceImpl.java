package com.github.gabrielgouv.application.service.impl;

import com.github.gabrielgouv.application.dto.book.*;
import com.github.gabrielgouv.application.mapper.BookMapper;
import com.github.gabrielgouv.application.service.BookApplicationService;
import com.github.gabrielgouv.domain.entity.Book;
import com.github.gabrielgouv.domain.service.BookDomainService;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.List;
import java.util.Optional;

@Singleton
public class BookApplicationServiceImpl implements BookApplicationService {

    private final BookDomainService bookDomainService;

    @Inject
    public BookApplicationServiceImpl(final BookDomainService bookDomainService) {
        this.bookDomainService = bookDomainService;
    }

    @Override
    public CreateBookOutputDTO createBook(final CreateBookInputDTO createBookInputDTO) {
        final Book bookToCreate = BookMapper.INSTANCE.createBookInputDtoToBook(createBookInputDTO);
        final Book createdBook = bookDomainService.createBook(bookToCreate);
        return BookMapper.INSTANCE.bookToCreateBookOutputDto(createdBook);
    }

    @Override
    public DeleteBookOutputDTO deleteBook(final String bookId) {
        final boolean isDeleted = bookDomainService.deleteBook(bookId);
        return DeleteBookOutputDTO.builder()
                .deleted(isDeleted)
                .build();
    }

    @Override
    public UpdateBookOutputDTO updateBook(final UpdateBookInputDTO updateBookInputDTO) {
        final Book bookToUpdate = BookMapper.INSTANCE.updateBookInputDtoToBook(updateBookInputDTO);
        final Book updatedBook = bookDomainService.updateBook(bookToUpdate);
        return BookMapper.INSTANCE.bookToUpdateBookOutputDTO(updatedBook);
    }

    @Override
    public List<BookInfoOutputDTO> getAllBooks() {
        List<Book> allBooks = bookDomainService.getAllBooks();
        return BookMapper.INSTANCE.bookToBookInfoOutputDto(allBooks);
    }

    @Override
    public Optional<BookInfoOutputDTO> getBook(String id) {
        final Optional<Book> book = bookDomainService.getBook(id);
        if (book.isEmpty()) {
            return Optional.empty();
        }
        BookInfoOutputDTO bookInfoOutputDTO = BookMapper.INSTANCE.bookToBookInfoOutputDto(book.get());
        return Optional.of(bookInfoOutputDTO);
    }

}
