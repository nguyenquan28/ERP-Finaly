package com.Exam.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Exam.DAO.OrderDAO;
import com.Exam.Entity.Orders;

@Service
public class OrderService {

	@Autowired
	OrderDAO orderDAO;
	
	//get all data order
	public List<Orders> getAllOrder(){
		return orderDAO.findAll();
	}
	// delete one data by id
	public void DeleteOneOrderById(Integer id) {
		orderDAO.deleteById(id);
	}
}
