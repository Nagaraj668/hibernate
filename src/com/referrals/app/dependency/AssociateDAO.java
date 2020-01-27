package com.referrals.app.dependency;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class AssociateDAO {

	private SessionFactory sessionFactory;

	public AssociateDAO() {
		super();
		try {
			sessionFactory = getAnnotationsFactory();
		} catch (Throwable ex) {
			System.err.println("Failed to create sessionFactory object." + ex);
		}
	}

	public SessionFactory getSessionFactory() {
		if (sessionFactory == null) {
			try {
				StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
				MetadataSources sources = new MetadataSources(registry);
				Metadata metadata = sources.getMetadataBuilder().build();
				sessionFactory = metadata.getSessionFactoryBuilder().build();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return sessionFactory;
	}

	public SessionFactory getAnnotationsFactory() {
		if (sessionFactory == null) {
			try {
				sessionFactory = new Configuration().configure().buildSessionFactory();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return sessionFactory;
	}

	public int createAssociate(Associate associate) {
		int associateId = 0;
		Transaction transaction = null;
		try {
			Session session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			session.save(associate);
			transaction.commit();

			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return associateId;
	}
}
