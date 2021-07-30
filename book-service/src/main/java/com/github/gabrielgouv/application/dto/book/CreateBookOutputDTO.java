package com.github.gabrielgouv.application.dto.book;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.github.gabrielgouv.microservice.core.util.DateUtil;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Setter
@Schema(name="CreateBookOutputDTO", description="Created book model")
public class CreateBookOutputDTO {

    private String id;
    private LocalDateTime createdAt;
    private String title;
    private String description;
    private BigDecimal price;
    private String isbn;

    @Schema(description="Book generated ID")
    public String getId() {
        return id;
    }

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DateUtil.DEFAULT_DATE_TIME_FORMAT)
    @Schema(description="Book created date")
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    @Schema(description="Book name")
    public String getTitle() {
        return title;
    }

    @Schema(description="Book description")
    public String getDescription() {
        return description;
    }

    @Schema(description="Book price", type = "string")
    public BigDecimal getPrice() {
        return price;
    }

    @Schema(description="Book ISBN code")
    public String getIsbn() {
        return isbn;
    }

}
