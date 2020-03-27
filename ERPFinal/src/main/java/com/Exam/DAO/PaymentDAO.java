package com.Exam.DAO;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Exam.Entity.Payment;

@Transactional
public interface PaymentDAO extends JpaRepository<Payment, Integer>{

}
