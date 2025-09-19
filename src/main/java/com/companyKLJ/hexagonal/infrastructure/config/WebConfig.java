package com.companyKLJ.hexagonal.infrastructure.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//@Configuration
public class WebConfig /*implements WebMvcConfigurer*/ {

    /*@Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/api/120021081221/**")
                .allowedOrigins("http://127.0.0.1:5500")  // Reemplaza con la URL de tu frontend
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                .allowedHeaders("*");
    }*/
}
