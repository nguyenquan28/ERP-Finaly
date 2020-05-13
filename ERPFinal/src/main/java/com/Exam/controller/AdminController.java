package com.Exam.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.Exam.dto.OrderDTO;
import com.Exam.Entity.Orders;
import com.Exam.Service.CustomerService;
import com.Exam.Service.OrderService;
import com.Exam.Service.ProductServcie;

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
	@RequestMapping("/header")
	public String header() {
		return "fragments/header";
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
	public String Order() {
		
		
		return "Order";
	}
	@RequestMapping("/cong-no-phai-thu")
	public String congNo(ModelMap modelMap) {
		modelMap.addAttribute("list", this.order.listOrderUnPaid(0));
		
		return "congno";
	}
	
	
	@RequestMapping("/baogia")
	public String send(ModelMap modelMap) {
		modelMap.addAttribute("customers",customer.findAll());
		
		modelMap.addAttribute("products", product.getAllProduct());
		return "sendmail";
	}
}
