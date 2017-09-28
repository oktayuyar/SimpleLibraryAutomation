package com.oktay.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.oktay.models.Author;
import com.oktay.service.AuthorService;

/**
 * @author oktay
 *
 */
@RestController
@RequestMapping("/rest")
public class AuthorRestController {
	
	public static final Logger logger = LoggerFactory.getLogger(AuthorRestController.class);

	@Autowired
	private AuthorService authorService;

	@RequestMapping(value="/list_authors" , method = RequestMethod.GET , headers="Accept= application/json")
	public @ResponseBody List<Author> getListAuthors() {
		List<Author> listAuthors=authorService.getAllAuthors();
		return listAuthors;
		
	}
	
	@RequestMapping(value="/add_authors" , method = RequestMethod.POST , headers="Accept= application/json")
	public ResponseEntity<Author> addBooks(@RequestBody Author author){
		
		authorService.addAuthor(author);
		HttpHeaders header=new HttpHeaders();
		
		return new ResponseEntity<Author>(header,HttpStatus.CREATED);

	}
}
