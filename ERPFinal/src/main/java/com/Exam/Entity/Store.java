package com.Exam.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "stores")
public class Store {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int maCuaHang;
	String tenCuaHang;
	String diaChi;

	public int getMaCuaHang() {
		return maCuaHang;
	}

	public void setMaCuaHang(int maCuaHang) {
		this.maCuaHang = maCuaHang;
	}

	public String getTenCuaHang() {
		return tenCuaHang;
	}

	public void setTenCuaHang(String tenCuaHang) {
		this.tenCuaHang = tenCuaHang;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public Store(int maCuaHang, String tenCuaHang, String diaChi) {
		super();
		this.maCuaHang = maCuaHang;
		this.tenCuaHang = tenCuaHang;
		this.diaChi = diaChi;
	}

	public Store() {
		super();
	}

}
