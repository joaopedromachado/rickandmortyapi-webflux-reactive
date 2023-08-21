package br.com.rickandmorty.config;


import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.config.EnableWebFlux;

@Configuration
@EnableWebFlux
public class SwaggerConfig  {


    @Bean
    public GroupedOpenApi publicApi() {
        return GroupedOpenApi.builder()
                .group("Rick And Morty API")
                .packagesToScan("br.com.rickandmorty.api.rest.v1")
                .pathsToMatch("/v1/rickandmorty/**")
                .build();
    }

    @Bean
    public OpenAPI openApi() {
        return new OpenAPI()
                .info(
                        new Info().title("Rick And Morty API")
                                .description("Lorem qlq coisa")
                                .version("v1.0.0")
                );
    }

}
