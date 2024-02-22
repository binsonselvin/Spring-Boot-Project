package com.example1;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

import com.example1.model.Employee;
import com.example1.service.EmployeeService;

/*
 * Passing a method as a argument is called as method reference
 * In this class static method of MethodReference is shown
 */
public class MethodReferenceDemoStatic {
	
	public static void sayHelloImpl() {
		System.out.println("I am the interface implementation provided in MethodReferenceDemoStatic Class");
	}
	
	public static void main(String[] args) {
		DemoInterface myInterfaceImpl = MethodReferenceDemoStatic :: sayHelloImpl;
		myInterfaceImpl.sayHello();
	}
}
