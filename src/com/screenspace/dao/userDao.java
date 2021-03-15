package com.screenspace.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import com.screenspace.model.userModel;

public class userDao {
	
	
	public static void setUser(String uname, String pass, String phone, String email) {
		
		userModel user = new userModel(uname, pass,phone,email);
		
		SessionFactory sf = factoryProvider.availableFactory();
		
		Session session = sf.openSession();
		
		Transaction tx = session.beginTransaction();
		
		session.save(user);
		
		tx.commit();
		
	}


	
	
	

}
