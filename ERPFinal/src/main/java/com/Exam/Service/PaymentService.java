package com.Exam.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Exam.DAO.PaymentDAO;
import com.Exam.Entity.Payment;

@Service
public class PaymentService {
	
	@Autowired
	PaymentDAO paymentDAO;
	
//	Show all Payment
	public List<Payment> showPayment(){
		return paymentDAO.findAll();
	}
}
