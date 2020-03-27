package com.Exam.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import com.Exam.DAO.CartDAO;
import com.Exam.Entity.Cart;

@Service
public class CartService {
	
	@Autowired
	CartDAO cartDAO;
	
//	Insert one cart 
	public void insertCart(Cart cart) {
		cartDAO.save(cart);
	}
	
//	Show all data carts
	public List<Cart> getAllcart(){
		return cartDAO.findAll();
	}
	
//	Show data product in cart by id sales
	public List<Cart> showCarts(int license){
		Cart cart = new Cart();
		cart.setLicense(license);
		
		ExampleMatcher exampleMatcher = ExampleMatcher.matching()
				.withIgnorePaths("maGioHang")
				.withIgnorePaths("maSP")
				.withIgnorePaths("soLuong")
				.withIgnorePaths("donGia")
				.withIgnorePaths("phanLoai")
				.withIgnorePaths("donVi")
				.withIgnorePaths("ngaySanXuat")
				.withIgnorePaths("hanSuDung")
				.withIgnorePaths("tenSP")
				.withIgnorePaths("tongTien");
		
		return cartDAO.findAll(Example.of(cart, exampleMatcher));
	}
}
