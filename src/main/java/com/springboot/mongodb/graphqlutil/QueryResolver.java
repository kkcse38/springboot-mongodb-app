package com.springboot.mongodb.graphqlutil;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.springboot.mongodb.dao.AuthorRepository;
import com.springboot.mongodb.dao.BookRepository;
import com.springboot.mongodb.model.Author;
import com.springboot.mongodb.model.Book;

@Component
public class QueryResolver implements GraphQLQueryResolver{
	
	@Autowired
	private BookRepository bookRepository;
	
	@Autowired
	private AuthorRepository authorRepository;
	
	public Book getBook(String id) {
		Optional<Book> bookOption =  bookRepository.findById(id);
		if(bookOption.isPresent())
			return bookOption.get();
		return null;
	}
	
	public List<Book> getBookList(){
		return bookRepository.findAll();
	}
	
	public Author getAuthor(String id) {
		Optional<Author> author = authorRepository.findById(id);
		if(author.isPresent())
			return author.get();
		return null;
	}
	
	public List<Author> getAuthorList(){
		return authorRepository.findAll();
	}
 }

