package com.springboot.mongodb;

import java.util.ArrayList;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
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
			Author mathAuthor2 = new Author("Arun", "Kumar");
			
			Author phyAuthor = new Author("HC", "Verma");
			Author phyAuthor2 = new Author("Resnik", "Halliday");
			
			//Save all author to db
			authorRepository.save(mathAuthor);
			authorRepository.save(phyAuthor);
			authorRepository.save(phyAuthor2);
			authorRepository.save(mathAuthor2);
			
			ArrayList<Author> mathAuthors = new ArrayList<>();
			mathAuthors.add(mathAuthor);
			
			ArrayList<Author> mathAuthors2 = new ArrayList<>();
			mathAuthors2.add(mathAuthor);
			mathAuthors2.add(mathAuthor2);
			
			ArrayList<Author> phyAuthors = new ArrayList<>();
			
			phyAuthors.add(phyAuthor);
			phyAuthors.add(phyAuthor2);
			
			Book mathBook = new Book("Math", 250, mathAuthors);
			Book mathBook2 = new Book("Rs Agarwal", 350, mathAuthors2);
			Book phyBook = new Book("Concept Of Physics", 250, phyAuthors);
			
			bookRepository.save(mathBook);
			bookRepository.save(phyBook);
			bookRepository.save(mathBook2);
			
		
	}
}
