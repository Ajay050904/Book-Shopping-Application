package com.books.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.books.model.Book;
import com.books.model.Customer;
import com.books.repository.BookRepository;
import com.books.service.BookService;

@Controller
public class BookController {

	@Autowired
	private BookRepository bookRepository;
	@Autowired
	private BookService bookService;

	@GetMapping("/home")
	public String viewHomePage(Model model) {
//		model.addAttribute("books", bookService.getAllBooks());
		return "home";
	}

	@GetMapping("/books")
	public String getBooks(Model model) {
		List<Book> books = bookService.getAllBooks();
		model.addAttribute("books", books);
		return "books";
	}

//	@GetMapping("/books/{id}")
//	public String viewBookDetails(@PathVariable("id") Long id, Model model) {
//		model.addAttribute("book", bookService.getBookById(id));
//		return "bookById";
//	}

	@GetMapping("/{id}")
	public String getBookDetails(@PathVariable Long id, Model model) {
		Book book = bookService.getBookById(id);
		List<Book> relatedBooks = bookService.getRelatedBooks(book);
		model.addAttribute("book", book);
		model.addAttribute("relatedBooks", relatedBooks);
		return "bookById";
	}

	// Method for Adding New Book
	@GetMapping("/NewRegist")
	public String registeration(Customer customer) {
		return "bookregister";
	}

	@PostMapping("/newRegister")
	@ResponseBody
	public ModelAndView register(@ModelAttribute com.books.model.Book book, Model model) {
		System.out.println(book);
		model.addAttribute("book1", book);
		bookService.addBook(book);
		return new ModelAndView("redirect:/home");
	}

}
