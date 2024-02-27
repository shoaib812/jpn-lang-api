package com.nihongo.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(
    info = @Info(
            title = "NIHONGO API",
            description = "Doing CRUD Operation",
            summary = "This is NIHONGO api",
            termsOfService = "T&C",
            contact = @Contact(
                    name = "ProgRank",
                    email = "help.nihongo@gmail.com"
            ),
            license = @License (
                    name = "Your License No"
            ),
            version = "v1"
    ),
        servers = {
            @Server(
                    description = "Dev",
                    url = "http://localhost:8080"
            ),
            @Server(
                    description = "Test",
                    url = "http://localhost:8080"
            )
       }
)

public class SwaggerConfig {
}
