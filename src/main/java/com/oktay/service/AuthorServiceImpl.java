package com.oktay.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oktay.dao.AuthorDAO;
import com.oktay.models.Author;

/**
 * @author oktay
 *
 */
@Service
public class AuthorServiceImpl implements AuthorService{

	@Autowired
	private AuthorDAO authorDAO;
	
	@Override
	public void addAuthor(Author author) {
		authorDAO.addAuthor(author);
		
	}
	
	@Override
	public void deleteAuthor(Integer authorId) {
		authorDAO.deleteAuthor(authorId);
		
	}

	@Override
	public List<Author> getAllAuthors() {
		return authorDAO.getAllAuthors();
	}


}
