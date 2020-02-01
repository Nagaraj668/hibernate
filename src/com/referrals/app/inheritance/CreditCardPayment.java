package com.referrals.app.inheritance;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name = "id")
public class CreditCardPayment extends Payment {

	private String creditCardNumber;
	private String expiry;

	public CreditCardPayment() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CreditCardPayment(int id, BigDecimal amount, Customer customer) {
		super(id, amount, customer);
		// TODO Auto-generated constructor stub
	}

	public CreditCardPayment(String creditCardNumber, String expiry) {
		super();
		this.creditCardNumber = creditCardNumber;
		this.expiry = expiry;
	}

	public String getCreditCardNumber() {
		return creditCardNumber;
	}

	public void setCreditCardNumber(String creditCardNumber) {
		this.creditCardNumber = creditCardNumber;
	}

	public String getExpiry() {
		return expiry;
	}

	public void setExpiry(String expiry) {
		this.expiry = expiry;
	}
}
