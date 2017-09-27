package com.oktay.dao;

import java.util.List;

import com.oktay.models.Book;

/**
 * @author oktay
 *
 */
public interface BookDAO {
	
	public void addBook(Book book);

	public List<Book> getAllBooks();
}
