package com.shopingsystem.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="order_details")
public class OrderDetail {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="order_details")
	private long orderDetails;
	
	
	@ManyToOne
	@JoinColumn(name="order_id",nullable = false)
	private Order order;
	
	@ManyToOne
	@JoinColumn(name="product_id",nullable = false)
	private Product product;
	
	@Column(nullable = false)
	private long quantity;

	public long getOrderDetails() {
		return orderDetails;
	}

	public void setOrderDetails(long orderDetails) {
		this.orderDetails = orderDetails;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public long getQuantity() {
		return quantity;
	}

	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}

	public OrderDetail(Order order, Product product, long quantity) {
		super();
		this.order = order;
		this.product = product;
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "OrderDetail [orderDetails=" + orderDetails + ", order=" + order + ", product=" + product + ", quantity="
				+ quantity + "]";
	}

	public OrderDetail() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
}
