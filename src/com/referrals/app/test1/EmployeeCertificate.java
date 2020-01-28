package com.referrals.app.test1;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "employee_certificate")
public class EmployeeCertificate {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "employee_id")
	private Employee employee;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "certificate_id")
	private Certificate certificate;

	private boolean expired;

	public EmployeeCertificate() {
		super();
		// TODO Auto-generated constructor stub
	}

	public EmployeeCertificate(Employee employee, Certificate certificate, boolean expired) {
		super();
		this.employee = employee;
		this.certificate = certificate;
		this.expired = expired;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Certificate getCertificate() {
		return certificate;
	}

	public void setCertificate(Certificate certificate) {
		this.certificate = certificate;
	}

	public boolean isExpired() {
		return expired;
	}

	public void setExpired(boolean expired) {
		this.expired = expired;
	}
}
