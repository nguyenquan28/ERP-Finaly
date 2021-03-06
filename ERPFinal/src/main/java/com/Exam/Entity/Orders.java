package com.Exam.Entity;

import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

import org.apache.lucene.analysis.core.KeywordAnalyzer;
import org.hibernate.search.annotations.*;
import org.hibernate.search.annotations.Index;
import org.hibernate.search.bridge.builtin.IntegerBridge;


@Entity
@Table(name = "orders")
@Indexed
public class Orders {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)		
	@DocumentId
	int id;	
	
	
	String ngay;
	
	@Field
	String tenKH;	
	@Field(termVector = TermVector.YES)
	String email;
	
	int phone;
	String diaChi;
	String tenNguoiBan;
	String cuaHang;	
	@Field
	String trangThai;
	int tongTien;
	
	@OneToMany(mappedBy = "order",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@IndexedEmbedded
	List<OrderItem>orderItems;
	
	public int getTongTien() {
		return tongTien;
	}

	public void setTongTien(int tongTien) {
		this.tongTien = tongTien;
	}	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	

	public Orders() {
		super();
	}

	public Orders(int id, String ngay, String tenKH, String email, int phone, String diaChi, String tenNguoiBan,
			String cuaHang, String trangThai) {
		super();
		this.id = id;
		this.ngay = ngay;
		this.tenKH = tenKH;
		this.email = email;
		this.phone = phone;
		this.diaChi = diaChi;
		this.tenNguoiBan = tenNguoiBan;
		this.cuaHang = cuaHang;
		this.trangThai = trangThai;
		
	}

	public List<OrderItem> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(List<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}

	
	
	
	

	

	

	
	
	
	
	
	
}
