package com.shopingsystem.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.shopingsystem.config.HibernateConfig;
import com.shopingsystem.model.Payment;

public class PaymentDAO {
	
	public void savePayment(Payment payment) {
		Transaction transaction=null;
		try (Session session=HibernateConfig.getSessionFactory().openSession()){
			transaction=session.beginTransaction();
			session.save(payment);
			
		}catch(Exception e) {
			if(transaction!=null) {
				transaction.rollback();
				e.printStackTrace();
		
		  }
	   }
	}
	
	   public Payment getPaymentByOrderId(int orderId) {
	        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
	            return session.createQuery(
	                "FROM Payment p WHERE p.order.orderId = :oid",
	                Payment.class
	            ).setParameter("oid", orderId)
	             .uniqueResult();
	        }
	    }
	}

