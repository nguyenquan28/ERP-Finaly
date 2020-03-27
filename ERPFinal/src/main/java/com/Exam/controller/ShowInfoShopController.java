package com.Exam.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Exam.Entity.Discount;
import com.Exam.Entity.Employee;
import com.Exam.Entity.Payment;
import com.Exam.Entity.SalesCode;
import com.Exam.Entity.Store;
import com.Exam.Service.DiscountService;
import com.Exam.Service.EmployeeService;
import com.Exam.Service.PaymentService;
import com.Exam.Service.SalesCodeService;
import com.Exam.Service.StoreService;

@RestController
public class ShowInfoShopController {

	@Autowired
	EmployeeService employeeService;
	
	@Autowired 
	SalesCodeService codeService;
	
	@Autowired 
	StoreService storeService;
	
	@Autowired
	PaymentService paymentService;
	
	@Autowired
	DiscountService discountService;
	
//	Show all Employee
	@RequestMapping("/showEmployees")
	public List<Employee> showEmployees(){
		return employeeService.showEmplyee();
	}
	
//	Show all Salecode
	@RequestMapping("/showSalecodes")
	public List<SalesCode> showSalecodes(){
		return codeService.ShowAll();
	}
	
//	Show all store
	@RequestMapping("/showStores")
	public List<Store> showStores(){
		return storeService.showStore();
	}
	
//	Show all payment
	@RequestMapping("/showPayments")
	public List<Payment> showPayment(){
		return paymentService.showPayment();
	}
	
//	Show all discount
	@RequestMapping("/showDiscounts")
	public List<Discount> showDiscount(){
		return discountService.showDiscounts();
	}
}
