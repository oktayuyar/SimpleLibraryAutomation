package com.oktay.models;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.TableGenerator;

import com.oktay.models.Author;

/**
 * @author oktay
 *
 */
@Entity
public class Book implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	@TableGenerator(name = "BOOK_GEN", allocationSize = 1)
	@Id
	@GeneratedValue(generator = "BOOK_GEN")
	private int id;
	
	private String book_name;
	private String ISBN;
	private String publish_year;
	private String publisher;
	private Boolean status;
	
	@OneToMany(mappedBy="book" ,cascade=CascadeType.ALL , fetch = FetchType.LAZY)
	private Collection<Author>  authors =new ArrayList<Author>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBook_name() {
		return book_name;
	}

	public void setBook_name(String book_name) {
		this.book_name = book_name;
	}

	public String getISBN() {
		return ISBN;
	}

	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}

	public String getPublish_year() {
		return publish_year;
	}

	public void setPublish_year(String publish_year) {
		this.publish_year = publish_year;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public Collection<Author> getAuthors() {
		return authors;
	}

	public void setAuthors(Collection<Author> authors) {
		this.authors = authors;
	}
	
}

