package com.shopingsystem.service;

import java.util.Date;
import java.util.List;

import com.shopingsystem.dao.OrderDAO;
import com.shopingsystem.model.Order;
import com.shopingsystem.model.OrderDetail;
import com.shopingsystem.model.User;

public class OrderService {

    private OrderDAO orderDao = new OrderDAO();

    public Order placeOrder(User user, List<OrderDetail> orderDetails) {

        Order order = new Order();
        order.setUser(user);
        order.setOrderDate(new Date());
        order.setOrderDetails(orderDetails); // ✅ FIXED

        for (OrderDetail od : orderDetails) {
            od.setOrder(order);
        }

        orderDao.createOrder(order); // ✅ FIXED
        return order;
    }

    public Order getOrderById(long orderId) {
        return orderDao.getOrderById(orderId);
    }
}
