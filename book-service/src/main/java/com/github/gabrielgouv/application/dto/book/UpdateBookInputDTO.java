package com.github.gabrielgouv.application.dto.book;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Schema(name="UpdateBookInputDTO", description="Update book model")
public class UpdateBookInputDTO {

    private String id;
    private String title;
    private String description;
    private BigDecimal price;
    private String isbn;

    @Schema(description="Updated book ID")
    public String getId() {
        return id;
    }

    @Schema(description="Book name")
    public String getTitle() {
        return title;
    }

    @Schema(description="Book description")
    public String getDescription() {
        return description;
    }

    @Schema(description="Book price")
    public BigDecimal getPrice() {
        return price;
    }

    @Schema(description="Book ISBN code")
    public String getIsbn() {
        return isbn;
    }

}
