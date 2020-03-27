package com.Exam.Entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Sale {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int maHD;
	int license;
	Date dateSales;
	int maKH;
	int maNhanVien;
	int maCa;
	int tongTien;

	public int getMaHD() {
		return maHD;
	}

	public void setMaHD(int maHD) {
		this.maHD = maHD;
	}

	public int getLicense() {
		return license;
	}

	public void setLicense(int license) {
		this.license = license;
	}

	public Date getDateSales() {
		return dateSales;
	}

	public void setDateSales(Date dateSales) {
		this.dateSales = dateSales;
	}

	public int getMaKH() {
		return maKH;
	}

	public void setMaKH(int maKH) {
		this.maKH = maKH;
	}

	public int getMaNhanVien() {
		return maNhanVien;
	}

	public void setMaNhanVien(int maNhanVien) {
		this.maNhanVien = maNhanVien;
	}

	public int getMaCa() {
		return maCa;
	}

	public void setMaCa(int maCa) {
		this.maCa = maCa;
	}

	public int getTongTien() {
		return tongTien;
	}

	public void setTongTien(int tongTien) {
		this.tongTien = tongTien;
	}

	public Sale() {
		super();
	}

	public Sale(int maHD, int license, Date dateSales, int maKH, int maNhanVien, int maCa, int tongTien) {
		super();
		this.maHD = maHD;
		this.license = license;
		this.dateSales = dateSales;
		this.maKH = maKH;
		this.maNhanVien = maNhanVien;
		this.maCa = maCa;
		this.tongTien = tongTien;
	}

}
