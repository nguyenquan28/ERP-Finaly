package com.Exam.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Exam.DAO.CustomerDAO;
import com.Exam.Entity.Customer;

@Service
public class CustomerService {
	
	@Autowired
	CustomerDAO customerDAO;
	
//	Create information Customer
	public boolean createCustomer(Customer customer) {
		customerDAO.save(customer);
		return true;
	}
}
