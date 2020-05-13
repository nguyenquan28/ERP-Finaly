package com.Exam.DAO;

import java.util.List;

import com.Exam.Entity.Customer;

public interface SearchCustomerDAO {
	
	public List<Customer>search(String q);
}
