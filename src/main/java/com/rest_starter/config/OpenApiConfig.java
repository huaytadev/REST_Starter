package com.rest_starter.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class OpenApiConfig {
    @Bean
    public OpenAPI restStarterOpenApi() {
//        Server localServer = new Server()
//                .url("http://localhost:8080")
//                .description("Local development server");

        Contact contact = new Contact()
                .name("REST Starter API")
                .email("huaytadev@gmail.com");

        Info info = new Info()
                .title("REST Starter API")
                .version("1.0.0")
                .description("Professional REST API for product management with CRUD, validations, filtering, pagination and sorting.")
                .contact(contact);

        return new OpenAPI()
                .info(info);
//                .servers(List.of(localServer));
    }
}
