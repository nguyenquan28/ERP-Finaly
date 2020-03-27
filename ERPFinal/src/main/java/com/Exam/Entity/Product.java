package com.Exam.Entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "product")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "MaSP")
	int maSP;
	@Column(name = "TenSP")
	String tenSP;
	@Column(name = "DonGia")
	int donGia;
	@Column(name = "DonVi")
	String donVi;
	@Column(name = "SoLuong")
	int soLuong;
	@Column(name = "Size")
	String Size;
	@Column(name = "PhanLoai")
	String phanLoai;
	@Column(name = "giaGoc")
	int giaGoc;
	@Column(name = "ngaySanXuat")
	Date ngaySanXuat;
	@Column(name = "hanSuDung")
	Date hanSuDung;

	public Date getNgaySanXuat() {
		return ngaySanXuat;
	}

	public void setNgaySanXuat(Date ngaySanXuat) {
		this.ngaySanXuat = ngaySanXuat;
	}

	public Date getHanSuDung() {
		return hanSuDung;
	}

	public void setHanSuDung(Date hanSuDung) {
		this.hanSuDung = hanSuDung;
	}

	public Product() {
		super();
	}

	public Product(int maSP, String tenSP, int donGia, String donVi, int soLuong, String size, String phanLoai,
			int giaGoc, Date ngaySanXuat, Date hanSuDung) {
		super();
		this.maSP = maSP;
		this.tenSP = tenSP;
		this.donGia = donGia;
		this.donVi = donVi;
		this.soLuong = soLuong;
		Size = size;
		this.phanLoai = phanLoai;
		this.giaGoc = giaGoc;
		this.ngaySanXuat = ngaySanXuat;
		this.hanSuDung = hanSuDung;
	}

	public int getGiaGoc() {
		return giaGoc;
	}

	public void setGiaGoc(int giaGoc) {
		this.giaGoc = giaGoc;
	}

	public Product(int maSP) {
		this.maSP = maSP;
	}

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

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	public String getSize() {
		return Size;
	}

	public void setSize(String size) {
		Size = size;
	}

	public String getPhanLoai() {
		return phanLoai;
	}

	public void setPhanLoai(String phanLoai) {
		this.phanLoai = phanLoai;
	}

}