package com.springboot.mongodb.graphqlutil;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.springboot.mongodb.dao.AuthorRepository;
import com.springboot.mongodb.dao.BookRepository;
import com.springboot.mongodb.model.Author;
import com.springboot.mongodb.model.Book;


@Component
public class MutationResolver implements GraphQLMutationResolver{
	
	@Autowired
	private AuthorRepository authorRepository;
	
	@Autowired
	private BookRepository bookRepository;
	
	public Author newAuthor(String firstName, String lastName) {
		return authorRepository.save(new Author(firstName, lastName));
	}
	
//	public Book newBook(String name, int pageCount, Author author) {
//		return bookRepository.save(new Book(name, pageCount, author));
//	}
	
	public Book updateBookPageCount(int pageCount, String id) {
		
		Optional<Book> bookOption = bookRepository.findById(id);
		Book book = null;
		
		if(bookOption.isPresent()) {
			book = bookOption.get();
			book.setPageCount(pageCount);
			bookRepository.save(book);
		}
		
		return book;
	}
	
	
	public boolean deleteAuthor(String id) {
		 authorRepository.deleteById(id);
		 return true;
	}

}