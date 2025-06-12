package com.vpc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class VpcApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(VpcApiApplication.class, args);
    }

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**") // en vez de solo /greeting-javaconfig
                        .allowedOrigins("http://localhost:3000") // aquí pones tu Next.js
                        .allowedMethods("*") // permite GET, POST, PUT, DELETE, OPTIONS, etc.
                        .allowedHeaders("*");
            }
        };
    }
}

