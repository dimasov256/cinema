package com.cinema.customer.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CORSConfig
		implements WebMvcConfigurer {

	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/api/**")
			.allowedMethods("GET","POST","PUT","DELETE","OPTIONS")
			.allowedOrigins("http://localhost:4201");
		System.out.println("Created CORD mapping" + CORSConfig.class);
		//TODO: Need to change the URL for the production URL when we deploy
	}


}
