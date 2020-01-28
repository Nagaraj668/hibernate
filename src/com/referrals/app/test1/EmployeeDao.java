package com.referrals.app.test1;

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

public class EmployeeDao {

	public static void main(String[] args) {
		EmployeeDao dao = new EmployeeDao();

		// dao.saveEmp(new Employee("Nagaraj", "naagrajece13@gmail.com", null));
		// dao.listCertsHQL(1);

		Employee employee = dao.getEmp(1);
		
		employee.setName("naga");
		
		dao.saveEmp(employee);

		// Certificate certificate = dao.getCert(3);

		// EmployeeCertificate employeeCertificate = new EmployeeCertificate(employee,
		// certificate, true);

		// dao.saveEmp(employeeCertificate);

		// employee.getMobileNos().add(new MobileNo("6383414909"));

		// Address address = new Address("tambarm", "chennai");
		// address.setEmployee(employee);

		// employee.setAddress(address);
		// dao.saveEmp(employee);

		// employee.getMobileNos().add(new MobileNo("9944717618"));

		// dao.saveEmp(employee);

	}

	private Certificate getCert(int i) {
		Certificate certificate = null;
		Session session = HibernateFactory.getAnnotationsFactory().openSession();
		Transaction transaction = session.beginTransaction();

		try {
			certificate = session.get(Certificate.class, i);
			transaction.commit();
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return certificate;
	}

	private void getMobileNos(int i) {
		Session session = HibernateFactory.getAnnotationsFactory().openSession();
		Transaction transaction = session.beginTransaction();

		try {
			Set<MobileNo> mobileNos = session.get(Employee.class, i).getMobileNos();
			for (MobileNo mobileNo : mobileNos) {
				System.out.println(mobileNo.toString());
			}
			transaction.commit();
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private Employee getEmp(int i) {
		Employee employee = null;
		Session session = HibernateFactory.getAnnotationsFactory().openSession();
		Transaction transaction = session.beginTransaction();

		try {
			employee = session.get(Employee.class, i);
			transaction.commit();
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return employee;
	}

	private void listCertsHQL(int i) {
		Session session = HibernateFactory.getAnnotationsFactory().openSession();
		Transaction transaction = session.beginTransaction();

		try {
			Query<Certificate> query = session.createQuery("from Certificate where id =1");
			List<Certificate> certificates = query.getResultList();

			for (Certificate certificate : certificates) {
				System.out.println(certificate.toString());
			}

			transaction.commit();
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void listCerts(int empId) {
		Session session = HibernateFactory.getAnnotationsFactory().openSession();
		Transaction transaction = session.beginTransaction();

		try {
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<Certificate> criteriaQuery = builder.createQuery(Certificate.class);

			Root<Certificate> root = criteriaQuery.from(Certificate.class);

			criteriaQuery.select(root).where(builder.equal(root.get("id"), empId));

			Query<Certificate> query = session.createQuery(criteriaQuery);

			List<Certificate> certificates = query.getResultList();

			for (Certificate certificate : certificates) {
				System.out.println(certificate.toString());
			}

			transaction.commit();
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	void saveEmp(Employee employee) {
		Session session = HibernateFactory.getAnnotationsFactory().openSession();
		Transaction transaction = session.beginTransaction();

		try {
			session.update(employee);
			transaction.commit();
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
	}
}
