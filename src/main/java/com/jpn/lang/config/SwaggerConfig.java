package com.jpn.lang.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(
    info = @Info(
            title = "JPN LANG",
            description = "Doing CRUD Operation",
            summary = "This is JAPN LANG api",
            termsOfService = "T&C",
            contact = @Contact(
                    name = "ProgRank",
                    email = "help.jpnlang@gmail.com"
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
