package com.eazybytes.eazyschool;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
 * This project explain the custom security chain override of default behavior of spring security i.e 
 * we can use httpSecurity.requestMatchers("urlpath").permitAll() to allow specific requests and 
 * specific request to authenticated in our web application
 */
@SpringBootApplication
public class EazyschoolApplication {
	public static void main(String[] args) {
		SpringApplication.run(EazyschoolApplication.class, args);
	}
}
