package com.referrals.app.inheritance;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name = "id")
public class Book extends Product {

	private String author;

	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Book(int id, String name) {
		super(id, name);
		// TODO Auto-generated constructor stub
	}

	public Book(String author) {
		super();
		this.author = author;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}
}
