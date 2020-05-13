package com.Exam.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Exam.Entity.Customer;
import com.Exam.Service.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	CustomerService customerService;
	
//	Create customer
//	@RequestMapping(value = "/add", method = RequestMethod.POST)
//	public boolean createCustomer(Customer customer) {
//		customerService.createCustomer(customer);
//		return true;
//	}
	
	@RequestMapping("/getAll")
	public List<Customer>customers(){
		return customerService.findAll();
	}
	
	@RequestMapping("/search")
	public List<Customer>search(@RequestParam(name = "q")String q){
		return customerService.search(q);
	}
	
	
	
	
}
