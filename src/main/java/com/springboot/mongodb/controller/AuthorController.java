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

import com.springboot.mongodb.dao.AuthorRepository;
import com.springboot.mongodb.model.Author;
import com.springboot.mongodb.model.Book;

@RestController
@RequestMapping
public class AuthorController {

	@Autowired
	private AuthorRepository authorRepository;
	
	@GetMapping("/author")
	public List<Author> getAllAuthor(){
		return authorRepository.findAll();
	}

	@PostMapping("/author")
	public Author addNewAuthor(@RequestBody Author author){
		return authorRepository.save(author);
	}
	
	@GetMapping("/author/{authorId}")
	public Author findAuthorById(@RequestParam String authorId){
		Optional<Author> authOptional = authorRepository.findById(authorId);
		if(!authOptional.isPresent())
			throw new RuntimeException();
		return authOptional.get();
	}
}
