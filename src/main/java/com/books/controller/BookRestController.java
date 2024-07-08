package com.books.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.books.model.Book;
import com.books.repository.BookRepository;

@RestController
public class BookRestController {
	@Autowired
	private BookRepository bookRepository;

	@GetMapping("/allbooks")
	public List<Book> getAllBooks(Model model) {
		List<Book> allBooks = (List<Book>) bookRepository.findAll();
		return allBooks;
	}

	@GetMapping("/book/{id}")
	public ResponseEntity<Book> getBook(@PathVariable(name = "id") Long id) {
		Optional<Book> optional = bookRepository.findById(id);
		Book book = null;
		if (optional.isPresent()) {
			book = optional.get();
		}
		return new ResponseEntity<Book>(book, HttpStatus.OK);
	}

	@PostMapping("/save")
	public ResponseEntity<Book> saveBook(@RequestBody Book book) {
		Book book1 = bookRepository.save(book);
		return new ResponseEntity<Book>(book1, HttpStatus.OK);
	}

	@PostMapping("/saveBooks")
	public ResponseEntity<Book> saveBooks(@RequestBody List<Book> books) {
		bookRepository.saveAll(books);
		return new ResponseEntity<Book>(HttpStatus.OK);
	}

	@PutMapping("/book/{id}")
	public ResponseEntity<Book> updateBook(@RequestBody Book book, @PathVariable(name = "id") Long id) {
		Optional<Book> optional = bookRepository.findById(id);
		Book book1 = null;
		if (optional.isPresent()) {
			book1 = optional.get();
		}
		book1.setTitle(book.getTitle());
		book1.setAuthor(book.getAuthor());
		book1.setDescription(book.getDescription());
		book1.setLanguage(book.getLanguage());
		book1.setPages(book.getPages());
		book1.setPrice(book.getPrice());
		book1.setPhotoUrl(book.getPhotoUrl());
		book1.setPublisher(book.getPublisher());
		book1.setFirstPubDate(book.getFirstPubDate());
		bookRepository.save(book1);
		return new ResponseEntity<Book>(book1, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	public void deleteBookById(@PathVariable(name = "id") Long id) {
		bookRepository.deleteById(id);
	}
}
