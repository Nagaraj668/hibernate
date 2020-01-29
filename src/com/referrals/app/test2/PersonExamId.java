package com.referrals.app.test2;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

@Embeddable
public class PersonExamId implements Serializable {

	private static final long serialVersionUID = 1L;

	@ManyToOne
	private Person person;

	@ManyToOne
	private Exam exam;

	public PersonExamId() {
		super();
	}

	public PersonExamId(Person person, Exam exam) {
		super();
		this.person = person;
		this.exam = exam;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public Exam getExam() {
		return exam;
	}

	public void setExam(Exam exam) {
		this.exam = exam;
	}
}
