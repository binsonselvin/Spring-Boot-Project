package com.eazybytes.eazyschool.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class ProjectSecurityConfig {

	@Bean
	SecurityFilterChain customSecuriyFilterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests((requests) -> requests
				.requestMatchers("home","","/").permitAll()
				.requestMatchers("/courses").permitAll()
				.requestMatchers("/about").permitAll()
				.requestMatchers("/courses").permitAll()
				.requestMatchers("/contact").permitAll()
				.requestMatchers("/saveMsg").permitAll()
				.requestMatchers("/holidays/**").permitAll()
				.requestMatchers("/assets/**").permitAll())
				.formLogin(Customizer.withDefaults())
				.httpBasic(Customizer.withDefaults());
		
		return http.build();
	}
	
	@Bean
	public InMemoryUserDetailsManager userDetailService() {
		
		UserDetails details = User.withDefaultPasswordEncoder()
				.username("root1")
				.password("root")
				.roles("USER")
				.build();
		
		UserDetails skadmin = User.withDefaultPasswordEncoder()
				.username("skadmin")
				.password("root")
				.roles("ADMIN")
				.build();
		
		
		return new InMemoryUserDetailsManager(details, skadmin);
	}
}
