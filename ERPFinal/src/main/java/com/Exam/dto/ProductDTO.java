package com.Exam.dto;

import java.util.Date;

public class ProductDTO {
		
	
	int maSP;
	String tenSP;
	int donGia;
	String donVi;
	
	
	public int getMaSP() {
		return maSP;
	}
	public void setMaSP(int maSP) {
		this.maSP = maSP;
	}
	public String getTenSP() {
		return tenSP;
	}
	public void setTenSP(String tenSP) {
		this.tenSP = tenSP;
	}
	public int getDonGia() {
		return donGia;
	}
	public void setDonGia(int donGia) {
		this.donGia = donGia;
	}
	public String getDonVi() {
		return donVi;
	}
	public void setDonVi(String donVi) {
		this.donVi = donVi;
	}
	
	
	public ProductDTO() {
		super();
	}
	public ProductDTO(int maSP, String tenSP, int donGia, String donVi, int soLuong) {
		super();
		this.maSP = maSP;
		this.tenSP = tenSP;
		this.donGia = donGia;
		this.donVi = donVi;
		
		
	}
	
	
	
}
