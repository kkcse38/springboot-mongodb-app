package com.springboot.mongodb.dao;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.springboot.mongodb.model.Book;

public interface BookRepository extends MongoRepository<Book, String>{
	

}
