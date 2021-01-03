package com.sparkleweb.app.helper;

import java.util.HashMap;
import java.util.Map;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Environment;

import com.sparkleweb.app.model.Cart;
import com.sparkleweb.app.model.Category;
import com.sparkleweb.app.model.Products;
import com.sparkleweb.app.model.User;

public class HibernateConfig {
	
	private static SessionFactory sessionFactory;
	
	public static SessionFactory getsessionFactory() {

				Map<String, Object> map = new HashMap<String, Object>();
				map.put(Environment.DRIVER, "com.mysql.jdbc.Driver");			
				map.put(Environment.URL, "jdbc:mysql://localhost:3306/ecommerceweb");
				map.put(Environment.USER, "root");
				map.put(Environment.PASS, "root");
				map.put(Environment.DIALECT, "org.hibernate.dialect.MySQL5Dialect");
				map.put(Environment.HBM2DDL_AUTO, "update");
				map.put(Environment.SHOW_SQL,"true");
//				map.put(Environment.USE_SECOND_LEVEL_CACHE, "true");
//				map.put(Environment.CACHE_REGION_FACTORY,"org.hibernate.cache.ehcache.EhCacheRegionFactory");
				
				
				StandardServiceRegistry registry = new StandardServiceRegistryBuilder().applySettings(map).build();
				MetadataSources mds = new MetadataSources(registry);

				mds.addAnnotatedClass(User.class).addAnnotatedClass(Products.class).addAnnotatedClass(Category.class).addAnnotatedClass(Cart.class);
				Metadata md =mds.getMetadataBuilder().build();
				sessionFactory =md.getSessionFactoryBuilder().build();		
				System.out.println("SESSIONFACTORY is " + sessionFactory);

		return sessionFactory;	
	}
}
