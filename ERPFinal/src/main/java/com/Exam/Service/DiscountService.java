package com.Exam.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Exam.DAO.DiscountDAO;
import com.Exam.Entity.Discount;

@Service
public class DiscountService {
	
	@Autowired
	DiscountDAO discountDAO;
	
//	Show all discount
	public List<Discount> showDiscounts(){
		return discountDAO.findAll();
	}
 	
//	Discount
	public Discount discounts(int maKM) {
		return discountDAO.findById(maKM).orElse(null);
	}
}
