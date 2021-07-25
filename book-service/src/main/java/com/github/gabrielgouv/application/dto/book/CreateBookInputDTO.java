package com.github.gabrielgouv.application.dto.book;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class CreateBookInputDTO {

    private String title;
    private String description;
    private BigDecimal price;

}
