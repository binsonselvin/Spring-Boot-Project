package com.eazybytes.eazyschool;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
 * This project explains @RequestScope on ContactService class
 * which contains a counter which increments on every request 
 * as this is a RequestScope a new bean of ContactController is created 
 * every time a request comes and counter does not increase after 1 as
 * the new bean created sets the counter value to 0
 * 
 */
@SpringBootApplication
public class EazyschoolApplication {
	public static void main(String[] args) {
		SpringApplication.run(EazyschoolApplication.class, args);
	}
}
