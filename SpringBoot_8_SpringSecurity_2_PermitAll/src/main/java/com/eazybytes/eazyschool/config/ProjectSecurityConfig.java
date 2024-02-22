package com.eazybytes.eazyschool.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class ProjectSecurityConfig {

	@Bean
	SecurityFilterChain customSecuriyFilterChain(HttpSecurity http) throws Exception {
//		http.authorizeHttpRequests(requests-> 
//			requests.anyRequest().permitAll())
//			.formLogin(Customizer.withDefaults())
//			.httpBasic(Customizer.withDefaults());
		
		http.authorizeHttpRequests(requests-> 
			requests.anyRequest().denyAll())
			.formLogin(Customizer.withDefaults())
			.httpBasic(Customizer.withDefaults());
		
		return http.build();
	}
}
