package com.shopingsystem.service;
//package com.onlineshop.service;
import com.shopingsystem.dao.OrderDetailDAO;
///import com.shopingsystem.dao.OrderDetailsDAO;
import com.shopingsystem.model.OrderDetail;

import java.util.List;

public class OrderDetailService {

    private OrderDetailDAO orderDetailsDAO = new OrderDetailDAO();

    public void saveOrderDetails(List<OrderDetail> orderDetails) {
        for (OrderDetail od : orderDetails) {
            orderDetailsDAO.saveOrderDetail(od);
        }
    }

    public List<OrderDetail> getOrderDetailsByOrderId(int orderId) {
        return orderDetailsDAO.getOrderDetailsByOrderId(orderId);
    }
}
