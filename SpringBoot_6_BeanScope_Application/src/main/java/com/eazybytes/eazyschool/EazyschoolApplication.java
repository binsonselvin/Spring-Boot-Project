package com.eazybytes.eazyschool;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
 * This project explains @ApplicationScope on ContactService class
 * which contains a counter which increments when ContactService bean is initialized
 * as this is a ApplicationScope the bean of ContactController is created only once 
 * per application lifecycle
 */
@SpringBootApplication
public class EazyschoolApplication {
	public static void main(String[] args) {
		SpringApplication.run(EazyschoolApplication.class, args);
	}
}
