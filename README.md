# Online-Shopping-Managment
Online Shopping System is a Java-based backend project built using Hibernate ORM and MySQL. It demonstrates a real-world e-commerce workflow including User management, Product catalog, Order processing, Order details, and Payment handling, following layered architecture (Entity, DAO, Service).  Tech Stack: Java, Hibernate, MySQL, Maven 


# 🛒 Online Shopping System (Java + Hibernate + MySQL)

This project is a backend **Online Shopping System** developed using **Java**, **Hibernate ORM**, and **MySQL**.  
It follows a clean layered architecture with **Entity, DAO, and Service layers**.

The project demonstrates how an e-commerce system works internally, including:
- User management
- Product management
- Order placement
- Order details (multiple products per order)
- Payment handling

---

## 🚀 Technologies Used

- Java (JDK 8+)
- Hibernate ORM
- MySQL
- Maven
- JPA Annotations

---





---

## 🧩 Database Design (Entities)

### User
- user_id (PK)
- username
- password
- email
- role

### Product
- product_id (PK)
- name
- price
- stock

### Order
- order_id (PK)
- order_date
- user_id (FK)

### Order_Details
- order_detail_id (PK)
- order_id (FK)
- product_id (FK)
- quantity

### Payment
- payment_id (PK)
- order_id (FK)
- amount
- payment_method
- payment_status
- payment_date

---

## 🔗 Entity Relationships

- One User → Many Orders
- One Order → Many OrderDetails
- One Product → Many OrderDetails
- One Order → One Payment

---

## ⚙️ Features

- Place an order with multiple products
- Automatic cascading of Order & OrderDetails
- Clean separation of business logic and database logic
- Uses `long` for all primary keys (scalable design)
- Hibernate configuration without `hibernate.cfg.xml`

---

## ▶️ How to Run

1. Clone the repository
2. Create the MySQL database
3. Run the SQL queries provided below
4. Update DB credentials in `HibernateConfig.java`
5. Run `App.java`

---

## 🧠 Interview Highlights

- Demonstrates Hibernate relationships (OneToMany, ManyToOne)
- Shows cascade operations
- Uses Service + DAO pattern
- Industry-level database design

---

## 📌 Future Enhancements

- REST API using Spring Boot
- JWT authentication
- Admin panel
- Cart functionality

---

CREATE DATABASE online_shopping_db;
USE online_shopping_db;

-- USER TABLE
CREATE TABLE users (
  user_id BIGINT AUTO_INCREMENT PRIMARY KEY,
  username VARCHAR(100) NOT NULL,
  password VARCHAR(100) NOT NULL,
  email VARCHAR(100),
  role VARCHAR(50)
);

-- PRODUCT TABLE
CREATE TABLE products (
  product_id BIGINT AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(100) NOT NULL,
  price DOUBLE NOT NULL,
  stock INT NOT NULL
);

-- ORDER TABLE
CREATE TABLE orders (
  order_id BIGINT AUTO_INCREMENT PRIMARY KEY,
  order_date DATETIME NOT NULL,
  user_id BIGINT,
  FOREIGN KEY (user_id) REFERENCES users(user_id)
);

-- ORDER DETAILS TABLE
CREATE TABLE order_details (
  order_detail_id BIGINT AUTO_INCREMENT PRIMARY KEY,
  order_id BIGINT,
  product_id BIGINT,
  quantity INT NOT NULL,
  FOREIGN KEY (order_id) REFERENCES orders(order_id),
  FOREIGN KEY (product_id) REFERENCES products(product_id)
);

-- PAYMENT TABLE
CREATE TABLE payments (
  payment_id BIGINT AUTO_INCREMENT PRIMARY KEY,
  order_id BIGINT,
  amount DOUBLE NOT NULL,
  payment_method VARCHAR(50),
  payment_status VARCHAR(50),
  payment_date DATETIME,
  FOREIGN KEY (order_id) REFERENCES orders(order_id)
);



## 👨‍💻 Author

Manish  
(Java Backend Developer – Fresher Project)


## 📂 Project Structure
## OnlineShoppingSystem
│
├── src/main/java
│ └── com.shopingsystem
│ ├── app
│ │ └── App.java
│ ├── config
│ │ └── HibernateConfig.java
│ ├── dao
│ │ ├── UserDAO.java
│ │ ├── ProductDAO.java
│ │ ├── OrderDAO.java
│ │ ├── OrderDetailDAO.java
│ │ └── PaymentDAO.java
│ ├── model
│ │ ├── User.java
│ │ ├── Product.java
│ │ ├── Order.java
│ │ ├── OrderDetail.java
│ │ └── Payment.java
│ └── service
│ ├── UserService.java
│ ├── ProductService.java
│ ├── OrderService.java
│ ├── OrderDetailService.java
│ └── PaymentService.java
│
├── pom.xml
└── README.md

