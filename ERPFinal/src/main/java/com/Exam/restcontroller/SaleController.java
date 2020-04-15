package com.Exam.restcontroller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.Exam.Entity.OrderItem;
import com.Exam.Entity.Orders;
import com.Exam.Entity.Product;
import com.Exam.dto.OrderDTO;
import com.Exam.dto.OrderItemDTO;
import com.Exam.dto.ProductDTO;

@RestController
@RequestMapping("/api")
public class SaleController {
		
	
	@RequestMapping("/them-don-hang")
	public String themDonHang(@RequestBody OrderDTO orderDTO) {
		
		
//		System.out.println(order.getTenKH());
//		System.out.println(order.getDiaChi());
//		System.out.println(order.getEmail());
//		System.out.println(order.getPhone());
//		System.out.println(order.getNgay());
//		System.out.println(order.getTenNguoiBan());
//		System.out.println(order.getCuaHang());
//		System.out.println(order.getTongTien());
//		System.out.println(order.getTrangThai());
//		for (int i = 0; i < order.getOrderItems().size(); i++) {
//			System.out.println(order.getOrderItems().get(i).getProduct().getTenSP());
//		}
//		
		
		return "Thành công";
	}
}
