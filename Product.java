package com.shopingsystem.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="product")
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="product_id")
	private long productId;
	
	
	@Column(nullable = false,length = 30)
	private String name;
	
	
	@Column(nullable = false,length = 34)
	private double price;
	
	@Column(nullable = false,length = 30)
	private long stock;

	
	//@OneToMany(mappedBy = "product")
	//private List<OrderDetail> orderDetails;

	
	
	
	
	public long getProductId() {
		return productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public long getStock() {
		return stock;
	}

	public void setStock(long stock) {
		this.stock = stock;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", name=" + name + ", price=" + price + ", stock=" + stock + "]";
	}

	public Product(String name, double price, long stock) {
		super();
		this.name = name;
		this.price = price;
		this.stock = stock;
	}

	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
	
	
	

}
