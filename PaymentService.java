package com.shopingsystem.service;


import com.shopingsystem.dao.PaymentDAO;
import com.shopingsystem.model.Order;
import com.shopingsystem.model.Payment;

import java.util.Date;

public class PaymentService {

    private PaymentDAO paymentDAO = new PaymentDAO();

    public void makePayment(Order order, double amount, String method) {

        Payment payment = new Payment();
        payment.setOrder(order);
        payment.setAmount(amount);
        payment.setPaymentMethod(method);
        payment.setPaymentStatus("SUCCESS");
        payment.setPaymentDate(new Date());

        paymentDAO.savePayment(payment);
    }
}
