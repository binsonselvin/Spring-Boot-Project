package com.binson.App;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.binson.App","com.binson.controller",
		"com.binson.config", "com.binson.service"})
public class EazySchoolProjectHomePageApplication {

	public static void main(String[] args) {
		SpringApplication.run(EazySchoolProjectHomePageApplication.class, args);
	}
}
