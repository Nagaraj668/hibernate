package com.referrals.app.dependency;

import java.io.Serializable;

public class Referral implements Serializable {
	private static final long serialVersionUID = 1L;
	private int referralId;
	private String name;
	private String emailId;
	private String contactNo;
	private int totalExperience;
	private String designation;

	public Referral() {
		super();
	}

	public Referral(int referralId, String name, String emailId, String contactNo, int totalExperience,
			String designation) {
		super();
		this.referralId = referralId;
		this.name = name;
		this.emailId = emailId;
		this.contactNo = contactNo;
		this.totalExperience = totalExperience;
		this.designation = designation;
	}

	public int getReferralId() {
		return referralId;
	}

	public void setReferralId(int referralId) {
		this.referralId = referralId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public int getTotalExperience() {
		return totalExperience;
	}

	public void setTotalExperience(int totalExperience) {
		this.totalExperience = totalExperience;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (!this.getClass().equals(obj.getClass()))
			return false;

		Referral obj2 = (Referral) obj;
		if ((this.referralId == obj2.getReferralId()) && (this.name.equals(obj2.getName()))) {
			return true;
		}
		return false;
	}

	public int hashCode() {
		int tmp = 0;
		tmp = (referralId + name).hashCode();
		return tmp;
	}

	@Override
	public String toString() {
		return "Referral [referralId=" + referralId + ", name=" + name + ", emailId=" + emailId + ", contactNo="
				+ contactNo + ", totalExperience=" + totalExperience + ", designation=" + designation + "]";
	}
}
