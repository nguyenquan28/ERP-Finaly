package com.Exam.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import com.Exam.DAO.ProductDAO;
import com.Exam.Entity.Product;

@Service
public class ProductServcie {
	@Autowired
	ProductDAO productDAO;
	
	//lay tat ca du lieu cua san pham
	public List<Product> getAllProduct(){
		return productDAO.findAll();
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
	
}
