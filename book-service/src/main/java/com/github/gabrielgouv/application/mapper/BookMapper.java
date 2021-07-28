package com.github.gabrielgouv.application.mapper;

import com.github.gabrielgouv.application.dto.book.*;
import com.github.gabrielgouv.domain.entity.Book;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface BookMapper {

    BookMapper INSTANCE = Mappers.getMapper(BookMapper.class);

    Book createBookInputDtoToBook(CreateBookInputDTO createBookInputDTO);

    CreateBookOutputDTO bookToCreateBookOutputDto(Book book);

    Book updateBookInputDtoToBook(UpdateBookInputDTO updateBookInputDTO);

    UpdateBookOutputDTO bookToUpdateBookOutputDTO(Book book);

    List<BookInfoOutputDTO> bookToBookInfoOutputDto(List<Book> books);

    BookInfoOutputDTO bookToBookInfoOutputDto(Book book);

}
