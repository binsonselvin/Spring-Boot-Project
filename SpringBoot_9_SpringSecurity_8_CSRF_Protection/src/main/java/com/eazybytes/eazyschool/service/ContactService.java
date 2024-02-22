package com.eazybytes.eazyschool.service;

import com.eazybytes.eazyschool.model.Contact;
import lombok.extern.slf4j.Slf4j;
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

	public ContactService() {
		System.out.println("Contact Service bean initialized");
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
        boolean isSaved = true;
        System.out.println("SaveMsg Triggered");
        System.out.println("Contact Counter: "+getContactPageCallCounter());
        //TODO - Need to persist the data into the DB table
        log.info(contact.toString());
        return isSaved;
    }

}
