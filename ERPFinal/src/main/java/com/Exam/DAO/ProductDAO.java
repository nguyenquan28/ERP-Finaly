package com.Exam.DAO;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Exam.Entity.Product;

@Transactional
public interface ProductDAO extends JpaRepository<Product, Integer>{

}
