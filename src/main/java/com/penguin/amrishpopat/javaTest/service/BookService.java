package com.penguin.amrishpopat.javaTest.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.penguin.amrishpopat.javaTest.DAO.BookDAO;
import com.penguin.amrishpopat.javaTest.model.Book;
import com.penguin.amrishpopat.javaTest.validator.BookDataValidator;

@Service
public class BookService {
	
	private static List<Book> books = new ArrayList<Book>();

	@Autowired
	private BookDAO bookDAO;
	//@Autowired
	//private BookDataValidator bookDataValidator;
    
    public Optional<Book> bookByID(String id) throws NullPointerException {

    	Optional<Book> bookById; 
    	books = bookDAO.readJson();
    	bookById = books.stream().filter(t -> t.getId().equals(id)).findFirst();
    	if (bookById.isPresent()) {
    		return BookDataValidator.validate(bookById);
    	}
    	else {
    		return bookById;
    	}
    	
    }
}
