package com.basics.learningspringboot.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.basics.learningspringboot.model.Books;

@Repository
public interface BooksRepository extends CrudRepository<Books, Integer> {

}
