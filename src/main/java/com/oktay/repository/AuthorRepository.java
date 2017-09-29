/**
 * 
 */
package com.oktay.repository;

import org.springframework.data.repository.CrudRepository;

import com.oktay.models.Author;

/**
 * @author oktay
 *
 */
public interface AuthorRepository extends CrudRepository<Author, Integer>{

}
