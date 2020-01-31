package com.referrals.app.test2;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name = "emp_id")
public class Employee extends Person {

	private BigDecimal salary;

	public Employee() {
		super();
	}

	public Employee(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	public Employee(BigDecimal salary) {
		super();
		this.salary = salary;
	}

	public BigDecimal getSalary() {
		return salary;
	}

	public void setSalary(BigDecimal salary) {
		this.salary = salary;
	}

}
