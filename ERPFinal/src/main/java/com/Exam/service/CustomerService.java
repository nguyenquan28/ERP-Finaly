package com.Exam.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Exam.DAO.CustomerDAO;
import com.Exam.Entity.Customer;


public interface CustomerService {

	public List<Customer>findAll ();
	
	public List<Customer>getCustomerByListId(List<Integer>ids);
	
	public List<Customer>search(String q);
}

