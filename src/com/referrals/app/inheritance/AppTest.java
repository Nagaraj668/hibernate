package com.referrals.app.inheritance;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.referrals.app.HibernateFactory;

public class AppTest {

	public static void main(String[] args) {

		AppTest appTest = new AppTest();
		appTest.testMappedSuperClass();
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
