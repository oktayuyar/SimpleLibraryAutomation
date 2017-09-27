package com.oktay.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.oktay.models.Author;
import com.oktay.models.Book;
import com.oktay.service.AuthorService;
import com.oktay.service.BookService;

/**
 * @author oktay
 *
 */
@Controller
public class AuthorController {
	
	@Autowired
	private AuthorService authorService;
	
	@Autowired
	private BookService bookService;
	
	@RequestMapping(value="/list_authors" , method = RequestMethod.GET)
	public ModelAndView ListAuthors(ModelAndView model) throws IOException {
		List<Author> listAuthors = authorService.getAllAuthors();
		model.addObject("listAuthors", listAuthors);
		model.setViewName("authors");
		
		return model;
	}
	
	@RequestMapping(value = "/add_author", method = RequestMethod.GET)
	public ModelAndView newAuthor(ModelAndView model) {
		
		Author author = new Author();
		List<Book> listBooks = bookService.getAllBooks();
		model.addObject("author", author);
		model.addObject("listBooks", listBooks);
		model.setViewName("addAuthor");
		
		return model;
	}
	
	@RequestMapping(value = "/save_author", method = RequestMethod.POST)
	public ModelAndView saveAuthor(@ModelAttribute Author author) {
		authorService.addAuthor(author);
		return new ModelAndView("redirect:/list_authors");
	}
	
	@RequestMapping(value = "/delete_author", method = RequestMethod.GET)
	public ModelAndView deleteAuthor(HttpServletRequest request) {
		int authorId = Integer.parseInt(request.getParameter("id"));
		authorService.deleteAuthor(authorId);
		return new ModelAndView("redirect:/list_authors");
	}
}
