package com.Exam.DAO;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Exam.Entity.Product;

@Repository
public interface ProductDAO extends JpaRepository<Product, Integer>{

}
