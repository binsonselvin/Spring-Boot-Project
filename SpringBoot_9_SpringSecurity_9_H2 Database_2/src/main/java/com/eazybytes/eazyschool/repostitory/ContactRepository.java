package com.eazybytes.eazyschool.repostitory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.eazybytes.eazyschool.model.Contact;

@Repository
public class ContactRepository {
	
	JdbcTemplate jdbcTemplate;
	
	@Autowired
	public ContactRepository(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public int saveContactMsg(Contact contact) {
		String sql = "INSERT INTO CONTACT_MSG(NAME, MOBILE_NUM, EMAIL, SUBJECT, MESSAGE, STATUS,"
				+ "CREATED_AT, CREATED_BY) VALUES (?,?,?,?,?,?,?,?)";
		
		return jdbcTemplate.update(sql, contact.getName(), contact.getMobileNum(), contact.getEmail(),
					contact.getSubject(), contact.getMessage(), contact.getStatus(), contact.getCreatedAt(),
					contact.getCreatedBy());
	}
	
}
