package com.github.gabrielgouv.domain.entity;

import com.github.gabrielgouv.bookstore.core.domain.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

@Data
@EqualsAndHashCode(callSuper = true)
public class Book extends BaseEntity<String> {

    private String title;
    private String description;
    private BigDecimal price;
    private String isbn;

}
