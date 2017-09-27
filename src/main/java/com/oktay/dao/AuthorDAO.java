package com.oktay.dao;

import java.util.List;

import com.oktay.models.Author;

/**
 * @author oktay
 *
 */
public interface AuthorDAO {
	
	public void addAuthor(Author author);

	public List<Author> getAllAuthors();
}
