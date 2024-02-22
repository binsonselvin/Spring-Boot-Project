package com.eazybytes.eazyschool.repostitory;

import java.security.Timestamp;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.stereotype.Repository;

import com.eazybytes.eazyschool.model.Contact;
import com.eazybytes.eazyschool.rowmapper.ContactRowMapper;

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

	public List<Contact> findMsgsWithOpenStatus(String status) {
		
		String sql = "SELECT * FROM CONTACT_MSG where STATUS=?";
		List<Contact> contactList = this.jdbcTemplate.query(sql, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, status);
			}
		}, new ContactRowMapper());
		
		return contactList;
	}

	public int closeContactMessage(int contactId, String updatedBy, String status) {
		String sql = "UPDATE CONTACT_MSG SET STATUS=?, UPDATED_AT=?, UPDATED_BY=? WHERE CONTACT_ID=?";
		return this.jdbcTemplate.update(sql, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, status);
				ps.setTimestamp(2, java.sql.Timestamp.valueOf(LocalDateTime.now()));
				ps.setString(3, updatedBy);
				ps.setInt(4, contactId);
			}
		});
	}
	
}
