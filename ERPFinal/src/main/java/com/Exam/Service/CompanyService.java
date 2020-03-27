package com.Exam.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Exam.DAO.CompanyDAO;
import com.Exam.Entity.Company;

@Service
public class CompanyService {
	
	@Autowired
	CompanyDAO companyDAO;
	
//	Create information Company
	public boolean createCompany(Company company) {
		companyDAO.save(company);
		return true;
	}
}
