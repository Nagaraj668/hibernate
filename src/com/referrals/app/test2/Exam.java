package com.referrals.app.test2;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Exam {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "personExamId.exam", fetch = FetchType.LAZY)
	private Set<PersonExam> personExams;
	
	public Exam() {
		super();
	}

	public Exam(int id, String name) {
		super();
		this.id = id;
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
		return "Exam [id=" + id + ", name=" + name + "]";
	}
}
