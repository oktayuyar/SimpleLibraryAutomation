package com.oktay.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.oktay.models.Author;

/**
 * @author oktay
 *
 */
@Repository
@Transactional
public class AuthorDAOImpl implements AuthorDAO{

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void addAuthor(Author author) {
		sessionFactory.getCurrentSession().save(author);
		
	}

	@SuppressWarnings("unchecked")
	public List<Author> getAllAuthors() {
		Criteria cr = sessionFactory.getCurrentSession().createCriteria(Author.class);
		return cr.list();
	}

}
