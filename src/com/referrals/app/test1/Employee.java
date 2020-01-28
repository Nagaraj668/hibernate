package com.referrals.app.test1;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.DynamicUpdate;

@Entity
@org.hibernate.annotations.Entity(
		dynamicUpdate = true, selectBeforeUpdate = true
)
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String email;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "employee_certificate", joinColumns = {
			@JoinColumn(name = "employee_id") }, inverseJoinColumns = { @JoinColumn(name = "certificate_id") })
	private Set<Certificate> certificates;

	@OneToMany(mappedBy = "employee", fetch = FetchType.EAGER)
	private Set<EmployeeCertificate> employeeCertificates;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "employee_id")
	private Set<MobileNo> mobileNos;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id", referencedColumnName = "employee_id")
	private Address address;

	public Set<EmployeeCertificate> getEmployeeCertificates() {
		return employeeCertificates;
	}

	public void setEmployeeCertificates(Set<EmployeeCertificate> employeeCertificates) {
		this.employeeCertificates = employeeCertificates;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Set<MobileNo> getMobileNos() {
		return mobileNos;
	}

	public void setMobileNos(Set<MobileNo> mobileNos) {
		this.mobileNos = mobileNos;
	}

	public Employee() {
		super();
	}

	public Employee(String name, String email, Set<Certificate> certificates) {
		super();
		this.name = name;
		this.email = email;
		this.certificates = certificates;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Set<Certificate> getCertificates() {
		return certificates;
	}

	public void setCertificates(Set<Certificate> certificates) {
		this.certificates = certificates;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", email=" + email + ", certificates=" + "]";
	}
}
