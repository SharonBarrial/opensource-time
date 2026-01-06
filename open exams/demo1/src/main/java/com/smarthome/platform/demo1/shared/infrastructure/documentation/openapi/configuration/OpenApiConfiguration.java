package com.smarthome.platform.demo1.shared.infrastructure.documentation.openapi.configuration;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfiguration {
    @Bean
    public OpenAPI platformOpenApi() {
        // General configuration
        var openApi = new OpenAPI();
        openApi
                .info(new Info()
                        .title("Kaeser Platform API")
                        .description("This is the API documentation for the Platform .\n" +
                                "Platform is a platform that allows you to manage your .\n" +
                                "Created by Sharon Barrial, an software engineering student of UPC\n" +
                                "with a student code: u202114900.")
                        .version("v1.0.0")
                        .contact(new Contact().email("u202114900@upc.edu.pe"))
                        .license(new License().name("Apache 2.0")
                                .url("https://springdoc.org")))
                .externalDocs(new ExternalDocumentation()
                        .description("To Customize.")
                        .url("https://to-customize/docs"));


        // Return OpenAPI configuration object with all the settings

        return openApi;
    }
}
