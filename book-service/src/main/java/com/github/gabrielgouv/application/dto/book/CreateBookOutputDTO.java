package com.github.gabrielgouv.application.dto.book;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.github.gabrielgouv.core.util.DateUtil;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class CreateBookOutputDTO {

    private String id;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DateUtil.DEFAULT_DATE_TIME_FORMAT)
    private LocalDateTime createdAt;

    private String title;

    private String description;

    private BigDecimal price;

    private String isbn;

}
