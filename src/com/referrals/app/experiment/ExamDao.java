package com.referrals.app.experiment;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.referrals.app.HibernateFactory;

public class ExamDao {
	SessionFactory factory = HibernateFactory.getAnnotationsFactory();

	public static void main(String[] args) {

		ExamDao dao = new ExamDao();
		dao.listExams();

	}

	@SuppressWarnings("unchecked")
	public void listExams() {

		try {
			Session session = factory.openSession();
			Transaction transaction = session.beginTransaction();

			List<Exam> exams = (List<Exam>) session.createQuery("FROM Exam").list();

			for (Exam exam : exams) {
				System.out.println(exam.toString());
			}

			transaction.commit();
			session.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public void createExam() {
		try {
			Session session = factory.openSession();
			Transaction transaction = session.beginTransaction();

			Subject subject = new Subject("C");
			Subject subject1 = new Subject("C++");
			
			Set<Subject> subjects = new HashSet<>();
			subjects.add(subject);
			subjects.add(subject1);

			Exam exam = new Exam("Sem2", subjects);

			session.save(exam);
			transaction.commit();

			session.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
