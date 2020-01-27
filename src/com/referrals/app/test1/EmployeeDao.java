package com.referrals.app.test1;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.referrals.app.HibernateFactory;

public class EmployeeDao {

	public static void main(String[] args) {
		EmployeeDao dao = new EmployeeDao();

		// dao.saveEmp(new Employee("Nagaraj", "naagrajece13@gmail.com", null));

		// dao.listCertsHQL(1);

		Employee employee = dao.getEmp(1);

		Set<MobileNo> mobileNos = new HashSet<>();
		mobileNos.add(new MobileNo("8939980527"));
		mobileNos.add(new MobileNo("8939980528"));

		employee.setMobileNos(mobileNos);
		dao.saveEmp(employee);
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
			session.saveOrUpdate(employee);
			transaction.commit();
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
