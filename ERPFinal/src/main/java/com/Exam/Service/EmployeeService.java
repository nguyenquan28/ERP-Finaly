package com.Exam.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Exam.DAO.EmployeeDAO;
import com.Exam.Entity.Employee;

@Service 
public class EmployeeService {
	
	@Autowired
	EmployeeDAO employeeDAO;
	
//	Show all Employee
	public List<Employee> showEmplyee(){
		return employeeDAO.findAll();
	}
	
}
