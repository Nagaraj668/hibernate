package com.referrals.app.inheritance;

import java.math.BigDecimal;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.referrals.app.HibernateFactory;

public class AppTest {

	public static void main(String[] args) {

		AppTest appTest = new AppTest();
		appTest.testTablePerSubclassWithAssociation();
	}

	private void testTablePerSubclassWithAssociation() {
		CreditCardPayment payment = new CreditCardPayment();
		payment.setAmount(new BigDecimal(15000.00));
		payment.setCreditCardNumber("9678678");
		payment.setExpiry("345345");
		
		Session session = HibernateFactory.getAnnotationsFactory().openSession();
		Transaction transaction = session.beginTransaction();

		try {
			
			Customer customer = session.get(Customer.class, 1);
			session.save(customer);
			
			payment.setCustomer(customer);
			
			session.save(payment);
			
			transaction.commit();
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void testTablePerSubclass() {
		Book book = new Book("Yashwanth");
		book.setName("C Graphics");
		
		Session session = HibernateFactory.getAnnotationsFactory().openSession();
		Transaction transaction = session.beginTransaction();

		try {
			session.save(book);
			transaction.commit();
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void testMappedSuperClass() {
		Employee employee = new Employee("CTS");
		employee.setName("nagaraj n");

		Session session = HibernateFactory.getAnnotationsFactory().openSession();
		Transaction transaction = session.beginTransaction();

		try {
			session.save(employee);
			transaction.commit();
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
