package com.referrals.app.test2;

import java.beans.Transient;
import java.io.Serializable;

import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "person_exam")
@AssociationOverrides({ @AssociationOverride(name = "pk.person", joinColumns = @JoinColumn(name = "person_id")),
		@AssociationOverride(name = "pk.exam", joinColumns = @JoinColumn(name = "exam_id")) })
public class PersonExam implements Serializable {

	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private PersonExamId personExamId = new PersonExamId();

	@Column(name = "no_of_arrears")
	private int noOfArrears;

	public PersonExam() {
		super();
	}

	public PersonExam(PersonExamId pk, int noOfArrears) {
		super();
		this.personExamId = pk;
		this.noOfArrears = noOfArrears;
	}

	@Transient
	public Person getPerson() {
		return this.getPk().getPerson();
	}

	public void setPerson(Person person) {
		this.getPk().setPerson(person);
	}

	@Transient
	public Exam getExam() {
		return this.getPk().getExam();
	}

	public void setExam(Exam exam) {
		this.getPk().setExam(exam);
	}

	public PersonExamId getPk() {
		return personExamId;
	}

	public void setPk(PersonExamId pk) {
		this.personExamId = pk;
	}

	public int getNoOfArrears() {
		return noOfArrears;
	}

	public void setNoOfArrears(int noOfArrears) {
		this.noOfArrears = noOfArrears;
	}
}
