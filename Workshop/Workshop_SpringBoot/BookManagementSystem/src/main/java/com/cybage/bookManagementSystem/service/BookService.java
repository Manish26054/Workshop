package com.cybage.bookManagementSystem.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.cybage.bookManagementSystem.model.Book;

@Service
public class BookService {
	
	List<Book>bookList=new ArrayList<>();
	
	public BookService() {
		bookList.add(new Book(100012,"The Alchemist", "Paulo Coelho","Harper Torch",350.00));
		bookList.add(new Book(100013,"Shiva TrioLogy", "Amish Tripathi","WestLand Press ",320.00));
		bookList.add(new Book(100014,"The Secret", "Rhonda Byrne","Atria Books",550.00));
		bookList.add(new Book(100015,"The Hobbit", "JRR Tolkien","George Allen & Unwin",650.00));
	}

	public List<Book> getAllBooks() {
		return bookList;
	}

	public void addBook(Book book) {
		bookList.add(book);
	}

	public void delete(int id) {
		
		Book book1 = bookList.stream().filter(book->book.getBookId()==id).findFirst().get();
		bookList.remove(book1);
		
	}

	public Book findById(int bookId) {
	
		return bookList.stream().filter(book->book.getBookId()==bookId).findFirst().get();
		
	}

	public void updateBook(Book book) {
		
		int index =	bookList.indexOf(bookList.stream().filter(book1->book1.getBookId()==book.getBookId()).findFirst().get());
		bookList.set(index, book);
	}

}
