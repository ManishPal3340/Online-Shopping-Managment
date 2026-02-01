package com.shopingsystem.config;

import java.util.Properties; 

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import com.shopingsystem.model.Product;

public class HibernateConfig {
	
	private static SessionFactory sessionFactory;
	public static SessionFactory getSessionFactory() {
		if(sessionFactory==null) {
			try {
				Configuration configuration=new Configuration();// create a object in configration
				Properties  setting= new Properties();// create object in properties
				
				setting.put(Environment.DRIVER,"com.mysql.cj.jdbc.Driver");
				setting.put(Environment.URL,"jdbc:mysql://localhost:3306/shoppingSystemBD");
				setting.put(Environment.USER,"root");
				setting.put(Environment.PASS,"root");
				setting.put(Environment.DIALECT,"org.hibernate.dialect.Mysql8Dialect");
				setting.put(Environment.SHOW_SQL,"true");
				setting.put(Environment.HBM2DDL_AUTO,"update");
				setting.put(Environment.CURRENT_SESSION_CONTEXT_CLASS,"thread");
				//setting.put(Environment.HBM2DDL_AUTO, "create-drop");

				configuration.setProperties(setting);
				configuration.addAnnotatedClass(Product.class);
				ServiceRegistry serviceRegistry = new  StandardServiceRegistryBuilder()
						.applySettings(configuration.getProperties()).build();
				
				sessionFactory = configuration.buildSessionFactory(serviceRegistry);

				
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return sessionFactory;
		
	}

}
