package com.basics.learningspringboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.basics.learningspringboot.model.Books;
import com.basics.learningspringboot.service.BooksService;

@RestController
public class BooksController {
	
	@Autowired
	BooksService booksService;
	
	@RequestMapping(method = RequestMethod.POST, value="/books")
	public Books addNewBook(@RequestBody Books book) {
		return booksService.addBook(book);
	}
	
	@RequestMapping(method = RequestMethod.GET, value="/books")
	public List<Books> getAllBooks() {
		return booksService.getBooks();
	}
	
	@RequestMapping(method = RequestMethod.GET, value="/books/{bookName}")
	public Books getByBooksName(@PathVariable String bookName) {
		return booksService.getByName(bookName);
	}
	
	@RequestMapping(method = RequestMethod.GET, value="/books/{bookName}/{authorName}")
	public Books getByBooksByNameAndAuthor(@PathVariable String bookName, @PathVariable String authorName) {
		return booksService.getByBookNameAuthor(bookName, authorName);
	}

}
