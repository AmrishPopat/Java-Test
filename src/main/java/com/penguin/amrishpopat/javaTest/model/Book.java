package com.penguin.amrishpopat.javaTest.model;

public class Book {
	
	private String id;
	private String title;
	private String author;
	private String url;
	private String image;

	public Book() {
		// TODO Auto-generated constructor stub
	}
	
	
	public Book(String id, String title, String author, String url, String image  ) {
		// TODO Auto-generated constructor stub
		super();
		this.id = id;
		this.title = title;
		this.author = author;
		this.url = url;
		this.image = image;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getAuthor() {
		return author;
	}


	public void setAuthor(String author) {
		this.author = author;
	}


	public String getUrl() {
		return url;
	}


	public void setUrl(String url) {
		this.url = url;
	}


	public String getImage() {
		return image;
	}


	public void setImage(String image) {
		this.image = image;
	}
	
	
	
	

}
