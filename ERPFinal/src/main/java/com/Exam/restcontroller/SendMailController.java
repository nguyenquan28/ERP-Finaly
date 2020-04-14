package com.Exam.restcontroller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Exam.Entity.Customer;
import com.Exam.Entity.Product;
import com.Exam.dto.EmailRequest;
import com.Exam.dto.ProductRequest;
import com.Exam.Service.CustomerService;
import com.Exam.Service.MailService;
import com.Exam.Service.ProductServcie;

@RestController
@RequestMapping("/api/send-mail")
public class SendMailController {
	
	private static List<ProductRequest>listProductSelected;
	private static List<EmailRequest>listEmailSelected;
	
	@Autowired
	MailService mailService;
	
	@Autowired
	ProductServcie productService;
	
	@Autowired
	CustomerService customerService;
	
	@RequestMapping("/prepare-product")
	public String prepareProduct(@RequestBody List<ProductRequest>list) {
		listProductSelected = new ArrayList<>(list);
		
		return "Success";
	}
	@RequestMapping("/prepare-customer")
	public String prepareCustomer(@RequestBody List<EmailRequest>list) throws IOException {
		
		listEmailSelected = new ArrayList<>(list);
		
		
		this.mailService.sendMailHelp(listProductSelected,listEmailSelected);
		
		
		return "Success";
	}
}
