package com.sigabem.apiCalculaFrete;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@SpringBootApplication
public class CalculaFreteApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(CalculaFreteApiApplication.class, args);
	}

}
