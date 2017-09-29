package com.oktay.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.oktay.models.Author;
import com.oktay.service.AuthorService;

/**
 * @author oktay
 *
 */
@Controller
public class AuthorController {
	
	public static final Logger logger = LoggerFactory.getLogger(AuthorController.class);
	
	@Autowired
	private AuthorService authorService;

	
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
		model.addObject("author", author);
		model.setViewName("addAuthor");
		
		return model;
	}
	
	@RequestMapping(value = "/save_author", method = RequestMethod.POST)
	public ModelAndView saveAuthor(@ModelAttribute Author author) {
		if (author.getId() == 0) { 
			authorService.addAuthor(author);
		} else {
			authorService.updateAuthor(author.getId() , author);
		}
		return new ModelAndView("redirect:/list_authors");
	}
	
	@RequestMapping(value = "/edit_author", method = RequestMethod.GET)
	public ModelAndView updateAuthor(HttpServletRequest request) {
		int authorId = Integer.parseInt(request.getParameter("id"));
		Author author=authorService.getAuthor(authorId);
		ModelAndView model = new ModelAndView("addAuthor");
		model.addObject("author",author);
		
		return model;
	}
	
	@RequestMapping(value = "/delete_author", method = RequestMethod.GET)
	public ModelAndView deleteAuthor(HttpServletRequest request) {
		int authorId = Integer.parseInt(request.getParameter("id"));
		authorService.deleteAuthor(authorId);
		return new ModelAndView("redirect:/list_authors");
	}
}
