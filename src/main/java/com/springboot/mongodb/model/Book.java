package com.springboot.mongodb.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Book {
	
	@Id
	private String id;
	
	private String name;
	
	private int pageCount;
	
	private List<Author> authors;

	public Book() {
		// TODO Auto-generated constructor stub
	}
	
	public Book(String name, int pageCount, List<Author> authors) {
		super();
		this.name = name;
		this.pageCount = pageCount;
		this.authors = authors;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		System.out.println("\nCalled getName for Book\n");
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPageCount() {
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	public List<Author> getAuthors() {
		System.out.println("\nCalled getAuthors in Book\n");
		return authors;
	}

	public void setAuthors(List<Author> authors) {
		this.authors = authors;
	}
	
}
