package com.riwi.filtro.hector.filtro_riwi_hector.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                contact = @Contact(
                        name = "Hector Montaña",
                        url = "https://github.com/ralexale",
                        email = "hectoalemf@hotmail.com"
                ),
                title = "Documentation: riwi filtro",
                version = "1.0"
        )
)
public class SwaggerConfig {
}
