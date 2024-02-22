package com.eazybytes.eazyschool.model;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
public class Person {
	@Id
    @GeneratedValue(strategy= GenerationType.AUTO,generator="native")
    @GenericGenerator(name = "native",strategy = "native")
    private int personId;
	private String username;
	private String email;
	private String confirmEmail;
	private String password;
	private String confirmPassword;
	private String mobileNum; 
}