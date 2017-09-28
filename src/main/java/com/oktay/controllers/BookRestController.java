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
import org.springframework.web.bind.annotation.RestController;

import com.oktay.models.Book;
import com.oktay.service.BookService;

/**
 * @author oktay
 *
 */
@RestController
@RequestMapping("/rest")
public class BookRestController {

    public static final Logger logger = LoggerFactory.getLogger(BookRestController.class);
	
	@Autowired
	private BookService bookService;
	
	@RequestMapping(value="/list_books" , method = RequestMethod.GET, headers="Accept= application/json")
	public ResponseEntity<List<Book>> getListBooks(){
		
		List<Book> listBooks=bookService.getAllBooks();
		if(listBooks==null){
			return new ResponseEntity<List<Book>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Book>>(listBooks,HttpStatus.OK);

	}
	
	@RequestMapping(value="/add_books" , method = RequestMethod.POST, headers="Accept= application/json")
	public ResponseEntity<Book> addBooks(@RequestBody Book book){
		
		bookService.addBook(book);
		HttpHeaders header=new HttpHeaders();
		
		return new ResponseEntity<Book>(header,HttpStatus.CREATED);

	}

}
