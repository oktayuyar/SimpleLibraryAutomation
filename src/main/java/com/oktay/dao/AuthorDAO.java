package com.oktay.dao;

import java.util.List;

import com.oktay.models.Author;

/**
 * @author oktay
 *
 */
public interface AuthorDAO {
	
	public void addAuthor(Author author);	
	
	public Author getAuthor(Integer authorId);
	
	public Author updateAuthor(Author author);
	
	public void deleteAuthor(Integer authorId);
			
	public List<Author> getAllAuthors();
}
