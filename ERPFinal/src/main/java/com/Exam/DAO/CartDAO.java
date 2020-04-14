package com.Exam.DAO;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Exam.Entity.Cart;

@Repository
public interface CartDAO extends JpaRepository<Cart, Integer>{
	
}
