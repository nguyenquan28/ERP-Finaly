package com.Exam.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "company")
public class Company {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "mact")
	int maCT;
	@Column(name = "tenct")
	String tenCT;
	@Column(name = "nguoi_dai_dien")
	String nguoiDaiDien;
	@Column(name = "email")
	String email;
	@Column(name = "so_thue")
	String soThue;
	@Column(name = "phone")
	int phone;
	@Column(name = "dia_chi")
	String diaChi;

	public int getMaCT() {
		return maCT;
	}

	public void setMaCT(int maCT) {
		this.maCT = maCT;
	}

	public String getTenCT() {
		return tenCT;
	}

	public void setTenCT(String tenCT) {
		this.tenCT = tenCT;
	}

	public String getNguoiDaiDien() {
		return nguoiDaiDien;
	}

	public void setNguoiDaiDien(String nguoiDaiDien) {
		this.nguoiDaiDien = nguoiDaiDien;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSoThue() {
		return soThue;
	}

	public void setSoThue(String soThue) {
		this.soThue = soThue;
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

	public Company(int maCT, String tenCT, String nguoiDaiDien, String email, String soThue, int phone, String diaChi) {
		super();
		this.maCT = maCT;
		this.tenCT = tenCT;
		this.nguoiDaiDien = nguoiDaiDien;
		this.email = email;
		this.soThue = soThue;
		this.phone = phone;
		this.diaChi = diaChi;
	}
	
	@Override
	public String toString() {
		return "Company [maCT=" + maCT + ", tenCT=" + tenCT + ", nguoiDaiDien=" + nguoiDaiDien + ", email=" + email
				+ ", soThue=" + soThue + ", phone=" + phone + ", diaChi=" + diaChi + "]";
	}
	
	public Company() {
		super();
	}

}
