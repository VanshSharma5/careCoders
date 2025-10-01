package com._1shhub.carecoders.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") 
                .allowedOrigins( "https://dev.1shhub.com") // my subdomain 
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") 
                .allowedHeaders("*") 
                .allowCredentials(true) 
                .maxAge(1800); // Cache preflight request time in secs 
    }
}