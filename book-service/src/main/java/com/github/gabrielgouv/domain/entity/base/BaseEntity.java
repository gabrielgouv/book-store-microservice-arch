package com.github.gabrielgouv.domain.entity.base;

import lombok.Data;

@Data
public class BaseEntity<T> {

    private T id;

}
