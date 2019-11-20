package com.penguin.amrishpopat.javaTest.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.penguin.amrishpopat.javaTest.model.Book;
import com.penguin.amrishpopat.javaTest.service.BookService;

@Controller
public class BookController {
	
	@Autowired
	private BookService bookService; 



    @GetMapping("/books/{id}")
    public String getBookById(@PathVariable String id, ModelMap model) {
    	final Optional<Book> book = bookService.bookById(id);
    	if(book.isPresent()) {
    		model.addAttribute("book", book.get());
    	}
    	return "books"; 
    }
}

