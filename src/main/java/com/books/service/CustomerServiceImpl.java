package com.books.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.books.model.Customer;
import com.books.repository.CustomerRepository;

public class CustomerServiceImpl implements CustomerService {
	@Autowired
	private CustomerRepository customerRepository;
	List<Customer> list;

	@Override
	public List<Customer> getAllCustomer() {
		return (List<Customer>) customerRepository.findAll();
	}

	@Override
	public Customer getCustomerById(String id) {
		return customerRepository.findById(id).orElse(null);
	}

	@Override
	public Customer addCustomer(Customer customer) {
		customerRepository.save(customer);
		return customer;
	}

	@Override
	public Customer putCustomer(Customer customer) {
		customerRepository.save(customer);
		return customer;
	}

	@Override
	public void deleteCustomerById(String id) {
		Customer entity = customerRepository.getOne(id);
		customerRepository.delete(entity);
	}
}
