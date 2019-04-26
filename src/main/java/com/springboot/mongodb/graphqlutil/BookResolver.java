package com.springboot.mongodb.graphqlutil;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.springboot.mongodb.dao.AuthorRepository;
import com.springboot.mongodb.model.Author;
import com.springboot.mongodb.model.Book;

public class BookResolver implements GraphQLResolver<Book>{
	
	@Autowired
	private AuthorRepository authorRepository;
	
	public List<Author> getAuthors(){
		System.out.println("\nCalled getAuthors for BookResolver\n");
		return authorRepository.findAll();
	}
}
