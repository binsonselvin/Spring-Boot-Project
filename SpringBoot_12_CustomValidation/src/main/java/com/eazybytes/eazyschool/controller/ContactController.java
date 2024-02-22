package com.eazybytes.eazyschool.controller;

import com.eazybytes.eazyschool.model.Contact;
import com.eazybytes.eazyschool.service.ContactService;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.servlet.ModelAndView;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.util.List;

@Slf4j
@Controller
public class ContactController {

    private final ContactService contactService;

    @Autowired
    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @RequestMapping("/contact")
    public String displayContactPage(Model model) {
    	model.addAttribute("contact", new Contact());
        return "contact.html";
    }

//    @RequestMapping(value = "/saveMsg",method = POST)
//    public ModelAndView saveMessage(@RequestParam String name, @RequestParam String mobileNum,
//                                    @RequestParam String email, @RequestParam String subject, @RequestParam String message) {
//        log.info("Name : " + name);
//        log.info("Mobile Number : " + mobileNum);
//        log.info("Email Address : " + email);
//        log.info("Subject : " + subject);
//        log.info("Message : " + message);
//        return new ModelAndView("redirect:/contact");
//    }

    @RequestMapping(value = "/saveMsg",method = POST)
    public String saveMessage(@Valid @ModelAttribute("contact") Contact contact, Errors errors){
    	
    	if(errors.hasErrors()) {
    		log.error("Contact validation failed due to "+errors.toString());
    		return "contact.html";
    	}
    	contactService.setContactPageCallCounter(contactService.getContactPageCallCounter()+1);
        contactService.saveMessageDetails(contact);
        return "redirect:/contact";
    }

    @RequestMapping("/displayMessages")
    public ModelAndView displayMessages(Model model) {
    	List<Contact> contactMsgs = contactService.findMsgsWithOpenStatus();
    	System.out.println("contactMessages: "+contactMsgs);
    	
    	ModelAndView modelView = new ModelAndView("messages.html");
    	modelView.addObject("contactMsgs", contactMsgs);
    	
    	return modelView;
    }

    @RequestMapping("/closeMsg")
    public ModelAndView closeMessage(@RequestParam("id") String contactId, Authentication authentication) {
    	boolean isClosed = contactService.closeContactMessage(contactId);
    	ModelAndView view = new ModelAndView("redirect:/contact");
    	
    	return view;
    }

}
