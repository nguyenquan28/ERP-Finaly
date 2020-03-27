package com.Exam.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "salescode")
public class SalesCode {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int maCa;
	String tenMaCa;
	String thoiGian;

	public int getMaCa() {
		return maCa;
	}

	public void setMaCa(int maCa) {
		this.maCa = maCa;
	}

	public String getTenMaCa() {
		return tenMaCa;
	}

	public void setTenMaCa(String tenMaCa) {
		this.tenMaCa = tenMaCa;
	}

	public String getThoiGian() {
		return thoiGian;
	}

	public void setThoiGian(String thoiGian) {
		this.thoiGian = thoiGian;
	}

	public SalesCode(int maCa, String tenMaCa, String thoiGian) {
		super();
		this.maCa = maCa;
		this.tenMaCa = tenMaCa;
		this.thoiGian = thoiGian;
	}

	public SalesCode() {
		super();
	}

}
