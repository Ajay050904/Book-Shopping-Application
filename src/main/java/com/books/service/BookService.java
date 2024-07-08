package com.books.service;

import java.util.List;

import com.books.model.Book;

public interface BookService {

	public List<Book> getAllBooks();

	public Book getBookById(Long id);

	public List<Book> getRelatedBooks(Book book);

	public Book addBook(Book book);

	public Book putBook(Book book);

	public void deleteBookById(Long id);
}
