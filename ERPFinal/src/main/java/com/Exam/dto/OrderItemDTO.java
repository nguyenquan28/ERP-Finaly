package com.Exam.dto;




import com.Exam.Entity.Product;

public class OrderItemDTO {
	
	int ma;
<<<<<<< HEAD
	private ProductDTO product;
	int soLuong;
=======
	
	
	private ProductDTO product;
	
	int soLuong;
	
>>>>>>> 9871b449c1a0415fd0680337103379966462a6cf
	double thanhTien;

	public int getMa() {
		return ma;
	}

	public void setMa(int ma) {
		this.ma = ma;
	}

	public ProductDTO getProduct() {
		return product;
	}

	public void setProduct(ProductDTO product) {
		this.product = product;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	public double getThanhTien() {
		return thanhTien;
	}

	public void setThanhTien(double thanhTien) {
		this.thanhTien = thanhTien;
	}

	
	
	
}
