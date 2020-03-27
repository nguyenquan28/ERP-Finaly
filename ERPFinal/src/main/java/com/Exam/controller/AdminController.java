package com.Exam.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminController {
	
	@RequestMapping("/")
	public String home() {
		return "Admin";
	}
	
	@RequestMapping("/sales")
	public String PageSale() {
		return "Sale";
	}

	@GetMapping("/warehouse")
	public String Warehouse() {
		return "wareHouse";
	}
	
}
