package com.github.gabrielgouv.domain.entity;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Book {

    private String id;
    private String title;
    private String description;
    private BigDecimal price;
    private String isbn;

}
