package com.springboot.mongodb.graphqlutil;

import java.util.ArrayList;
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
	
	private Optional<Author> authorOpt = null;
	
	private Author author = null;
	
	private Book book = null;
	
	public Book getBook(String id) {
		Optional<Book> bookOption =  bookRepository.findById(id);
		if(bookOption.isPresent())
			return bookOption.get();
		return null;
	}
	
	public List<Book> getBookList(){
		return bookRepository.findAll();
	}
	
	public Book getBookByName(String name) {
		
		Book book = bookRepository.findBookByName(name);
		System.out.println("Book-id "+book.getId());
		System.out.println("Book-pageCount "+book.getPageCount());
		System.out.println("Book-authors "+book.getAuthors());
		return book;
	}
	
	public List<Book> bookByAuthor(String id) {
		
		ArrayList<Author> authorList = new ArrayList<>();
		authorList.add(authorRepository.findById(id).get());
		
		List<Book> bookList = bookRepository.findAllBookByAuthors(authorList);
		
		if(bookList == null || bookList.isEmpty())
			throw new RuntimeException();
		return bookList;
	}
	
	public Author getAuthor(String id) {
		Optional<Author> author = authorRepository.findById(id);
		if(author.isPresent())
			return author.get();
		return null;
	}
	
	public Author getAuthorByName(String firstName, String lastName) {
		
		author = authorRepository.findAuthorByfirstNameAndLastName(firstName, lastName);
		if(authorOpt != null)
			throw new RuntimeException("Author dosn't exist by given first and last name");
		return author;
		
	}
	
	public List<Author> getAuthorList(){
		return authorRepository.findAll();
	}
	
 }

