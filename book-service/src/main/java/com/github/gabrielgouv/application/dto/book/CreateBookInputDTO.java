package com.github.gabrielgouv.application.dto.book;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Schema(name="CreateBookInputDTO", description="Create book model")
public class CreateBookInputDTO {

    private String title;
    private String description;
    private BigDecimal price;

    @Schema(description="Book name", required = true)
    public String getTitle() {
        return title;
    }

    @Schema(description="Book description", required = true)
    public String getDescription() {
        return description;
    }

    @Schema(description="Book price", required = true, type = "string")
    public BigDecimal getPrice() {
        return price;
    }

}
