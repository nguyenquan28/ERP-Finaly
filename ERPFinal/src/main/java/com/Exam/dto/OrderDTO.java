package com.Exam.dto;

<<<<<<< HEAD
import java.util.Date;
import java.util.List;

import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import com.Exam.Entity.Product;

=======
import java.util.List;

>>>>>>> 9871b449c1a0415fd0680337103379966462a6cf
public class OrderDTO {
	
	
	
	String ngay;
	String tenKH;
	String email;
	int phone;
	String diaChi;
	String tenNguoiBan;
	String cuaHang;	
	String trangThai;			
	int tongTien;
	List<OrderItemDTO>orderItems; 
	
	
	
	
	
	
	public List<OrderItemDTO> getOrderItems() {
		return orderItems;
	}
	public void setOrderItems(List<OrderItemDTO> orderItems) {
		this.orderItems = orderItems;
	}
	public int getTongTien() {
		return tongTien;
	}
	public void setTongTien(int tongTien) {
		this.tongTien = tongTien;
	}
	
	public String getNgay() {
		return ngay;
	}
	public void setNgay(String ngay) {
		this.ngay = ngay;
	}
	public String getTenKH() {
		return tenKH;
	}
	public void setTenKH(String tenKH) {
		this.tenKH = tenKH;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getPhone() {
		return phone;
	}
	public void setPhone(int phone) {
		this.phone = phone;
	}
	public String getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	public String getTenNguoiBan() {
		return tenNguoiBan;
	}
	public void setTenNguoiBan(String tenNguoiBan) {
		this.tenNguoiBan = tenNguoiBan;
	}
	public String getCuaHang() {
		return cuaHang;
	}
	public void setCuaHang(String cuaHang) {
		this.cuaHang = cuaHang;
	}
	public String getTrangThai() {
		return trangThai;
	}
	public void setTrangThai(String trangThai) {
		this.trangThai = trangThai;
	}
	
	public OrderDTO(int id, String ngay, String tenKH, String email, int phone, String diaChi, String tenNguoiBan,
			String cuaHang, String trangThai) {
		super();
		
		this.ngay = ngay;
		this.tenKH = tenKH;
		this.email = email;
		this.phone = phone;
		this.diaChi = diaChi;
		this.tenNguoiBan = tenNguoiBan;
		this.cuaHang = cuaHang;
		this.trangThai = trangThai;
		
	}
	public OrderDTO() {
		super();
	}
	
	
	
}
