package com.example.beanvalidation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.binson.config, com.binson.controller,"
		+ "com.binson.service"})
public class BeanValidationApplication {

	public static void main(String[] args) {
		SpringApplication.run(BeanValidationApplication.class, args);
	}
}
