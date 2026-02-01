package com.shopingsystem.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import com.shopingsystem.config.HibernateConfig;
import com.shopingsystem.model.User;
import org.hibernate.query.Query;
public class UserDAO {
	public void saveUser(User user) {
		 Transaction transaction=null;
		 
		 try(Session session=HibernateConfig.getSessionFactory().openSession()) {
			 transaction=session.beginTransaction();
			 session.save(user);
			 transaction.commit();
			 
		 }catch(Exception e) {
			 if(transaction!=null) {
				 transaction.rollback();
			 }
			 
		 }
	}
	
	public User getUserById(long userId) {
		
		
		try (Session session=HibernateConfig.getSessionFactory().openSession()){
			return session.get(User.class, userId);
		}
	}
	
	public User getUserByUsername(String username) {
		
		try (Session session=HibernateConfig.getSessionFactory().openSession()){
			Query<User>query=session.createQuery("FROM User u WHERE u.username = :uname",User.class);
			
			query.setParameter("uname", username);
			
			 return query.uniqueResult();
		}
	}
	
	
	
	// Get All Users (Admin)
    public List<User> getAllUsers() {
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            return session.createQuery("FROM User", User.class).list();
        }
    }

    // Update User
    public void updateUser(User user) {
        Transaction transaction = null;
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
        	transaction = session.beginTransaction();
            session.update(user);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }

    // Delete User
    public void deleteUser(int userId) {
        Transaction transaction = null;
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
        	transaction = session.beginTransaction();
            User user = session.get(User.class, userId);
            if (user != null) {
                session.delete(user);
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }
}