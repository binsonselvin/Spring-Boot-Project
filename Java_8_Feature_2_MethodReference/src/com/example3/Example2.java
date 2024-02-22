package com.example3;

import java.util.function.BiFunction;

import com.example1.model.Employee;
import com.example1.service.EmployeeService;

public class Example2 {
	
	public static void main(String[] args) {
		
		EmployeeService service = new EmployeeService();

		//Employee object has been received
		DemoInterface emp = Employee :: new;
		
		System.out.println(emp==null);
	}
}
