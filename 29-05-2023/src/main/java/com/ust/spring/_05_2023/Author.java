package com.ust.spring._05_2023;

public class Author {
	private String firstname;
	private String lastname;
	
	public Author() {
		super();
	}
	
	public Author(String firstname, String lastname) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	@Override
	public String toString() {
		return "Author [firstname=" + firstname + ", lastname=" + lastname + "]";
	}
	
	
}
