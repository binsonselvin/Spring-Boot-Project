package com.binson.service;

import org.springframework.stereotype.Service;

import com.binson.model.Contact;

@Service
public class ContactService {

	public void saveMessage(Contact contact) {
		
		System.out.println("Contact: "+contact);
	}
}
