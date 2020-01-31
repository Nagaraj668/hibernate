package com.referrals.app.inheritance;

import javax.persistence.Entity;

@Entity
public class Employee extends Person {

	private String company;

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employee(int id, String name) {
		super(id, name);
		// TODO Auto-generated constructor stub
	}

	public Employee(String company) {
		super();
		this.company = company;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}
}