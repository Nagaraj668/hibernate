package com.referrals.app.experiment;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.referrals.app.HibernateFactory;

public class SubjectDao {

	public static void main(String[] args) {

		SubjectDao dao = new SubjectDao();

		dao.tagNewSubject();
	}

	private void tagNewSubject() {
		try {

			SessionFactory factory = HibernateFactory.getAnnotationsFactory();

			Session session = factory.openSession();
			Transaction transaction = session.beginTransaction();

			Exam exam = new Exam();
			exam.setId(35);

			Subject subject = new Subject();
			subject.setId(67);
			subject.setSubjectName("C Ref");

			session.saveOrUpdate(subject);

			transaction.commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
