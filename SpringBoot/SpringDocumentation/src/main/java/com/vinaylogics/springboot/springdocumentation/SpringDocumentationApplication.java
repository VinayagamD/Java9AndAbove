package com.vinaylogics.springboot.springdocumentation;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(
        title = "Spring Documentation Example",
        version = "1.0",
        description = "Testing Open API Documentation with Spring Boot Application"
))
public class SpringDocumentationApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringDocumentationApplication.class, args);
    }
}
