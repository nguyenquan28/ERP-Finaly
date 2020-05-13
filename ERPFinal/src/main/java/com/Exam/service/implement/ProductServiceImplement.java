package com.Exam.Service.implement;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.Exam.DAO.ProductDAO;
import com.Exam.DAO.SearchProductDAO;
import com.Exam.Entity.Product;
import com.Exam.Service.ProductServcie;

@Service
public class ProductServiceImplement implements ProductServcie{
	@Autowired
	ProductDAO productDAO;
	
	@Autowired
	SearchProductDAO searchProductDAO;
	
	//lay tat ca du lieu cua san pham
	
	public List<Product> getProduct(int pageNumber){
		return productDAO.findAll(PageRequest.of(pageNumber, 7)).toList();
	}
	
	//tim kiem trong kho theo ten
	public List<Product> SelectByName(String nameSP){
		Product product = new Product();
		product.setTenSP(nameSP);
		ExampleMatcher exampleMatcher = ExampleMatcher.matching()
			.withIgnorePaths("maSP")
			.withIgnorePaths("donGia")
			.withIgnorePaths("donVi")
			.withIgnorePaths("soLuong")
			.withIgnorePaths("Size")
			.withIgnorePaths("phanLoai");
		return productDAO.findAll(Example.of(product, exampleMatcher));	
	}
	
//	Get one Product by ID
	public Optional<Product> getProductById(int maSP){
		return productDAO.findById(maSP);
	}
	
//	Save Product in Carts
	public void insertOneProduct(Product product) {
		productDAO.save(product);
	}
	@Override
	public List<Product> search(String q) {
		
		return searchProductDAO.search(q);
	}
	@Override
	public List<Product> getAllProduct() {
		return productDAO.findAll();
		
	}

	@Override
	public int productCount() {
		// TODO Auto-generated method stub
		return productDAO.productCount();
	}
	
}
