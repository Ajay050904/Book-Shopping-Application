package com.books.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String title;
	private String author;
	private String description;
	private String language;
	private int pages;
	private double price;
	private String photoUrl;
	private String publisher;
	private String firstPubDate;

	public Book() {
		System.out.println("Book class 0 param constructor");
	}

	public Book(Long id, String title, String author, String description, String language, int pages, double price,
			String photoUrl, String publisher, String firstPubDate) {
		super();
		this.id = id;
		this.title = title;
		this.author = author;
		this.description = description;
		this.language = language;
		this.pages = pages;
		this.price = price;
		this.photoUrl = photoUrl;
		this.publisher = publisher;
		this.firstPubDate = firstPubDate;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public int getPages() {
		return pages;
	}

	public void setPages(int pages) {
		this.pages = pages;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getPhotoUrl() {
		return photoUrl;
	}

	public void setPhotoUrl(String photoUrl) {
		this.photoUrl = photoUrl;
	}

	public String getFirstPubDate() {
		return firstPubDate;
	}

	public void setFirstPubDate(String firstPubDate) {
		this.firstPubDate = firstPubDate;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", author=" + author + ", description=" + description
				+ ", language=" + language + ", pages=" + pages + ", price=" + price + ", photoUrl=" + photoUrl
				+ ", publisher=" + publisher + ", firstPubDate=" + firstPubDate + "]";
	}

}
