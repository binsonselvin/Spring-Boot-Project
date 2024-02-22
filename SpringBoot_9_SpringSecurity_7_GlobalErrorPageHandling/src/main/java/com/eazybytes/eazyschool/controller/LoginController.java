package com.eazybytes.eazyschool.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
	
	@RequestMapping(value="/login", method = {RequestMethod.GET,RequestMethod.POST})
	public String displayLoginPage(Model model, @RequestParam(value="error", required = false) String error , @RequestParam(value="logout", required = false) String logout) {
		System.out.println("Hit /login");
		String errorMessage = null;
		
		if(error!=null) {
			System.out.println("Binson Selvin");
			errorMessage = "Username or Password is incorrect";
		} 
		
		if(logout != null) {
			System.out.println("Binson Selvin1");
			errorMessage = "You are successfully logged out";
		}
		
		model.addAttribute("errorMessage", errorMessage);
		
		return "login";
	}
}
