package com.referrals.app.dependency;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class SkillDao {

	public void createSkill(Skill skill) {
		AssociateDAO associateDAO = new AssociateDAO();
		SessionFactory sessionFactory = associateDAO.getSessionFactory();
		Session session = sessionFactory.openSession();
		try {
			Transaction transaction = session.beginTransaction();
			session.save(skill);
			transaction.commit();
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
