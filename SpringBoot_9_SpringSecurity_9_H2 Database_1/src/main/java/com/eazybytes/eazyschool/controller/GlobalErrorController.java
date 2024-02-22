package com.eazybytes.eazyschool.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

/*
 * @ControllerAdvice is a specialized type of @Component annotation which allows to handle exceptions
 * across the whole application in one global handling component. Its like a interceptor which 
 * intercepts the exception thrown by methods annotated by @GetMapping & @Requestmapping likewise
 */
@ControllerAdvice
public class GlobalErrorController {

	/*
	 * @ExceptionHandler will register the given method for a given exception handler class
	 * eg. for NullPointerException we can create a method which accepts NullPointerException.
	 */
	@ExceptionHandler
	public ModelAndView handleAppException(Exception exception) {
		
		ModelAndView model = new ModelAndView();
		model.setViewName("error");
		model.addObject("errorMssg", exception.getMessage());
		
		return model;
	}
}
