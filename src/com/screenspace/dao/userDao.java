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
	
		public static userModel getUser(String uname, String pass) {
		
		userModel user = new userModel();
			
		SessionFactory sf = factoryProvider.availableFactory();
		
		Session session = sf.openSession();
		
		Transaction tx = session.beginTransaction();
		
		user = (userModel)session.get(userModel.class, uname);
		
		tx.commit();
		
		session.close();
		
		return user;
		
	}


	
	
	

}
