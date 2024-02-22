package com.example1.service;

import java.util.ArrayList;
import java.util.List;

import com.example1.model.Employee;

public class EmployeeService {
	public List<Employee> getEmployeeList() {
		
		List<Employee> lst = new ArrayList<Employee>();
		
		for(int i=0; i<5 ; i++) {
			Employee emp = new Employee();
			emp.setEmpId(i);
			emp.setEmpName("EMP"+i);
			emp.setEmpAddress("40000"+i);
			lst.add(emp);
		}
		
		return lst;
	}
}
