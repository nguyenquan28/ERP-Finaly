package com.Exam.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import com.Exam.DAO.OrderDAO;
import com.Exam.DAO.OrderItemDAO;
import com.Exam.Entity.OrderItem;
import com.Exam.Entity.Orders;
import com.Exam.Entity.Product;
import com.Exam.dto.OrderDTO;
import com.Exam.dto.OrderItemDTO;
import com.Exam.dto.ProductDTO;

@Service
public class OrderService {
	
	@Autowired OrderDAO orderDAO;
	@Autowired OrderItemDAO orderItemDAO;
	//seve order
	public boolean save(OrderDTO orderDTO){
		Orders order = new Orders();
		List<OrderItem>orderItems = new ArrayList<OrderItem>();
		order.setTenKH(orderDTO.getTenKH());
		order.setNgay(orderDTO.getNgay());
		order.setCuaHang(orderDTO.getCuaHang());
		order.setDiaChi(orderDTO.getDiaChi());
		order.setEmail(orderDTO.getEmail());
		order.setPhone(orderDTO.getPhone());
		order.setTenNguoiBan(orderDTO.getTenNguoiBan());
		order.setTrangThai(orderDTO.getTrangThai());
		order.setTongTien(orderDTO.getTongTien());
		
		for(OrderItemDTO orderItemDTO : orderDTO.getOrderItems()) {
			OrderItem item = new OrderItem();
			
			Product product = new Product();
			ProductDTO productDTO = orderItemDTO.getProduct();
			
			product.setTenSP(productDTO.getTenSP());
			product.setDonGia(productDTO.getDonGia());
			product.setDonVi(productDTO.getDonVi());
			product.setMaSP(productDTO.getMaSP());			
			
			item.setProduct(product);
			item.setSoLuong(orderItemDTO.getSoLuong());
			item.setThanhTien(orderItemDTO.getThanhTien());
			item.setOrder(order);
			orderItems.add(item);
		}		
		order.setOrderItems(orderItems);
		orderDAO.save(order);
		return true;
	}	


	public List<OrderDTO> getAllOrder(){
		List<OrderDTO> orderDTOs = new ArrayList<OrderDTO>();
		List<Orders>orders = orderDAO.findAll();
		
		for(Orders order : orders ) {
			OrderDTO orderDTO = new OrderDTO();
			orderDTO.setId(order.getId());
			orderDTO.setNgay(order.getNgay());
			orderDTO.setCuaHang(order.getCuaHang());
			orderDTO.setDiaChi(order.getDiaChi());
			orderDTO.setEmail(order.getEmail());
			orderDTO.setPhone(order.getPhone());
			orderDTO.setTenKH(order.getTenKH());
			orderDTO.setTenNguoiBan(order.getTenNguoiBan());
			orderDTO.setTongTien(order.getTongTien());
			orderDTO.setTrangThai(order.getTrangThai());				
			
			List<OrderItemDTO>itemDTOs = new ArrayList<OrderItemDTO>();
			List<OrderItem>items = order.getOrderItems();
			
			for(OrderItem or : items) {
				OrderItemDTO itemDTO = new OrderItemDTO();
				
				itemDTO.setMa(or.getId());
				itemDTO.setSoLuong(or.getSoLuong());
				itemDTO.setThanhTien(or.getThanhTien());
				ProductDTO productDTO = new ProductDTO();
				productDTO.setMaSP(or.getProduct().getMaSP());
				productDTO.setTenSP(or.getProduct().getTenSP());
				productDTO.setDonVi(or.getProduct().getDonVi());
				productDTO.setDonGia(or.getProduct().getDonGia());
				itemDTO.setProduct(productDTO);
				itemDTOs.add(itemDTO);
			}
			orderDTO.setOrderItems(itemDTOs);
			orderDTOs.add(orderDTO);
			
		}	
		return orderDTOs;
	}
	
	
	
	public List<OrderItemDTO> getOrderItemByOrderId (int id ){		
		Orders orders = orderDAO.findOrderById(id);		
		List<OrderItemDTO>itemDTOs = new ArrayList<OrderItemDTO>();
		List<OrderItem>items = orders.getOrderItems();
		
		for(OrderItem or : items) {
			OrderItemDTO itemDTO = new OrderItemDTO();
			
			itemDTO.setMa(or.getId()); 
			itemDTO.setSoLuong(or.getSoLuong());
			itemDTO.setThanhTien(or.getThanhTien());
			ProductDTO productDTO = new ProductDTO();
			productDTO.setMaSP(or.getProduct().getMaSP());
			productDTO.setTenSP(or.getProduct().getTenSP());
			productDTO.setDonVi(or.getProduct().getDonVi());
			
			productDTO.setDonGia(or.getProduct().getDonGia());
			itemDTO.setProduct(productDTO);
			
			itemDTOs.add(itemDTO);
		}
		
		
		return itemDTOs;
	}
	
	public void deleteOneOrderById(Integer id) {
		orderDAO.deleteById(id);
	}
	


	
	
	
}
