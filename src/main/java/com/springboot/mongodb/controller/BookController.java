package com.springboot.mongodb.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.mongodb.dao.BookRepository;
import com.springboot.mongodb.model.Author;
import com.springboot.mongodb.model.Book;

@RestController
@RequestMapping
public class BookController {
	
	@Autowired
	private BookRepository bookRepository;
	
	@GetMapping("/book")
	public List<Book> getAllBooks(){
		return bookRepository.findAll();
	}
	
	@PostMapping("/book")
	public Book saveBook(@RequestBody Book book) {
		return bookRepository.save(book);
	}
	
	@GetMapping("/book/{bookId}")
	public Book findAuthorById(@RequestParam String bookId) {
		Optional<Book> bookOptional = bookRepository.findById(bookId);
		if(!bookOptional.isPresent())
			throw new RuntimeException();
		return bookOptional.get();
	}
	
}
