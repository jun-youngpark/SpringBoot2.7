package com.jyp.product.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {    //Cors 적용하기
        registry.addMapping("/health")
                .allowedMethods("GET")
                .allowedOrigins("http://localhost")
                .maxAge(3000);
    }
    
}
