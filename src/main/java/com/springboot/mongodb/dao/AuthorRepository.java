package com.springboot.mongodb.dao;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.springboot.mongodb.model.Author;

public interface AuthorRepository extends MongoRepository<Author, String>{
	
	public Author findAuthorByfirstNameAndLastName(String firstName, String lastName);
}
