package com.referrals.app.experiment;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "subjects")
public class Subject {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "subject_name")
	private String subjectName;

	@ManyToMany(mappedBy = "subjects")
	private Set<Exam> exams;

	public Subject() {
		super();
	}

	public Subject(String subjectName) {
		super();
		this.subjectName = subjectName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public Set<Exam> getExams() {
		return exams;
	}

	public void setExams(Set<Exam> exams) {
		this.exams = exams;
	}
}
