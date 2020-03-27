package com.Exam.Entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "carts")
public class Cart {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int maGioHang;
	
	
	int license;
	int maSP;
	int soLuong;
	int donGia;
	String phanLoai;
	String donVi;
	Date ngaySanXuat;
	Date hanSuDung;
	String tenSP;
	int tongTien;

	public int getMaGioHang() {
		return maGioHang;
	}

	public void setMaGioHang(int maGioHang) {
		this.maGioHang = maGioHang;
	}

	public int getMaSP() {
		return maSP;
	}

	public void setMaSP(int maSP) {
		this.maSP = maSP;
	}

	public int getLicense() {
		return license;
	}

	public void setLicense(int license) {
		this.license = license;
	}

	public void setHanSuDung(Date hanSuDung) {
		this.hanSuDung = hanSuDung;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
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

	public String getTenSP() {
		return tenSP;
	}

	public String getPhanLoai() {
		return phanLoai;
	}

	public void setPhanLoai(String phanLoai) {
		this.phanLoai = phanLoai;
	}

	public Date getNgaySanXuat() {
		return ngaySanXuat;
	}

	public void setNgaySanXuat(Date ngaySanXuat) {
		this.ngaySanXuat = ngaySanXuat;
	}

	public Date getHanSuDung() {
		return hanSuDung;
	}

	public void setHanSuDunS(Date hanSuDung) {
		this.hanSuDung = hanSuDung;
	}

	public void setTenSP(String tenSP) {
		this.tenSP = tenSP;
	}

	public int getTongTien() {
		return tongTien;
	}

	public void setTongTien(int tongTien) {
		this.tongTien = tongTien;
	}

	public Cart(int maGioHang, int license, int maSP, int soLuong, int donGia, String phanLoai, String donVi,
			Date ngaySanXuat, Date hanSuDung, String tenSP, int tongTien) {
		super();
		this.maGioHang = maGioHang;
		this.license = license;
		this.maSP = maSP;
		this.soLuong = soLuong;
		this.donGia = donGia;
		this.phanLoai = phanLoai;
		this.donVi = donVi;
		this.ngaySanXuat = ngaySanXuat;
		this.hanSuDung = hanSuDung;
		this.tenSP = tenSP;
		this.tongTien = tongTien;
	}

	public Cart() {
		super();
	}

}
