package com.Exam.DAO;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Exam.Entity.Cart;

@Transactional
public interface CartDAO extends JpaRepository<Cart, Integer>{
	
}
