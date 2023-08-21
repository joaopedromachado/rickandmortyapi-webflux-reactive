package br.com.rickandmorty.config;

import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.config.CorsRegistry;
import org.springframework.web.reactive.config.WebFluxConfigurationSupport;

@Configuration
public class WebConfig extends WebFluxConfigurationSupport {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // Define o padrão de URL que deseja permitir
                .allowedOrigins("*")    // Define as origens permitidas. Aqui, permitindo de qualquer origem
                .allowedMethods("GET", "POST", "PUT", "DELETE") // Métodos HTTP permitidos
                .allowedHeaders("*");    // Headers permitidos
    }
}
