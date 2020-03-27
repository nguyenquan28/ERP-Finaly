package com.Exam.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "payment")
public class Payment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int maHTTT;
	String tenHTTT;

	public int getMaHTTT() {
		return maHTTT;
	}

	public void setMaHTTT(int maHTTT) {
		this.maHTTT = maHTTT;
	}

	public String getTenHTTT() {
		return tenHTTT;
	}

	public void setTenHTTT(String tenHTTT) {
		this.tenHTTT = tenHTTT;
	}

	public Payment(int maHTTT, String tenHTTT) {
		super();
		this.maHTTT = maHTTT;
		this.tenHTTT = tenHTTT;
	}

	public Payment() {
		super();
	}

}
