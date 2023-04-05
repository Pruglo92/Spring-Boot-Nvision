package com.example.SpringBootNvision.config;


import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(info = @Info(title = "SPRING BOOT NVISION", version = "v1"))
public class SwaggerConfig {
}
