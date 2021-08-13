package com.basics.learningspringboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.basics.learningspringboot.model.Books;

public interface BooksJpaRepository extends JpaRepository<Books, Integer> {
	
	//Books findByBookName(String bookName);
	Books findByBookNameLike(String bookName);
	Books findByBookNameAndAuthorName(String bookName, String authorName);

}
