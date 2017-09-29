package com.oktay.controllers;

import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONObject;
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
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/list_books" , method = RequestMethod.GET, headers="Accept= application/json")
	public@ResponseBody ResponseEntity<Object> getListBooks() {
		
		List<Book> listBooks=bookService.getAllBooks();
		
		List<JSONObject> books = new ArrayList<JSONObject>();
		
	    for (Book b: listBooks) {
	        JSONObject book = new JSONObject();
	        book.put("id", b.getId());
	        book.put("book_name", b.getBook_name());
	        book.put("isbn", b.getISBN());
	        book.put("publish_year", b.getPublish_year());
	        book.put("publisher", b.getPublisher());
	        book.put("status", b.getStatus());
	        
	        books.add(book);
	    }
		return new ResponseEntity<Object>(books,HttpStatus.OK);
		

	}
	
	@RequestMapping(value="/add_books" , method = RequestMethod.POST, headers="Accept= application/json")
	public ResponseEntity<Book> addBooks(@RequestBody Book book){
		
		bookService.addBook(book);
		HttpHeaders header=new HttpHeaders();
		
		return new ResponseEntity<Book>(header,HttpStatus.CREATED);

	}

}
