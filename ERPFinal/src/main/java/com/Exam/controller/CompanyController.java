package com.Exam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.Exam.Entity.Company;
import com.Exam.Service.CompanyService;

@RestController
public class CompanyController {
	
	@Autowired
	CompanyService companyService;
	
//	Create Company partner
	@RequestMapping(value = "/company", method = RequestMethod.POST)
	public boolean createCompany(@RequestBody Company company) {
		companyService.createCompany(company);
		System.out.println(company);
		return true;
	}
}
