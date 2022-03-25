package com.cybage.bookManagementSystem.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cybage.bookManagementSystem.model.Book;
import com.cybage.bookManagementSystem.service.BookService;



@Controller
public class BookController {
	
	@Autowired
	private BookService bookService;
	
	@GetMapping("/getBooks")
	public ModelAndView books() {
		List<Book> books = bookService.getAllBooks();
		return new ModelAndView("getBooks","books",books);
	}
	
	@GetMapping("/addNewBook")
	public String addNewBook(Model model) {
		
		model.addAttribute("book",new Book());
		
		return "addBook";
		
	}
	
	@PostMapping("/addBook")
	public ModelAndView addBook(@Valid @ModelAttribute("book")Book book,BindingResult result) throws Exception {
		
		if(result.hasErrors()) 
			return new ModelAndView("addBook","book",book);
		
		bookService.addBook(book);
		return new ModelAndView("getBooks","books",bookService.getAllBooks());
		
	}
	
	@GetMapping("/delete/{id}")
	public ModelAndView delete(@PathVariable int id) {
		bookService.delete(id);
		return new ModelAndView("getBooks","books",bookService.getAllBooks());
	}
	
	@GetMapping("/edit/{id}")
	public ModelAndView edit(@PathVariable int id) {
		Book book = bookService.findById(id);
		
		return new ModelAndView("editBook","book",book);
	}
	@PostMapping("/editBook")
	public ModelAndView editBookData(@ModelAttribute("book") Book book) {
		try {
			bookService.updateBook(book);
			return new ModelAndView("getBooks","books",bookService.getAllBooks());
		} catch (Exception e) {
			e.printStackTrace();
			return new ModelAndView("editBook","book",book);
		}
	}
	
	@GetMapping("/getBookById")
	public String showFormID()
	{
		
		return "book";
		
	}
	
	@PostMapping("/getBook")
	public ModelAndView getBookById(@RequestParam("bookId") int bookId)
	{
		Book book=bookService.findById(bookId);
		return new ModelAndView("bookDetail","bookInfo",book);
	}
	
}
