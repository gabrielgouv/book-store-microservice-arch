package com.github.gabrielgouv.application.dto.book;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class DeleteBookOutputDTO {

    private boolean deleted;

}
