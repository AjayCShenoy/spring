package com.ust.spring._05_2023;

public class Book {
	private String isbn;
	private Author author;
	
	public Book() {
		super();
	}
	
	
	public Book(String isbn, Author author) {
		super();
		this.isbn = isbn;
		this.author = author;
	}
	
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public Author getAuthor() {
		return author;
	}
	public void setAuthor(Author author) {
		this.author = author;
	}


	@Override
	public String toString() {
		return "Book [isbn=" + isbn + ", author=" + author + "]";
	}
	
	

}
