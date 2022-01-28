package com.cos.Link;


import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry){
        registry.addMapping("/**") /*허용할 API 호출 주소 패턴*/
                .allowedOrigins("http://localhost:3000") /*허용할 CALLER*/
                .allowedMethods("GET", "POST", "PUT", "DELETE"); /*허용할 METHODS*/
    }
}
