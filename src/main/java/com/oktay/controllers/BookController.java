package com.oktay.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author oktay
 *
 */
@Controller
public class BookController {
	
	@RequestMapping(value="/list_books" , method = RequestMethod.GET)
	public String loadHomePage() {
		
		return "books";
	}
}
