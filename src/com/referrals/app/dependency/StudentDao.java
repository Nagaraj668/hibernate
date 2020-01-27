package com.referrals.app.dependency;

import java.util.ArrayList;
import java.util.Collection;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class StudentDao {

	public static void main(String[] args) {
		
		try {
			SessionFactory factory = new Configuration().configure().buildSessionFactory();
			Session session = factory.openSession();
			Transaction transaction = session.beginTransaction();
			
			Book book = new Book(1, "C");
			Book book1 = new Book(2, "C++");
			Book book2 = new Book(3, "Java");
			
			Collection<Book> books = new ArrayList<Book>();
			books.add(book);
			books.add(book1);
			books.add(book2);
			
			Student student = new Student(1, "Nagaraj", books);
			
			session.save(student);
			transaction.commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
