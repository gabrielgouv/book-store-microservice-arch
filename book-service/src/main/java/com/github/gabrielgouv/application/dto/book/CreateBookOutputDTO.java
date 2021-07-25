package com.github.gabrielgouv.application.dto.book;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class CreateBookOutputDTO {

    private String id;
    private String title;
    private String description;
    private BigDecimal price;
    private String isbn;

}
