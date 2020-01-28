package com.referrals.app.test1;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Certificate {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;

	@OneToMany(mappedBy = "employee")
	private Set<EmployeeCertificate> employeeCertificates;

	public Certificate() {
		super();
	}

	public Certificate(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	public Set<EmployeeCertificate> getEmployeeCertificates() {
		return employeeCertificates;
	}

	public void setEmployeeCertificates(Set<EmployeeCertificate> employeeCertificates) {
		this.employeeCertificates = employeeCertificates;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Certificate [id=" + id + ", name=" + name + "]";
	}
}
