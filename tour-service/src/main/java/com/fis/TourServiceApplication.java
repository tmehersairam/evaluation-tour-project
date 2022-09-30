package com.fis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = " Tour service", version = "1.0", description = "Api Endpoints for tour service"))
public class TourServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(TourServiceApplication.class, args);
	}
}
