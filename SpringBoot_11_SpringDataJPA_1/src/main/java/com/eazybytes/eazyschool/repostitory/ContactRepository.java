package com.eazybytes.eazyschool.repostitory;

import java.security.Timestamp;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.stereotype.Repository;

import com.eazybytes.eazyschool.model.Contact;
import com.eazybytes.eazyschool.rowmapper.ContactRowMapper;

@Repository
public interface ContactRepository extends CrudRepository<Contact, Integer>{
	public List<Contact> findByStatus(String status);
}
