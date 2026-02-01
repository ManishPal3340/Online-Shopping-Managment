package com.shopingsystem.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="users")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="user_id",length = 30)
	private long userId;
	
	@Column(nullable=false,unique=true ,length = 30)
	private String username;
	
	
	@Column(nullable=false,length = 30)
	private String password;
	
	@Column(nullable=false,unique=true,length = 30)
	private String email;
	
	@Column(nullable = false)
	private String role;

	
	//@OneToMany(mappedBy = "user")
	//private List<Order> orders;

	
	// now create a getter/ setter
	
	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	
	// now create a to stering
	@Override
	public String toString() {
		return "User [userId=" + userId + ", username=" + username + ", password=" + password + ", email=" + email
				+ ", role=" + role + "]";
	}

	
	/// now to create a generate contructor using fild
	public User(String username, String password, String email, String role) {
		super();
		this.username = username;
		this.password = password;
		this.email = email;
		this.role = role;
	}

    //	 now generate contructor in fild class
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	
	
	
}
