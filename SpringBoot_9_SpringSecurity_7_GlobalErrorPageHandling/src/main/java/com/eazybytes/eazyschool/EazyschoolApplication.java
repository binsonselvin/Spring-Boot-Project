package com.eazybytes.eazyschool;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
 * This project explain configuring and overriding default login page provided by spring security class 
 * refer ProjectSecurityConfig class the SecurityFilterChain formLogin().loginPage("/pathToLogin") method
 * hits the path and loads the login custom login page 
 *  
 *  refer ProjectSecurityConfig.java file
 */
@SpringBootApplication
public class EazyschoolApplication {
	public static void main(String[] args) {
		SpringApplication.run(EazyschoolApplication.class, args);
	}
}
