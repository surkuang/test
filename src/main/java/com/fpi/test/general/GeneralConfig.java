package com.fpi.test.general;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class GeneralConfig {

    public WebMvcConfigurer corsConfigurer(){
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/*")
                        .allowedOrigins("*")
                        .allowCredentials(true)
                        .allowedMethods("GET","POST","DELETE")
                        .maxAge(3600);
            }
        };
    }
}
