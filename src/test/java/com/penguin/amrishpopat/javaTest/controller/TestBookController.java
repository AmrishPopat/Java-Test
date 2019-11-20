package com.penguin.amrishpopat.javaTest.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasProperty;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class TestBookController {
	

	
	@Autowired 
	private MockMvc mockMvc;

    @Test
    public void test_controller_PageNotFound_ShouldRender404View() throws Exception {
 
        mockMvc.perform(get("/wrongurl/{id}", "11"))
                .andExpect(status().isNotFound());
    }
    
	@Test 
	public void test_controller_BookNotFound() throws Exception {
		 
		mockMvc.perform(get("/books/111")) 
			.andDo(print())
			.andExpect(status().isOk())
			.andExpect(view().name("books"))
			.andExpect(forwardedUrl("/view/books.jsp"))
			.andExpect(model().size(0));
	}	 

	
	@Test 
	public void test_bookExists_getBookById() throws Exception {

		mockMvc.perform(get("/books/11")) 
			.andDo(print())
			.andExpect(status().isOk())
			.andExpect(view().name("books"))
			.andExpect(forwardedUrl("/view/books.jsp"))
			.andExpect(model().attribute("book", hasProperty("id", is("11"))))
			.andExpect(model().attribute("book", hasProperty("author", is("John Keats"))))
			.andExpect(model().attribute("book", hasProperty("title", is("Selected Poems: Keats"))))
			.andExpect(model().attribute("book", hasProperty("url", is("https://www.penguin.co.uk/books/33867/selected-poems--keats/9780140424478.html"))))
			.andExpect(model().attribute("book", hasProperty("image", is("img/one.jpg"))));

	}
	 

}
