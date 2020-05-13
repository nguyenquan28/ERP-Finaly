package com.Exam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Exam.Entity.Discount;
import com.Exam.Service.DiscountService;

@RestController
public class DiscountController {
	
	@Autowired
	DiscountService discountService;
	
//	Discount
	@RequestMapping("/sales/discounts")
	public Discount discounts(@RequestParam int maKM) {
		return discountService.discounts(maKM);
	}
}
