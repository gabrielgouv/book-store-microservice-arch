package com.github.gabrielgouv.application.dto.book;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@Schema(name="DeleteBookOutputDTO", description="Delete book model")
public class DeleteBookOutputDTO {

    private boolean deleted;

    @Schema(description="Book deleted flag")
    public boolean isDeleted() {
        return deleted;
    }
}
