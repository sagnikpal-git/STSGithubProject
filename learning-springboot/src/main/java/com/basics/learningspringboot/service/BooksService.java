package com.basics.learningspringboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.basics.learningspringboot.model.Books;
import com.basics.learningspringboot.repository.BooksJpaRepository;
import com.basics.learningspringboot.repository.BooksRepository;

@Service
public class BooksService {

	/*
	 * @Autowired BooksRepository booksRepository;
	 */

	@Autowired
	BooksJpaRepository booksRepository;

	public Books addBook(Books book) {
		return booksRepository.save(book);
	}

	public List<Books> getBooks() {
		return (List<Books>) booksRepository.findAll();
	}

	public Books getByName(String bookName) {
		// return booksRepository.findByBookName(bookName);
		return booksRepository.findByBookNameLike("%" + bookName + "%");
	}

	public Books getByBookNameAuthor(String bookName, String authorName) {
		return booksRepository.findByBookNameAndAuthorName(bookName, authorName);
	}

}
