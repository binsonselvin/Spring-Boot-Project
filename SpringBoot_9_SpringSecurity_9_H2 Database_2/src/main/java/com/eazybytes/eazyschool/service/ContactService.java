package com.eazybytes.eazyschool.service;

import com.eazybytes.eazyschool.constants.EazySchoolConstants;
import com.eazybytes.eazyschool.model.Contact;
import com.eazybytes.eazyschool.repostitory.ContactRepository;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;

import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.ApplicationScope;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.context.annotation.SessionScope;

/*
@Slf4j, is a Lombok-provided annotation that will automatically generate an SLF4J
Logger static property in the class at compilation time.
* */
@Slf4j
@Service
@ApplicationScope
public class ContactService {

	ContactRepository contactRepository;
	
	@Autowired
	public ContactService(ContactRepository repository) {
		System.out.println("Contact Service bean initialized");
		this.contactRepository = repository;
	}
	
	//to check request scope by incrementing for every request
	private int contactPageCallCounter = 0;
	
    public int getContactPageCallCounter() {
		return contactPageCallCounter;
	}

	public void setContactPageCallCounter(int contactPageCallCounter) {
		this.contactPageCallCounter = contactPageCallCounter;
	}

	/**
     * Save Contact Details into DB
     * @param contact
     * @return boolean
     */
    public boolean saveMessageDetails(Contact contact){
        boolean isSaved = false;
        System.out.println("SaveMsg Triggered");
        System.out.println("Contact Counter: "+getContactPageCallCounter());
        
        contact.setCreatedAt(LocalDateTime.now());
        contact.setCreatedBy(EazySchoolConstants.ANONYMOUS);
        contact.setStatus(EazySchoolConstants.OPEN);
        
        int count = contactRepository.saveContactMsg(contact);
        if(count > 0) {
        	isSaved = true;
        }
        
        System.out.println("Data Saved: "+isSaved);
        //TODO - Need to persist the data into the DB table
        log.info(contact.toString());
        return isSaved;
    }

}
