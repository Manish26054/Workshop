package com.cybage.bookManagementSystem.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cybage.bookManagementSystem.dao.BookDao;
import com.cybage.bookManagementSystem.model.Book;



@Service
@Transactional
public class BookServiceImpl implements BookService{
	
	@Autowired
	BookDao bookDao;

	@Override
	public List<Book> getAllBooks() {
		return bookDao.findAll();
	}

	@Override
	public void addBook(Book book)  {
		if(book!=null)
			bookDao.save(book);
	}

	@Override
	public void delete(int id) {
		if(bookDao.existsById(id)) 
			bookDao.deleteById(id);
		
	}

	@Override
	public Book findById(int id) {
		Optional<Book> book = bookDao.findById(id);
		return book.orElse(null);
	}

	@Override
	public void updateBook(Book book)  {
		if(book!=null)
			bookDao.save(book);
		
		
	}
	
	
	
	

}
