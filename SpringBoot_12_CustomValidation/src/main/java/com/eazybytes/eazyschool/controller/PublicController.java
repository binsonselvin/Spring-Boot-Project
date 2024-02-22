package com.eazybytes.eazyschool.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.eazybytes.eazyschool.model.Person;

@Controller
@RequestMapping("/public")
public class PublicController {
	
	@RequestMapping("/register")
	public String getRegistrationPage(Model model) {
		model.addAttribute("person", new Person());
		return "register";
	}
}
