package com.referrals.app;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateFactory {

	public static SessionFactory getXMLSessionFactory() {
		SessionFactory sessionFactory = null;
		try {
			StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
			MetadataSources sources = new MetadataSources(registry);
			Metadata metadata = sources.getMetadataBuilder().build();
			sessionFactory = metadata.getSessionFactoryBuilder().build();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sessionFactory;
	}

	public static SessionFactory getAnnotationsFactory() {
		SessionFactory sessionFactory = null;
		try {
			sessionFactory = new Configuration().configure().buildSessionFactory();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sessionFactory;
	}

}
