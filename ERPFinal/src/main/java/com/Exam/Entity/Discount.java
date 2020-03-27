package com.Exam.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "discount")
public class Discount {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int maKM;
	String tenKM;
	double phanTramKM;

	public int getMaKM() {
		return maKM;
	}

	public void setMaKM(int maKM) {
		this.maKM = maKM;
	}

	public String getTenKM() {
		return tenKM;
	}

	public void setTenKM(String tenKM) {
		this.tenKM = tenKM;
	}

	public double getPhanTramKM() {
		return phanTramKM;
	}

	public void setPhanTramKM(double phanTramKM) {
		this.phanTramKM = phanTramKM;
	}

	public Discount() {
		super();
	}

	public Discount(int maKM, String tenKM, double phanTramKM) {
		super();
		this.maKM = maKM;
		this.tenKM = tenKM;
		this.phanTramKM = phanTramKM;
	}

}
