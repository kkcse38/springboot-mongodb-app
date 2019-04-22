package com.springboot.mongodb;

import java.util.ArrayList;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.springboot.mongodb.dao.AuthorRepository;
import com.springboot.mongodb.dao.BookRepository;
import com.springboot.mongodb.model.Author;
import com.springboot.mongodb.model.Book;

@SpringBootApplication
public class Application{
	
	@Autowired
	private AuthorRepository authorRepository;
	
	@Autowired
	private BookRepository bookRepository;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@PostConstruct
	public void createData() {

			//Delete existing data from mongodb if exists
			authorRepository.deleteAll();
			bookRepository.deleteAll();
		
			// TODO Auto-generated method stub
			Author mathAuthor = new Author("KC", "Sinha");
			Author phyAuthor = new Author("HC", "Verma");
			Author phyAuthor2 = new Author("Resnik", "Halliday");
			
			authorRepository.save(mathAuthor);
			authorRepository.save(phyAuthor);
			authorRepository.save(phyAuthor2);
			
			ArrayList<Author> mathAuthors = new ArrayList<>();
			mathAuthors.add(mathAuthor);
			
			ArrayList<Author> phyAuthors = new ArrayList<>();
			phyAuthors.add(phyAuthor);
			phyAuthors.add(phyAuthor2);
			
			Book mathBook = new Book("Math", 250, mathAuthors);
			Book phyBook = new Book("Concept Of Physics", 250, phyAuthors);
			
			bookRepository.save(mathBook);
			bookRepository.save(phyBook);
			
		
	}
}
