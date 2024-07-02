package com.alurachallenges.forohub.forumengineapi.Infrastructure.Springdoc;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.media.ArraySchema;
import io.swagger.v3.oas.models.media.Schema;
import io.swagger.v3.oas.models.media.StringSchema;
import io.swagger.v3.oas.models.security.SecurityScheme;
import java.util.List;
import org.springdoc.core.customizers.OpenApiCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringDocConfiguration {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .components(new Components()
                        .addSecuritySchemes("bearer-key",
                                new SecurityScheme()
                                        .type(SecurityScheme.Type.HTTP)
                                        .scheme("bearer")
                                        .bearerFormat("JWT")))
                .info(new Info()
                        .title("Forum Engine API")
                        .version("1.0")
                        .description("Documentación de la API Forum Engine")
                        .contact(new Contact()
                                .name("{ Dev</>Code } Informatic Solutions")
                                .email("marianomaldonado-dev@dev.code.com"))
                        .license(new License()
                                .name("MIT License")
                                .url("http://forum-engine/api/license")));
    }
    public void message(){
        System.out.println("Working bearer port 666");
    }
}   // http://localhost:666/swagger-ui.html