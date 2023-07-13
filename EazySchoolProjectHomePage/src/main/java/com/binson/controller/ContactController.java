package com.binson.controller;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.binson.model.Contact;
import com.binson.service.ContactService;

import ch.qos.logback.classic.joran.action.LoggerAction;

@Controller
public class ContactController {
	
	Logger logger = Logger.getLogger("ContactController");
	
	ContactService contactService;
	
	@Autowired
	public ContactController(ContactService contactService) {
		this.contactService = contactService;
	}
	
	@RequestMapping("/contact")
	public String displayContactPage() {
		return "contact.html";
	}
	
	
	
	/*
	@RequestMapping(value = "/saveMsg", method = {RequestMethod.POST} )
	public ModelAndView saveSchoolQueryform(@RequestParam String name, @RequestParam(name="mobileNum") String phoneno,
			@RequestParam(name="email") String email, @RequestParam(name="subject") String subject, @RequestParam(name="message") String query) {
		
		logger.info("Name: "+name);
		logger.info("phoneno: "+phoneno);
		logger.info("email: "+email);
		logger.info("subject: "+subject);
		logger.info("query: "+query);
		
		contactService.saveMessage()
		
		
		return new ModelAndView("redirect:/contact");
	}
	*/
	
	@RequestMapping(value = "/saveMsg", method = {RequestMethod.POST} )
	public ModelAndView saveSchoolQueryform(Contact contact) {
		
		contactService.saveMessage(contact); 
		
		return new ModelAndView("redirect:/contact");
	}
}
