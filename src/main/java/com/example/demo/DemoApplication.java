package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.config.CorsRegistry;

@SpringBootApplication
//@EnableWebMvc
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}


//	@Bean
//	public WebMvcConfigurer corsConfigurer() {
//		return new WebMvcConfigurerAdapter() {
//			@Override
//			public void addCorsMappings(CorsRegistry registry) {
//				registry.addMapping("/greeting-javaconfig").allowedOrigins("http://localhost:9000");
//			}
//		};
//	}
}


