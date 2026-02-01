package com.shopingsystem.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.shopingsystem.config.HibernateConfig;
import com.shopingsystem.model.Product;

public class ProductDAO {
	public void saveProduct(Product product) {
		
		Transaction transaction=null;
		
		try (Session session=HibernateConfig.getSessionFactory().openSession()){
			transaction=session.beginTransaction();
			session.save(product);
			transaction.commit();
			
		}catch(Exception e) {
			if(transaction!=null) {
				transaction.rollback();
				e.printStackTrace();
			}
		}
	}
	
	
	public  Product getProductById(long productId) {
		try(Session session=HibernateConfig.getSessionFactory().openSession()){
			return session.get(Product.class,productId);	
		}
		
		
	}
	
	
	
	public List<Product> getAllProducts() {
        try (Session session =HibernateConfig.getSessionFactory().openSession()) {
            return session.createQuery("FROM Product", Product.class).list();
        }
    }
	
	public void deleteProduct(long productId) {
		Transaction transaction=null;
		try (Session session=HibernateConfig.getSessionFactory().openSession()){
			transaction=session.beginTransaction();
			Product product=session.get(Product.class, productId);
			if(product!=null) {
				session.delete(product);
			}
			
		}catch(Exception e) {
			if(transaction!=null) {
			transaction.rollback();
			e.printStackTrace();
			}
		}
	}


	public void updateProduct(Product product) {
		// TODO Auto-generated method stub
		
	}

}
