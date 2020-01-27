package com.referrals.app.dependency;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Associate {
	
	@Id
	private int associateId;
	private String associateName;
	private String designation;
	private String contactNo;
	private String emailId;
	private String workLocation;

	public Associate() {
		super();
	}

	public Associate(int associateId, String associateName, String designation, String contactNo, String emailId,
			String workLocation) {
		super();
		this.associateId = associateId;
		this.associateName = associateName;
		this.designation = designation;
		this.contactNo = contactNo;
		this.emailId = emailId;
		this.workLocation = workLocation;
	}

	public int getAssociateId() {
		return associateId;
	}

	public void setAssociateId(int associateId) {
		this.associateId = associateId;
	}

	public String getAssociateName() {
		return associateName;
	}

	public void setAssociateName(String associateName) {
		this.associateName = associateName;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getWorkLocation() {
		return workLocation;
	}

	public void setWorkLocation(String workLocation) {
		this.workLocation = workLocation;
	}
}
