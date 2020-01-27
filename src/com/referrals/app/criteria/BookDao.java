package com.referrals.app.criteria;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

import com.referrals.app.HibernateFactory;

public class BookDao {

	public void createBook(Book book) {
		Session session = HibernateFactory.getAnnotationsFactory().openSession();
		Transaction transaction = session.beginTransaction();

		try {
			session.save(book);
			transaction.commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public void fetchBooks(String string) {
		Session session = HibernateFactory.getAnnotationsFactory().openSession();
		Transaction transaction = session.beginTransaction();

		try {
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<Book> criteriaQuery = builder.createQuery(Book.class);

			Root<Book> root = criteriaQuery.from(Book.class);
			criteriaQuery.select(root).where(builder.gt(root.get("id"), 1));

			Query<Book> query = session.createQuery(criteriaQuery);
			List<Book> books = query.list();

			for (Book book : books) {
				System.out.println(book.toString());
			}

			session.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void fetchBooksUsingQuery(String string) {
		Session session = HibernateFactory.getAnnotationsFactory().openSession();
		Transaction transaction = session.beginTransaction();

		try {
			@SuppressWarnings("unchecked")
			NativeQuery<Object[]> nativeQuery = session
					.createSQLQuery("select * from book where author='" + string + "'");
			List<Object[]> bookObjects = nativeQuery.list();

			for (Object[] columns : bookObjects) {
				Book book = new Book((String)columns[1], (String)columns[2]);
				book.setId(Integer.parseInt(String.valueOf(columns[0])));
				System.out.println(book.toString());
			}

			session.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
