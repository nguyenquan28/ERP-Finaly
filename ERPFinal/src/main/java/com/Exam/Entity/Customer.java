package com.Exam.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "customer")
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int maKH;
	String tenKH;
	String diaChi;
	String phone;
	int namSinh;
	String email;
	String gioiTinh;
	int maDonHang; 
	

	public int getMaKH() {
		return maKH;
	}


	public void setMaKH(int maKH) {
		this.maKH = maKH;
	}


	public String getTenKH() {
		return tenKH;
	}


	public void setTenKH(String tenKH) {
		this.tenKH = tenKH;
	}


	public String getDiaChi() {
		return diaChi;
	}


	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public int getNamSinh() {
		return namSinh;
	}


	public void setNamSinh(int namSinh) {
		this.namSinh = namSinh;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getGioiTinh() {
		return gioiTinh;
	}


	public void setGioiTinh(String gioiTinh) {
		this.gioiTinh = gioiTinh;
	}

	public int getMaDonHang() {
		return maDonHang;
	}


	public void setMaDonHang(int maDonHang) {
		this.maDonHang = maDonHang;
	}

	public Customer(int maKH, String tenKH, String diaChi, String phone, int namSinh, String email, String gioiTinh,
			int maDonHang) {
		super();
		this.maKH = maKH;
		this.tenKH = tenKH;
		this.diaChi = diaChi;
		this.phone = phone;
		this.namSinh = namSinh;
		this.email = email;
		this.gioiTinh = gioiTinh;
		this.maDonHang = maDonHang;
	}


	public Customer() {
		super();
	}
	
	@Override
	public String toString() {
		return "Customer[maKH =" + "maKH" + ", tenKH= " + "tenKH" + ", diaChi= " + "diaChi" + ", phone= " + 
				"phone" + ", namSinh= " + "namSinh" + ", email= " + "email" + ", gioiTinh= " + "gioiTinh" + 
				", maDonHang= " + "maDonHang" + "]";
	}

}
