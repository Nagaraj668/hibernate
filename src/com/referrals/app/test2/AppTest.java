package com.referrals.app.test2;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.referrals.app.HibernateFactory;

public class AppTest {

	public static void main(String[] args) {

		AppTest appTest = new AppTest();
		appTest.testTablePerSubclass();
	}

	private void testTablePerSubclass() {
		Session session = HibernateFactory.getAnnotationsFactory().openSession();
		Transaction transaction = session.beginTransaction();
		
		try {
			Employee employee = (Employee)session.get(Employee.class, 17);
			employee.setSalary(new BigDecimal(74000.00));
			
			session.saveOrUpdate(employee);
			transaction.commit();
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void testPersonAddress() {
		Person person = new Person("Raja");

		Set<Certificate> certificates = new HashSet<>();
		certificates.add(new Certificate("C++"));
		certificates.add(new Certificate("Android"));
		
		person.setCertificates(certificates);
		
		Session session = HibernateFactory.getAnnotationsFactory().openSession();
		Transaction transaction = session.beginTransaction();
		
		session.save(person);
		transaction.commit();
		session.close();
	}

	private void fetchPerson() {
		Session session = HibernateFactory.getAnnotationsFactory().openSession();
		Transaction transaction = session.beginTransaction();

		try {
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<Person> criteriaQuery = builder.createQuery(Person.class);
			Root<Person> root = criteriaQuery.from(Person.class);

			criteriaQuery.select(root)
					.where(builder.and(builder.greaterThan(root.get("id"), 5), builder.lessThan(root.get("id"), 7)));

			Query<Person> query = session.createQuery(criteriaQuery);
			List<Person> persons = query.getResultList();

			for (Person person : persons) {
				System.out.println(person.getPersonExams().toString());
			}

			transaction.commit();
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private void testPerson() {
		Person person = new Person("Nagaraj");

		Exam exam = new Exam();
		exam.setName("C++");

		Session session = HibernateFactory.getAnnotationsFactory().openSession();
		Transaction transaction = session.beginTransaction();

		try {
			session.save(exam);

			PersonExam personExam = new PersonExam();
			personExam.setExam(exam);
			personExam.setPerson(person);
			personExam.setNoOfArrears(34);

			Set<PersonExam> personExams = new HashSet<>();
			personExams.add(personExam);

			person.setPersonExams(personExams);

			session.save(person);

			transaction.commit();
			session.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
