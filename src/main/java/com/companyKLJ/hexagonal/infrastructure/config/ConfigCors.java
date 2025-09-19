package com.companyKLJ.hexagonal.infrastructure.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class ConfigCors {
    @Bean
    public CorsFilter corsFilter(){
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);
        config.addAllowedOrigin("http://localhost:5500"); // Agrega los orígenes permitidos
        config.addAllowedHeader("*"); // Permite todos los headers
        config.addAllowedMethod("GET, POST, DELETE, PUT"); // Permite todos los métodos (GET, POST, etc.)
        source.registerCorsConfiguration("/api/120021081221/**", config); // Aplica esta configuración a todos los endpoints
        return new CorsFilter(source);
    }
}
