package com.shopingsystem.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.shopingsystem.config.HibernateConfig;
import com.shopingsystem.model.OrderDetail;

public class OrderDetailDAO {
	
	public void saveOrderDetail(OrderDetail orderDetail) {
		
		Transaction transaction=null;
		try(Session session=HibernateConfig.getSessionFactory().openSession()) {
			transaction=session.beginTransaction();
			session.save(orderDetail);
			transaction.commit();
			
		}catch(Exception e) {
			if(transaction!=null) {
				transaction.rollback();
				e.printStackTrace();
			}
		}
	}
	
	
	 public void deleteOrderDetailsByOrderId(int orderId) {
	        Transaction transaction = null;
	        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
	        	transaction = session.beginTransaction();

	            List<OrderDetail> details = session.createQuery(
	                "FROM OrderDetail od WHERE od.order.orderId = :oid",
	                OrderDetail.class
	            ).setParameter("oid", orderId)
	             .list();

	            for (OrderDetail od : details) {
	                session.delete(od);
	            }

	            transaction.commit();
	        } catch (Exception e) {
	            if (transaction != null) transaction.rollback();
	            e.printStackTrace();
	        }
	    }


	public List<OrderDetail> getOrderDetailsByOrderId(int orderId) {
		// TODO Auto-generated method stub
		return null;
	}
	}
