package com.shopingsystem;
//package com.onlineshop;

import com.shopingsystem.model.*;
import com.shopingsystem.service.*;

import java.util.ArrayList;
import java.util.List;

public class App {

    public static void main(String[] args) {

        // Services
        UserService userService = new UserService();
        ProductService productService = new ProductService();
        OrderService orderService = new OrderService();
        PaymentService paymentService = new PaymentService();

        // 1️⃣ Create User
        User user = new User();
        user.setUsername("manish");
        user.setPassword("12345");
        user.setEmail("manish@gmail.com");
        user.setRole("CUSTOMER");

        userService.registerUser(user);

        // 2️⃣ Create Products
        Product p1 = new Product();
        p1.setName("Laptop");
        p1.setPrice(50000);
        p1.setStock(10);

        Product p2 = new Product();
        p2.setName("Mouse");
        p2.setPrice(500);
        p2.setStock(50);

        productService.addProduct(p1);
        productService.addProduct(p2);

        // 3️⃣ Create OrderDetails
        OrderDetail od1 = new OrderDetail();
        od1.setProduct(p1);
        od1.setQuantity(1);

        OrderDetail od2 = new OrderDetail();
        od2.setProduct(p2);
        od2.setQuantity(2);

        List<OrderDetail> orderDetails = new ArrayList<>();
        orderDetails.add(od1);
        orderDetails.add(od2);

        // 4️⃣ Place Order
        Order order = orderService.placeOrder(user, orderDetails);

        // 5️⃣ Calculate total amount
        double totalAmount =
                (p1.getPrice() * od1.getQuantity()) +
                (p2.getPrice() * od2.getQuantity());

        // 6️⃣ Make Payment
        paymentService.makePayment(order, totalAmount, "UPI");

        System.out.println("✅ Order placed successfully!");
        System.out.println("🧾 Order ID: " + order.getOrderId());
        System.out.println("💰 Total Amount: " + totalAmount);
    }
}
