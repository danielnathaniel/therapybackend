package com.example.therapybackend;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig {

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**") // Applies CORS settings to all endpoints
                        .allowedOrigins("http://localhost:4200") // Allow requests from Angular app
                        .allowedMethods("GET", "POST", "PUT", "DELETE") // Specify allowed HTTP methods
                        .allowedHeaders("*") // Allow all headers
                        .allowCredentials(true); // Optional, set to true if you need to send credentials like cookies
            }
        };
    }
}
