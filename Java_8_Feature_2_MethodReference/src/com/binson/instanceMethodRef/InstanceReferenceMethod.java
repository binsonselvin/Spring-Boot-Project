package com.binson.instanceMethodRef;

public class InstanceReferenceMethod {

	public void sayHelloImpl(String username) {
		System.out.printf("Hello, %s",username);
	}
	
	public static void main(String[] args) {

		InstanceReferenceMethod myobj = new InstanceReferenceMethod();
		DemoInterface curObj = myobj :: sayHelloImpl;
		curObj.sayHello("Binson Selvin");
	}
}
