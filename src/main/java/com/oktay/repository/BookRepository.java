package com.oktay.repository;

import org.springframework.data.repository.CrudRepository;

import com.oktay.models.Book;

/**
 * @author oktay
 *
 */
public interface BookRepository extends CrudRepository<Book, Integer>{

}
