package com.referrals.app.tutorialspoint;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.referrals.app.HibernateFactory;

public class EmployeeDao {

	public static void main(String[] args) {

		SessionFactory factory = HibernateFactory.getAnnotationsFactory();
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();

		Certificate certificate = new Certificate("C");
		Certificate certificate1 = new Certificate("C++");

		Set<Certificate> certificates = new HashSet<>();
		certificates.add(certificate);
		certificates.add(certificate1);

		Employee employee = new Employee("Nagaraj", "N", 60000);
		employee.setCertificates(certificates);

		session.save(employee);
		transaction.commit();
		session.close();
	}

}
