package com.penguin.amrishpopat.javaTest.DAO;

import java.io.IOException;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Collections;
import org.springframework.stereotype.Repository;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.penguin.amrishpopat.javaTest.model.Book;

@Repository
public class BookDAO {
	
	

	public BookDAO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public List<Book> readJson() {
		Gson gson = new GsonBuilder().create();
        Path path = Paths.get("src\\main\\resources\\static\\data.json");
        System.out.println(path);
        
        try (Reader reader = Files.newBufferedReader(path, StandardCharsets.UTF_8)) {
            
        	Book[] booksArray = gson.fromJson(reader, Book[].class);
            Arrays.stream(booksArray).forEach( e -> {
                System.out.println("Each line" + e);
            });
            List<Book> books = Arrays.asList(booksArray);
            return books;
            
        } catch (IOException e) {
        	System.out.println("Unable to read data.json " + e.getMessage());
        	return Collections.emptyList();
        }

	}
}
