package com.books.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.books.model.Book;
import com.books.repository.BookRepository;

@Service
public class BookServiceImpl implements BookService {
	@Autowired
	private BookRepository bookRepository;
	List<Book> list;

	@Override
	public List<Book> getAllBooks() {
		return bookRepository.findAll();
	}

	@Override
	public Book getBookById(Long id) {
		return bookRepository.findById(id).orElse(null);
	}

	@Override
	public List<Book> getRelatedBooks(Book book) {
		// Assuming related books are fetched based on some criteria, e.g., same author
		// or genre
		return bookRepository.findRelatedBooks(book.getAuthor());
	}

	@Override
	public Book addBook(Book book) {
		bookRepository.save(book);
		return book;
	}

	@Override
	public Book putBook(Book book) {
		bookRepository.save(book);
		return book;
	}

	@Override
	public void deleteBookById(Long id) {
		Book entity = bookRepository.getOne(id);
		bookRepository.delete(entity);
	}
}
