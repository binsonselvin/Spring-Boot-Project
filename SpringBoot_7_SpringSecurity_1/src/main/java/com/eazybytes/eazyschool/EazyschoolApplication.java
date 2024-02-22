package com.eazybytes.eazyschool;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
 * This project explain the default behavior of spring security i.e 
 * just by adding the dependency spring secures all the pages inside the 
 * application by providing default login page
 */
@SpringBootApplication
public class EazyschoolApplication {
	public static void main(String[] args) {
		SpringApplication.run(EazyschoolApplication.class, args);
	}
}
