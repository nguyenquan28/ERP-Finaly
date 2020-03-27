package com.Exam.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Exam.Entity.Cart;
import com.Exam.Service.CartService;

@RestController
public class CartController {
	
	@Autowired
	CartService cartService;
	
//	Insert product to cart
	@CrossOrigin("*")
	@PostMapping("/sales/insertCart")
	public boolean insertCart(@RequestBody Cart cart) {
		cartService.insertCart(cart);
		return true;
	}
	
//	Show all products in cart
	@CrossOrigin("*")
	@RequestMapping("/sales/getAllCart")
	public List<Cart> getAllcart(){
		return cartService.getAllcart();
	}
	
//	Show product in cart by id sales
	@RequestMapping(value = "/sales/showCart")
	public List<Cart> showCarts(@RequestParam(name = "license") int license){
		return cartService.showCarts(license);
	}
}
