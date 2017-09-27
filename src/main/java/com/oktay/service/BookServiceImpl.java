package com.oktay.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oktay.dao.BookDAO;
import com.oktay.models.Book;

/**
 * @author oktay
 *
 */
@Service
public class BookServiceImpl implements BookService{
	
	@Autowired
	private BookDAO bookDao;

	@Override
	public void addBook(Book book) {
		bookDao.addBook(book);
		
	}

	@Override
	public List<Book> getAllBooks() {
		return bookDao.getAllBooks();
		
	}

}
