package com.oktay.service;

import java.util.List;

import com.oktay.models.Book;

/**
 * @author oktay
 *
 */
public interface BookService {
	
	public void addBook(Book book);

	public List<Book> getAllBooks();
}
