package com.referrals.app.mkyong;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.referrals.app.HibernateFactory;

public class AppTest {

	public static void main(String[] args) {

		AppTest appTest = new AppTest();
		appTest.test();
	}

	private void test() {
		Session session = HibernateFactory.getAnnotationsFactory().openSession();
		Transaction transaction = session.beginTransaction();
		
		try {
			Stock stock = new Stock();
		    stock.setStockCode("705");
		    stock.setStockName("PAD");
		 
		    Category category1 = new Category("cons", "COMPANY");
		    Category category2 = new Category("cons1", "COMPANY");
		    Category category3 = new Category("cons2", "COMPANY");
		    //new category, need save to get the id first
		    session.save(category1);
		    session.save(category2);
		    session.save(category3);
		    
		    StockCategory stockCategory = new StockCategory();
		    stockCategory.setStock(stock);
		    stockCategory.setCategory(category1);
		    stockCategory.setCreatedDate(new Date()); //extra column
		    stockCategory.setCreatedBy("system"); //extra column

		    StockCategory stockCategory1 = new StockCategory();
		    stockCategory1.setStock(stock);
		    stockCategory1.setCategory(category2);
		    stockCategory1.setCreatedDate(new Date()); //extra column
		    stockCategory1.setCreatedBy("system"); //extra column

		    
		    StockCategory stockCategory2 = new StockCategory();
		    stockCategory2.setStock(stock);
		    stockCategory2.setCategory(category3);
		    stockCategory2.setCreatedDate(new Date()); //extra column
		    stockCategory2.setCreatedBy("system"); //extra column

		    stock.getStockCategories().add(stockCategory);
		    stock.getStockCategories().add(stockCategory1);
		    stock.getStockCategories().add(stockCategory2);
		        
		    session.save(stock);
		 
		    transaction.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
