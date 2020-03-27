package com.Exam.DAO;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Exam.Entity.Sale;

@Transactional
public interface SaleDAO extends JpaRepository<Sale, Integer>{
	
}
