package com.cybage.bookManagementSystem.service;

import java.util.List;


import com.cybage.bookManagementSystem.model.Book;

public interface BookService  {

	List<Book> getAllBooks();

	void addBook(Book book) ;

	void delete(int id);

	Book findById(int id);

	void updateBook(Book book);

}
