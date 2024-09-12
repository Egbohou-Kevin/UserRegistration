package com.supra.entretien.ClientRegister.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springframework.context.annotation.Configuration;
import io.swagger.v3.oas.annotations.info.Info;

/**
 * Configuration class to set global information about the Swagger, including title and security scheme.
 */
@Configuration
@OpenAPIDefinition(info = @Info(title = "userregister", version = "1.0"))
public class OpenAPIConfig {
}

