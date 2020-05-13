package com.Exam.Service;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.Order;
import javax.transaction.Transactional;

import org.apache.lucene.search.Query;
import org.hibernate.search.jpa.FullTextEntityManager;
import org.hibernate.search.jpa.FullTextQuery;
import org.hibernate.search.jpa.Search;
import org.hibernate.search.query.dsl.QueryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.Exam.DAO.CustomerDAO;
import com.Exam.DAO.OrderDAO;

import com.Exam.DAO.OrderItemDAO;
import com.Exam.DAO.SearchOrderDAO;
import com.Exam.Entity.Customer;
import com.Exam.Entity.OrderItem;
import com.Exam.Entity.Orders;
import com.Exam.Entity.Product;
import com.Exam.dto.OrderDTO;
import com.Exam.dto.OrderItemDTO;
import com.Exam.dto.ProductDTO;

@Service
public class OrderService {
	@PersistenceContext EntityManager en;
	@Autowired OrderDAO orderDAO;
	@Autowired OrderItemDAO orderItemDAO;
	@Autowired CustomerDAO customerDAO;
	@Autowired
	SearchOrderDAO daoS;
//	@Autowired OrderDAOPaging paging;

	DecimalFormat df2 = new DecimalFormat( "#,###,###,##0.00" );
	
	public int pageCount() {
		return orderDAO.pageCount();
	}
	public int demDanhSachChuaThanhToan() {
		return orderDAO.listChuaThanhToanCount();
	}
	
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
		
		Customer customer = new Customer();
		customer.setTenKH(orderDTO.getTenKH());
		customer.setDiaChi(orderDTO.getDiaChi());
		customer.setPhone(String.valueOf(orderDTO.getPhone()));
		customer.setEmail(orderDTO.getEmail());
		customerDAO.save(customer);
		
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

	
	public List<OrderDTO> getAllOrder(int pageNumber){
		List<OrderDTO> orderDTOs = new ArrayList<OrderDTO>();
		List<Orders>orders = orderDAO.findAll(PageRequest.of(pageNumber, 5)).toList();
		
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
			orderDTO.setTongSoTien(df2.format(order.getTongTien()));
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
	
	
	public List<OrderDTO>listOrderUnPaid(int pageNumber){
		List<OrderDTO> orderDTOs = new ArrayList<OrderDTO>();
		List<Orders>orders = orderDAO.getOrdersUnPaid(PageRequest.of(pageNumber, 5));
		
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
			orderDTO.setTongSoTien(df2.format(order.getTongTien()));
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
	
	public void updateOrder(int id ,String trangthai) {
		this.orderDAO.updateOrder(id, trangthai);
	}
	
	public void deleteOneOrderById(Integer id) {
		orderDAO.deleteById(id);
	}
	public OrderDTO getOrderByOrderId (int id ){		
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
		
		OrderDTO orderDTO = new OrderDTO(orders.getId(), orders.getNgay(), orders.getTenKH(), orders.getEmail(), orders.getPhone(), orders.getDiaChi(), orders.getTenNguoiBan(), orders.getCuaHang(), orders.getTrangThai());
		orderDTO.setOrderItems(itemDTOs);
		
		
		return orderDTO;
	}
	
	
	
	
	public List<OrderDTO> search (String q,int pageNumber) {
		
		List<Orders>orders = daoS.search(q,pageNumber);
		List<OrderDTO> orderDTOs = new ArrayList<OrderDTO>();
		
		
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
			orderDTO.setTongSoTien(df2.format(order.getTongTien()));
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
	public List<OrderDTO>  chuathanhtoan(String q) {
		List<Orders>orders = daoS.timKhachHangChuaThanhToan(q);
		List<OrderDTO> orderDTOs = new ArrayList<OrderDTO>();
		
		
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
			orderDTO.setTongSoTien(df2.format(order.getTongTien()));
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
	public int searchResultCount(String q) {
		
		int resultCount = daoS.searchResultCount(q);
		return resultCount;
	}
	
	
}
