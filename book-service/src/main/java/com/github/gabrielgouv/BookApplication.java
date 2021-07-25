package com.github.gabrielgouv;

import io.micronaut.runtime.Micronaut;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;

@OpenAPIDefinition(
    info = @Info(
        title = "book-service",
        version = "1.0",
        description = "Book Service API",
        license = @License(name = "Apache 2.0", url = "https://github.com/gabrielgouv/book-store-microservice-example/tree/main/book-service"),
        contact = @Contact(url = "https://github.com/gabrielgouv", name = "Joao Gabriel Gouveia")
    )
)
public class BookApplication {

    public static void main(String[] args) {
        Micronaut.run(BookApplication.class, args);
    }

}
