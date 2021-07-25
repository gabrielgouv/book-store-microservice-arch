package com.github.gabrielgouv.application.mapper;

import com.github.gabrielgouv.application.dto.book.CreateBookInputDTO;
import com.github.gabrielgouv.application.dto.book.CreateBookOutputDTO;
import com.github.gabrielgouv.application.dto.book.UpdateBookInputDTO;
import com.github.gabrielgouv.application.dto.book.UpdateBookOutputDTO;
import com.github.gabrielgouv.domain.entity.Book;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BookMapper {

    BookMapper INSTANCE = Mappers.getMapper(BookMapper.class);

    Book createBookInputDtoToBook(CreateBookInputDTO createBookInputDTO);
    CreateBookOutputDTO bookToCreateBookOutputDto(Book book);
    Book updateBookInputDtoToBook(UpdateBookInputDTO updateBookInputDTO);
    UpdateBookOutputDTO bookToUpdateBookOutputDTO(Book book);

}
