package com.eazybytes.eazyschool.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eazybytes.eazyschool.model.Holiday;
import com.eazybytes.eazyschool.repostitory.HolidayRepository;

@Service
public class HolidayService {
	
	HolidayRepository holidayRepo;
	
	@Autowired
	public HolidayService(HolidayRepository repo) {
		this.holidayRepo = repo;
	}
	
	public List<Holiday> getAllHolidays() {
		return holidayRepo.getHolidayList();
	}
}
