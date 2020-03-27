package com.Exam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.Exam.Entity.Customer;
import com.Exam.Service.CustomerService;

@RestController
public class CustomerController {
	
	@Autowired
	CustomerService customerService;
	
//	Create customer
	@RequestMapping(value = "/customer", method = RequestMethod.POST)
	public boolean createCustomer(Customer customer) {
		customerService.createCustomer(customer);
		return true;
	}
}
