package com.github.gabrielgouv.microservice.core.entity;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class BaseEntity<ID> {

    private ID id;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;

}
