package com.Exam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.Exam.dto.OrderDTO;
import com.Exam.service.CustomerService;
import com.Exam.service.OrderService;
import com.Exam.service.ProductServcie;

@Controller
public class AdminController {
	@Autowired
	private CustomerService customer;
	
	@Autowired
	private ProductServcie product;
	
	@Autowired
	private OrderService order;
	@RequestMapping("/")
	public String home() {
		return "Admin";
	}
	
	@RequestMapping("/sales")
	public String PageSale() {
		return "sale";
	}

	@GetMapping("/warehouse")
	public String Warehouse() {
		return "wareHouse";
	}
	
	@RequestMapping("/order")
	public String Order(ModelMap modelMap) {
		modelMap.addAttribute("orders", order.getAllOrder());
		
		return "Order";
	}
	
	
	@RequestMapping("/baogia")
	public String send(ModelMap modelMap) {
		modelMap.addAttribute("customers",customer.findAll());
		
		modelMap.addAttribute("products", product.getAllProduct());
		return "sendmail";
	}
}
