package com.Exam.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Exam.Entity.Product;
import com.Exam.Service.ProductServcie;

@RestController
public class ProductController {
	
	@Autowired
	ProductServcie productServcie;
	
	@RequestMapping(value = "/admin/getAllProduct")
	public List<Product> getAllProduct(){
		return productServcie.getAllProduct();
	}
	
	@RequestMapping(value = "/admin/selectByName")
	public List<Product> SelectByName(@RequestParam(name = "nameSP") String nameSP){
		return productServcie.SelectByName(nameSP);
	}
	
	@CrossOrigin("*")
	@GetMapping("/sales/addToCart")
	public Optional<Product> getProductById(@RequestParam(name = "maSP") int maSP) {
		return productServcie.getProductById(maSP);
	}
	

	@CrossOrigin("*")
	@GetMapping("/sales/saveToCart")
	public boolean insertOneProduct(@RequestBody Product product) {
		productServcie.insertOneProduct(product);
		return true;
	}

}
