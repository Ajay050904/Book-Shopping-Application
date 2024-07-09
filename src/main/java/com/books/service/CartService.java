package com.books.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.books.model.Book;
import com.books.model.Cart;
import com.books.model.Customer;
import com.books.repository.BookRepository;
import com.books.repository.CartRepository;
import com.books.repository.CustomerRepository;

public class CartService {
	@Autowired
	private CartRepository cartRepository;

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private BookRepository bookRepository;

	public void addBookToCart(Long customerId, Long bookId) {
		Customer customer = customerRepository.findById(customerId)
				.orElseThrow(() -> new RuntimeException("Customer not found"));
		Book book = bookRepository.findById(bookId).orElseThrow(() -> new RuntimeException("Book not found"));

		Cart cart = new Cart();
		cart.setCustomer(customer);
		cart.setBook(book);

		cartRepository.save(cart);
	}

	public List<Cart> getCartItems(Long customerId) {
		Customer customer = customerRepository.findById(customerId)
				.orElseThrow(() -> new RuntimeException("Customer not found"));
		return cartRepository.findByCustomer(customer);
	}

	public void removeBookFromCart(Long cartId) {
		cartRepository.deleteById(cartId);
	}

	public void updateBookInCart(Long cartId, Long bookId) {
		Cart cart = cartRepository.findById(cartId).orElseThrow(() -> new RuntimeException("Cart item not found"));
		Book book = bookRepository.findById(bookId).orElseThrow(() -> new RuntimeException("Book not found"));
		cart.setBook(book);
		cartRepository.save(cart);
	}

}
