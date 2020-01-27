
package com.referrals.app.criteria;

public class CriteriaApp {

	public static void main(String[] args) {
		BookDao bookDao = new BookDao();
		// bookDao.createBook(new Book("Java", "Kaneethkar"));
	
		bookDao.fetchBooks("Yashwnth");
		bookDao.fetchBooksUsingQuery("Yashwnth");
	}
}
