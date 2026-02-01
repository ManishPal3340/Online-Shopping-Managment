package com.shopingsystem.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.shopingsystem.config.HibernateConfig;
import com.shopingsystem.model.Order;

public class OrderDAO {

    // CREATE
    public void createOrder(Order order) {
        Transaction transaction = null;
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {

            transaction = session.beginTransaction();
            session.save(order); // Order + OrderDetails (Cascade)
            transaction.commit();

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    // READ by ID
    public Order getOrderById(long orderId) {
        Order order = null;
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            order = session.get(Order.class, orderId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return order;
    }

    // READ by User ID
    public List<Order> getOrdersByUserId(long userId) {
        List<Order> orders = null;

        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            orders = session.createQuery(
                "FROM Order o WHERE o.user.userId = :userId",
                Order.class
            ).setParameter("userId", userId)
             .list();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return orders;
    }

    // UPDATE
    public void updateOrder(Order order) {
        Transaction transaction = null;
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {

            transaction = session.beginTransaction();
            session.update(order);
            transaction.commit();

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    // DELETE
    public void deleteOrder(long orderId) {
        Transaction transaction = null;
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {

            transaction = session.beginTransaction();
            Order order = session.get(Order.class, orderId);

            if (order != null) {
                session.delete(order);
            }

            transaction.commit(); // ✅ correct place

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
}
