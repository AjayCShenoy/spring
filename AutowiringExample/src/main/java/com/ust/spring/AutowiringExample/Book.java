package com.ust.spring.AutowiringExample;

public class Book {
	private int isbn;
	private String title;
	private Author author;
	
	public Book() {
		super();
	}
	
	public Book(int isbn, String title, Author author) {
		super();
		this.isbn = isbn;
		this.title = title;
		this.author = author;
	}

	public int getIsbn() {
		return isbn;
	}

	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	@Override
	public String toString() {
		return "Book [isbn=" + isbn + ", title=" + title + ", author=" + author + "]";
	}

	
	
	

}
