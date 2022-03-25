package com.cybage.bookManagementSystem.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
public class Book {
	
	@NotNull
	@Min(4)
	@Id
	private int bookId;
	
	@NotEmpty(message = "Enter Book Title!!!")
	@Size(min = 8,max = 25)
	private String title;
	
	@NotEmpty(message = "Enter Author Name!!!")
	@Size(min = 8,max = 25)
	private String author;
	
	@NotEmpty(message = "Enter Publishing Company Name!!!")
	@Size(min = 8,max = 25)
	private String publisher;
	
	@NotNull(message = "Enter Price of the book!!!")
	@Min(300)
	private double price;
	
	public Book() {
	}

	public Book(@NotNull @Min(4) int bookId,
			@NotEmpty(message = "Enter Book Title!!!") @Size(min = 8, max = 25) String title,
			@NotEmpty(message = "Enter Author Name!!!") @Size(min = 8, max = 25) String author,
			@NotEmpty(message = "Enter Publishing Company Name!!!") @Size(min = 8, max = 25) String publisher,
			@NotEmpty(message = "Enter Price of the book!!!") @Min(300) double price) {
		this.bookId = bookId;
		this.title = title;
		this.author = author;
		this.publisher = publisher;
		this.price = price;
	}

	

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", title=" + title + ", author=" + author + ", publisher=" + publisher
				+ ", price=" + price + "]";
	}

	
	
}
