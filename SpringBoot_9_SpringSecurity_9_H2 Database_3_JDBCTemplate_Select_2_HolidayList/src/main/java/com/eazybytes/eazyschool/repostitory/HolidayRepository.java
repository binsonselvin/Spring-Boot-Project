package com.eazybytes.eazyschool.repostitory;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.eazybytes.eazyschool.model.Holiday;

@Repository
public class HolidayRepository {
	
	JdbcTemplate template;
	
	@Autowired
	public HolidayRepository(JdbcTemplate template) {
		this.template = template;
	}
	
	public List<Holiday> getHolidayList() {
		String sql = "select * from Holidays";
		var rowMapper = BeanPropertyRowMapper.newInstance(Holiday.class);
		return template.query(sql, rowMapper);
	}
}
