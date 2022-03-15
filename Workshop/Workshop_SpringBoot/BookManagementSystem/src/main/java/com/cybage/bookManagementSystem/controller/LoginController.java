package com.cybage.bookManagementSystem.controller;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cybage.bookManagementSystem.model.Book;
import com.cybage.bookManagementSystem.model.Credentials;
import com.cybage.bookManagementSystem.model.User;
import com.cybage.bookManagementSystem.service.BookService;
import com.cybage.bookManagementSystem.service.UserService;

@Controller
public class LoginController {

	@Autowired
	UserService userService;
	
	@Autowired
	BookService bookService;
	
	
	@GetMapping("/login")
	public String login(Model model) {
		Credentials credentials= new Credentials("", "");
		model.addAttribute("credentials", credentials);
		return "login";
	}
	
	@PostMapping("/authentication")
	public ModelAndView authenticate(@Valid @ModelAttribute("credentials")Credentials credentials,BindingResult res,HttpSession session) {
	
		if(res.hasErrors())
			return new ModelAndView("login");
		User user = userService.authentication(credentials.getEmail(), credentials.getPassword());
		List<Book> books = bookService.getAllBooks();
		
		if(user!=null) {
			session.setAttribute("user", user);
			return new ModelAndView("getBooks","books",books);
		}
		return null;
			
	}
	
	
	
	
}
