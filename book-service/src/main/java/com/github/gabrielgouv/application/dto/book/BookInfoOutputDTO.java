package com.github.gabrielgouv.application.dto.book;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Schema(name="BookInfoOutputDTO", description="Book info")
public class BookInfoOutputDTO {

    @Schema(description="Book ID")
    private String id;

    @Schema(description="Book title")
    private String title;

    @Schema(description="Book description")
    private String description;

    @Schema(description="Book price", type = "string")
    private BigDecimal price;

    @Schema(description="Book ISBN code")
    private String isbn;

}
