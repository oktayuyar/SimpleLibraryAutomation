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
		sessionFactory.getCurrentSession().save(book);
		
	}

	@SuppressWarnings("unchecked")
	public List<Book> getAllBooks() {
		Criteria cr = sessionFactory.getCurrentSession().createCriteria(Book.class);
		return cr.list();
	}

}
