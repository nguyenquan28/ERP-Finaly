package com.Exam.service.implement;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.Exam.DAO.CustomerDAO;
import com.Exam.Entity.Customer;
import com.Exam.service.CustomerService;
@Service
public class CustomerServiceImplement implements CustomerService{
	
	@Autowired
	CustomerDAO dao;
	
	@Override
	@Cacheable("customers")
	public List<Customer> findAll() {
		
		return dao.findAll();
	}

	@Override
	public List<Customer> getCustomerByListId(List<Integer> ids) {
		List<Customer>list = new ArrayList<Customer>();
		ids.stream().forEach(i->{
			list.add(dao.getCustomerById(i));
		});
		return list;
	}

}
