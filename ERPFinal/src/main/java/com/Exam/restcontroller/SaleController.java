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
import com.Exam.Service.OrderService;

@RestController
@RequestMapping("/api")
public class SaleController {
	
	@Autowired OrderService ser;
	
	@RequestMapping("/them-don-hang")
	public String themDonHang(@RequestBody OrderDTO orderDTO) {
		ser.save(orderDTO);
//		Orders order = new Orders();
//		List<OrderItem>orderItems = new ArrayList<OrderItem>();
//		phai luu vao order chu sao luu vao DTO
//		
//		
//		order.setTenKH(orderDTO.getTenKH());
//		order.setNgay(orderDTO.getNgay());
//		order.setCuaHang(orderDTO.getCuaHang());
//		order.setDiaChi(orderDTO.getDiaChi());
//		order.setEmail(orderDTO.getEmail());
//		order.setPhone(orderDTO.getPhone());
//		order.setTenNguoiBan(orderDTO.getTenNguoiBan());
//		order.setTrangThai(orderDTO.getTrangThai());
//		order.setTongTien(orderDTO.getTongTien());
//		
//		for(OrderItemDTO orderItemDTO : orderDTO.getOrderItems()) {
//			OrderItem item = new OrderItem();
//			
//			Product product = new Product();
//			ProductDTO productDTO = orderItemDTO.getProduct();
//			
//			product.setTenSP(productDTO.getTenSP());
//			product.setDonGia(productDTO.getDonGia());
//			product.setDonVi(productDTO.getDonVi());
//			product.setMaSP(productDTO.getMaSP());
//			
//			
//			item.setProduct(product);
//			item.setSoLuong(orderItemDTO.getSoLuong());
//			item.setThanhTien(orderItemDTO.getThanhTien());
//			orderItems.add(item);
//		}
		
//		order.setOrderItems(orderItems);
//		
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
