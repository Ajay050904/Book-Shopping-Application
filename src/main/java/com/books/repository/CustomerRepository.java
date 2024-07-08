package com.books.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.books.model.Customer;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, String> {
	Customer findByEmail(String email);
	Customer getOne(String id);
}
