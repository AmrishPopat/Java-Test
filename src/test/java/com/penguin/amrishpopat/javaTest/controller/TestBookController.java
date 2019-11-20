package com.penguin.amrishpopat.javaTest.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasProperty;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.Before;
import org.junit.jupiter.api.Test; 
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.penguin.amrishpopat.javaTest.service.BookService;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class TestBookController {
	

	
	@Autowired 
	private MockMvc mockMvc;
	 	
	@InjectMocks
	private BookController bookControllerMock;
	@InjectMocks
	private BookService bookServiceMock;	
	
	@Before 
	public void setup() { 
		MockitoAnnotations.initMocks(this);
		this.mockMvc = MockMvcBuilders.standaloneSetup(bookControllerMock).build();
		this.mockMvc = MockMvcBuilders.standaloneSetup(bookServiceMock).build();
	}
	 
	 

    @Test
    public void contexLoads() throws Exception {
        assertThat(bookControllerMock).isNotNull();
    }

    @Test
    public void PageNotFound_ShouldRender404View() throws Exception {
 
        mockMvc.perform(get("/book/{id}", "111"))
                .andExpect(status().isNotFound());
    }
    
	@Test 
	public void test_BookNotFound_getBookById() throws Exception {

		 
		mockMvc.perform(get("/books/111")) 
			.andDo(print())
			.andExpect(status().isOk())
			.andExpect(view().name("books"))
			.andExpect(forwardedUrl("/WEB-INF/jsp/books.jsp"))
			.andExpect(model().size(0));
	}
	 

	
	@Test 
	public void test_bookExists_getBookById() throws Exception {

		mockMvc.perform(get("/books/11")) 
			.andDo(print())
			.andExpect(status().isOk())
			.andExpect(view().name("books"))
			.andExpect(forwardedUrl("/WEB-INF/jsp/books.jsp"))
			.andExpect(model().attribute("book", hasProperty("id", is("11"))))
			.andExpect(model().attribute("book", hasProperty("author", is("John Keats"))))
			.andExpect(model().attribute("book", hasProperty("title", is("Selected Poems: Keats"))))
			.andExpect(model().attribute("book", hasProperty("url", is("https://www.penguin.co.uk/books/33867/selected-poems--keats/9780140424478.html"))))
			.andExpect(model().attribute("book", hasProperty("image", is("img/one.jpg"))));

	}
	 

}
