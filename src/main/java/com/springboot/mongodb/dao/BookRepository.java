package com.springboot.mongodb.dao;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.springboot.mongodb.model.Author;
import com.springboot.mongodb.model.Book;

public interface BookRepository extends MongoRepository<Book, String>{
	
	public Book findBookByName(String name);
	
	public List<Book> findAllBookByAuthors(List<Author> authors);
}
