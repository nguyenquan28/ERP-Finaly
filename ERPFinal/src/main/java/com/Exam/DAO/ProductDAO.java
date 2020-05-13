package com.Exam.DAO;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.Exam.Entity.Product;

@Transactional
public interface ProductDAO extends JpaRepository<Product, Integer>{
		
	@Query(value = "select count(maSP) from product",nativeQuery = true)
	public int productCount();
	
}
