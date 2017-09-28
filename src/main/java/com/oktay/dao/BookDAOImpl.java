package com.oktay.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.oktay.models.Book;

/**
 * @author oktay
 *
 */
@Repository
@Transactional
public class BookDAOImpl implements BookDAO{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void addBook(Book book) {
		sessionFactory.getCurrentSession().saveOrUpdate(book);
	}
	
	@Override
	public Book getBook(Integer bookId) {
		return (Book) sessionFactory.getCurrentSession().get(Book.class, bookId);
	}

	@Override
	public Book updateBook(Book book) {
		sessionFactory.getCurrentSession().update(book);
		return book;
	}

	@Override
	public void deleteBook(Integer bookId) {
		Book book = (Book) sessionFactory.getCurrentSession().load(Book.class, bookId);
		if (null != book) {
			this.sessionFactory.getCurrentSession().delete(book);
		}
	}

	@SuppressWarnings("unchecked")
	public List<Book> getAllBooks() {
		Criteria cr = sessionFactory.getCurrentSession().createCriteria(Book.class);
		return cr.list();
	}

}
