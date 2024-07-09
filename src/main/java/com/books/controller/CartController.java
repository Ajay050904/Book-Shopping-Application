package com.books.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.books.model.Book;
import com.books.model.Cart;
import com.books.service.BookServiceImpl;
import com.books.service.CartService;

public class CartController {
	@Autowired
	private CartService cartService;

	@Autowired
	private BookServiceImpl bookservice;

	// Adding book detail to single page
	@GetMapping("/books")
	public String getlist(@ModelAttribute Book book, Model model) {
		System.out.println();
		List<Book> listBook = bookservice.getAllBooks();
		model.addAttribute("books", listBook);
		return "books";
	}

	@GetMapping("/{id}")
	public String getBookDetails(@PathVariable Long id, Model model) {
		Book book = bookservice.getBookById(id);
		List<Book> relatedBooks = bookservice.getRelatedBooks(book);
		model.addAttribute("book", book);
		model.addAttribute("relatedBooks", relatedBooks);
		return "bookById";
	}

	@PostMapping("/{id}")
	public String addBookToCart(@RequestParam Long customerId, @RequestParam Long bookId, Model model) {
		cartService.addBookToCart(customerId, bookId);
		model.addAttribute("cart", "hello");
		return "cart";
	}

	@GetMapping("/items")
	public ResponseEntity<List<Cart>> getCartItems(@RequestParam Long customerId) {
		List<Cart> cartItems = cartService.getCartItems(customerId);
		return ResponseEntity.ok(cartItems);
	}

	@DeleteMapping("/remove")
	public ResponseEntity<String> removeBookFromCart(@RequestParam Long cartId) {
		cartService.removeBookFromCart(cartId);
		return ResponseEntity.ok("Book removed from cart successfully");
	}

	@PutMapping("/update")
	public ResponseEntity<String> updateBookInCart(@RequestParam Long cartId, @RequestParam Long bookId) {
		cartService.updateBookInCart(cartId, bookId);
		return ResponseEntity.ok("Cart updated successfully");
	}

}
