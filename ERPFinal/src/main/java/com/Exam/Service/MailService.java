package com.Exam.service;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.util.List;

import org.thymeleaf.context.Context;

import com.Exam.Entity.Customer;
import com.Exam.Entity.Product;
import com.Exam.dto.EmailRequest;
import com.Exam.dto.ProductRequest;

public interface MailService {
		
	
	public void send(String from,String to,String subject,String htmlPage,Context contexts,List<ProductRequest>products) throws IOException;
		
	
	public void sendMailHelp(List<ProductRequest>products,List<EmailRequest>customers) throws IOException;
	
	
	
	
		
}
