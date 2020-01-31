package com.referrals.app.test2;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Person {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "personExamId.person", fetch = FetchType.LAZY)
	private Set<PersonExam> personExams;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id", referencedColumnName = "person_id")
	private Address address;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "person_id")
	private Set<Mobile> mobiles;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "person_cert", joinColumns = @JoinColumn(name = "person_id"), inverseJoinColumns = @JoinColumn(name = "cert_id"))
	private Set<Certificate> certificates;

	public Set<Certificate> getCertificates() {
		return certificates;
	}

	public void setCertificates(Set<Certificate> certificates) {
		this.certificates = certificates;
	}

	public Set<Mobile> getMobiles() {
		return mobiles;
	}

	public void setMobiles(Set<Mobile> mobiles) {
		this.mobiles = mobiles;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Person() {
		super();
	}

	public Person(String name) {
		super();
		this.name = name;
	}

	public Set<PersonExam> getPersonExams() {
		return personExams;
	}

	public void setPersonExams(Set<PersonExam> personExams) {
		this.personExams = personExams;
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
		return "Person [id=" + id + ", name=" + name + "]";
	}
}
