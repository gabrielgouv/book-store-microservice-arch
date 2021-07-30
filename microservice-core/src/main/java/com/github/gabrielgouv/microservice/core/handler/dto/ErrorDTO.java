package com.github.gabrielgouv.microservice.core.handler.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.github.gabrielgouv.microservice.core.util.DateUtil;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class ErrorDTO {

    private final String code;

    private final String message;

    private final String details;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DateUtil.DEFAULT_DATE_TIME_FORMAT)
    private final LocalDateTime at;

}
