package com.marykay.country.love;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by yangliu on 2018/4/8.
 */

@EnableAutoConfiguration
@SpringBootApplication()
@EnableCaching
@ComponentScan(basePackages = { "com.marykay.country.core", 
		"com.marykay.country.service",
		"com.marykay.country.love" })
public class Application extends SpringBootServletInitializer{
	
	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(Application.class);
    }
	
	public static void main(String[] args) {
		// APP Enter
		SpringApplication.run(Application.class, args);
		
	}
}