package com.books.service;

import java.util.List;
import com.books.model.Customer;

public interface CustomerService {

	public List<Customer> getAllCustomer();

	public Customer addCustomer(Customer customer);

	public Customer putCustomer(Customer customer);

	public Customer getCustomerById(Long id);

	public Customer findByEmailAndPassword(String email, String password);

	public void deleteCustomerById(Long id);
}
