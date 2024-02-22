package com.eazybytes.eazyschool.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Description;
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
				.requestMatchers("home","","/").authenticated()
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
	@Description("This bean uses deprecated method of password not use for production application")
	public InMemoryUserDetailsManager userDetailManager() {
		UserDetails user = User.withDefaultPasswordEncoder()
				.username("root1")
				.password("root")
				.roles("USER")
				.build();
		
		UserDetails admin = User.withDefaultPasswordEncoder()
				.username("skadmin")
				.password("root")
				.roles("ADMIN")
				.build();
		
		return new InMemoryUserDetailsManager(user, admin);
	}
}
