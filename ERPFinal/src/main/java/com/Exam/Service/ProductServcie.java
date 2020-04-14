package com.Exam.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import com.Exam.DAO.ProductDAO;
import com.Exam.Entity.Product;


public interface ProductServcie {
	
	//lay tat ca du lieu cua san pham
	public List<Product> getAllProduct();
	//tim kiem trong kho theo ten
	public List<Product> SelectByName(String nameSP);
	
//	Get one Product by ID
	public Optional<Product> getProductById(int maSP);
	
//	Save Product in Carts
	public void insertOneProduct(Product product) ;
	
	
		
		
	
}
