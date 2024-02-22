package com.eazybytes.eazyschool.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @RequestMapping(value={"", "/", "/home"})
    public String displayHomePage(Model model) {
    	
    	System.out.println(DateTimeFormatter.ofPattern("dd-MMMM-yyyy").format(LocalDateTime.now()).toString());
    	model.addAttribute("todayDate", DateTimeFormatter.ofPattern("dd-MMMM-yyyy").format(LocalDateTime.now()).toString());
        return "home.html";
    }

    public static void main(String[] args) {
//		System.out.println(LocalDateTime.now());
//		DateTimeFormatter.ofPattern("dd-MMM-yyy");
//		System.out.println(LocalDateTime.parse(LocalDateTime.now().toString(), DateTimeFormatter.ofPattern("dd-MMM-yyy")));
//	
		System.out.println(LocalDateTime.now());
		System.out.println(DateTimeFormatter.ofPattern("dd-MMMM-yyyy").format(LocalDateTime.now()));
	}
}
