package com.jaisoft.faculty;

import io.micronaut.runtime.Micronaut;
import io.swagger.v3.oas.annotations.*;
import io.swagger.v3.oas.annotations.info.*;

@OpenAPIDefinition(
    info = @Info(
            title = "micronaut-springboot-rest-jpa-poc",
            version = "0.0"
    )
)
public class App {

    public static void main(String[] args) {
        Micronaut.run(App.class, args);
    }
}
