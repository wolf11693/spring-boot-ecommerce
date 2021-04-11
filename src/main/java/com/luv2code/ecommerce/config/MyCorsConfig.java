package com.luv2code.ecommerce.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyCorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry
                .addMapping("/**")
                .allowedOrigins("*")
                .allowedMethods("PUT", "DELETE", "GET", "POST")
                .allowedHeaders("*")
                .exposedHeaders("header1", "header2")
                .allowCredentials(false)
                .maxAge(3600);
    }

    @Bean(name = "corsConfigurer")
    public WebMvcConfigurer getCorsConfigurer() {
        MyCorsConfig filterCorsConfig = new MyCorsConfig();

        return filterCorsConfig;
    }



}
