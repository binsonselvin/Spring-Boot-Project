package com.eazybytes.eazyschool;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

/*
 * This project explain configuring and overriding default login page provided by spring security class 
 * refer ProjectSecurityConfig class the SecurityFilterChain formLogin().loginPage("/pathToLogin") method
 * hits the path and loads the login custom login page 
 *  
 *  refer ProjectSecurityConfig.java file
 */
@SpringBootApplication
@EnableJpaRepositories(basePackages = {"com.eazybytes.eazyschool.repostitory"})
@EntityScan(basePackages = {"com.eazybytes.eazyschool.model"})
@EnableJpaAuditing(auditorAwareRef = "auditAwareImpl")
public class EazyschoolApplication {
	public static void main(String[] args) {
		SpringApplication.run(EazyschoolApplication.class, args);
	}
}
