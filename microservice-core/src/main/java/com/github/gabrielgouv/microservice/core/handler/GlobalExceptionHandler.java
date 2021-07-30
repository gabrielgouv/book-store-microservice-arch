package com.github.gabrielgouv.microservice.core.handler;

import com.github.gabrielgouv.microservice.core.handler.dto.ErrorDTO;
import io.micronaut.context.annotation.Requires;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.annotation.Produces;
import io.micronaut.http.server.exceptions.ExceptionHandler;
import lombok.extern.slf4j.Slf4j;

import javax.inject.Singleton;

@Slf4j
@Produces
@Singleton
@Requires(classes = { Throwable.class, ExceptionHandler.class })
public class GlobalExceptionHandler implements ExceptionHandler<Throwable, HttpResponse<?>> {

    @Override
    public HttpResponse<?> handle(HttpRequest request, Throwable exception) {
        log.error("GlobalExceptionHandler catch message={}, cause={}, path={}",
                exception.getMessage(), exception.getCause(), request.getPath());
        final ErrorDTO errorDTO = ErrorDTO.builder()
                .code("GLOBAL")
                .message("An error occurred")
                .details(exception.getMessage())
                .build();
        return HttpResponse.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorDTO);
    }

}
