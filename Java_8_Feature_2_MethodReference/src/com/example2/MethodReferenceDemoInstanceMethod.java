package com.example2;

import com.example1.model.Employee;
import com.example1.service.EmployeeService;

/*
 * Passing a method as a argument is called as method reference
 * In this instance method of MethodReference is shown
 */
public class MethodReferenceDemoInstanceMethod {
	
	public void printEmployee(Employee emp) {
		System.out.println(emp);
	}
	
	public static void main(String[] args) {
		
		EmployeeService service = new EmployeeService();
		MethodReferenceDemoInstanceMethod currInstance = new MethodReferenceDemoInstanceMethod();
		
		service.getEmployeeList()
			.forEach(currInstance :: printEmployee);
	}
}
