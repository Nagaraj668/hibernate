package com.referrals.app.test1;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "mobile_no")
public class MobileNo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String number;
	
	public MobileNo() {
		super();
	}

	public MobileNo(String name) {
		super();
		this.number = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String name) {
		this.number = name;
	}

	@Override
	public String toString() {
		return "MobileNo [id=" + id + ", name=" + number + "]";
	}
}
