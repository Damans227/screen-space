package com.screenspace.dao;

import java.io.InputStream;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.screenspace.model.imageModel;

public class imageDao {

	public static void uploadImage(byte[] imageBytes, String uname, long size, String contentType, String name) {

		imageModel image = new imageModel(imageBytes, uname, size, contentType, name);

		SessionFactory sf = factoryProvider.availableFactory();

		Session session = sf.openSession();

		Transaction tx = session.beginTransaction();

		session.save(image);

		tx.commit();

		System.out.println("image upload successful");

	}

	public static List<imageModel> listImages(String uname) {

		String hql = "from imageModel where uname= :uname";

		SessionFactory sf = factoryProvider.availableFactory();

		Session session = sf.openSession();

		Query query = session.createQuery(hql);
		query.setParameter("uname", uname);

		List<imageModel> listImages = query.list();

		return listImages;
	}

	public static void deleteImages(String uname) {

		String hql = "delete from imageModel where uname = :uname";

		SessionFactory sf = factoryProvider.availableFactory();

		Session session = sf.openSession();

		Transaction tx = session.beginTransaction();
		Query query = session.createQuery(hql);
		query.setParameter("uname", uname);

		query.executeUpdate();

		tx.commit();

	}

}
