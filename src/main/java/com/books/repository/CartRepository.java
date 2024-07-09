package com.books.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.books.model.Cart;
import com.books.model.Customer;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long>  {
	@Query("SELECT c FROM Cart c WHERE c.customer.id = :customerId")
	Cart findByCustomerId(@Param("customerId") Customer customer);

	List<Cart> findByCustomer(Customer customer);

}
