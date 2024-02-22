package com.eazybytes.eazyschool.controller;

import com.eazybytes.eazyschool.model.Holiday;
import com.eazybytes.eazyschool.service.HolidayService;

import jakarta.websocket.server.PathParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Controller
public class HolidaysController {

	HolidayService holidayService;
	
	public HolidaysController(HolidayService service) {
		this.holidayService = service;
	}
	
    @GetMapping("/holidays/{display}")
    public String displayHolidays(@PathVariable String display ,  Model model) {
    	System.out.println("display: "+display);
    	if(display!=null && display.equals("all")) {
    		System.out.println("all received");
    		model.addAttribute("festival",true);
            model.addAttribute("federal",true);
    	} else if(display!=null && display.equals("festival")) {
    		model.addAttribute("festival", true);
    	} else if(display!=null && display.equals("federal")) {
    		model.addAttribute("federal",true);
    	}
        List<Holiday> holidays = holidayService.getAllHolidays();
        
        Holiday.Type[] types = Holiday.Type.values();
        for (Holiday.Type type : types) {
            model.addAttribute(type.toString(),
                    (holidays.stream().filter(holiday -> holiday.getType().equals(type)).collect(Collectors.toList())));
        }
        return "holidays.html";
    }
}
