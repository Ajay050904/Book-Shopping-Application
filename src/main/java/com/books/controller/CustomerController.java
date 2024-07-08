package com.books.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.books.model.Customer;
import com.books.repository.CustomerRepository;

@Controller
public class CustomerController {
	@Autowired
	private CustomerRepository customerRepository;

	@GetMapping("/loginapp")
	public String login(Model model) {
		Customer customer = new Customer();
		model.addAttribute("user", customer);
		return "loginapp";
	}

	@PostMapping("/login")
	public ModelAndView login(@RequestParam("email") String email, @RequestParam("password") String password,
			Model model) {
		Customer customer = customerRepository.findByEmail(email);
		if (customer != null && customer.getPassword().equals(password)) {
			return new ModelAndView("redirect:/index");
		} else {
			model.addAttribute("error", "Invalid email or password");
			return new ModelAndView("redirect:/loginapp");
		}

	}

	@GetMapping("/registeration")
	public String registeration(Customer customer) {
		return "registerapp";
	}

	@PostMapping("/register")
	@ResponseBody
	public ModelAndView register(@ModelAttribute Customer customer, Model model) {
		System.out.println(customer);
		model.addAttribute("cust", customer);
		customerRepository.save(customer);
		return new ModelAndView("redirect:/home");
	}

}
