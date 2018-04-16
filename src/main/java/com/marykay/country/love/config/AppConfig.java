package com.marykay.country.love.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

//import com.marykay.country.core.auth.AuthInterceptor;


/**
 * Created by wanwei on 16/9/6.
 */
@Configuration
@Order(0)
public class AppConfig extends WebMvcConfigurerAdapter {

//    @Autowired
//    private AuthInterceptor authInterceptor;
//
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(authInterceptor);
//    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**").allowedMethods("PUT", "DELETE","POST","GET");
    }
}
