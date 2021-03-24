package com.screenspace.dao;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import com.screenspace.model.imageModel;
import com.screenspace.model.userModel;

public class factoryProvider {
	
	public static SessionFactory availableFactory() {
		
		
		Configuration con = new Configuration().addPackage("com.screenspace.model").addAnnotatedClass(userModel.class).addAnnotatedClass(imageModel.class).configure();
		
		ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
		
		SessionFactory sf = con.buildSessionFactory(reg);
		
		
		return sf;
		
		
	}

}
