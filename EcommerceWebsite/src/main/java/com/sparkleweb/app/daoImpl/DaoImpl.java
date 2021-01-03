package com.sparkleweb.app.daoImpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.sparkleweb.app.daoI.DaoI;
import com.sparkleweb.app.helper.HibernateConfig;
import com.sparkleweb.app.model.Cart;
import com.sparkleweb.app.model.Category;
import com.sparkleweb.app.model.Products;
import com.sparkleweb.app.model.User;

public class DaoImpl implements DaoI {


	//	Add new User To DataBase
	public void addNewUser(User user) {

		Session session = HibernateConfig.getsessionFactory().openSession();
		session.save(user);
		session.beginTransaction().commit();
	}
	// check user is valid or not
	public User checkUser(String userEmail, String userPassword) {

		Session session = HibernateConfig.getsessionFactory().openSession();

		Query<User> query = session.createNamedQuery("checkUser", User.class);
		query.setParameter("ue", userEmail);
		query.setParameter("up", userPassword);
		User user=null;
		try {
			user = query.getSingleResult();
		}catch(Exception e) {

		}
		if(user==null) {
			return null;
		} 
		return user;
	}
	// Add Category
	public void addCategory(Category cat) {

		Session session = HibernateConfig.getsessionFactory().openSession();
		session.save(cat);
		session.beginTransaction().commit();

	}

	//	 dynamic dropdown for category in product form and navBar
	public List<Category> dropdownCategory() {

		Session session = HibernateConfig.getsessionFactory().openSession();
		Query<Category> query = session.createNamedQuery("dropdownCategory", Category.class);
		List<Category> list = query.getResultList();
		return list;
	}

	//	count Total users in database
	@SuppressWarnings("unchecked")
	public Long countTotalUsers() {

		Session session = HibernateConfig.getsessionFactory().openSession();
		Query<Long> query = session.createQuery("select count(*) from User");

		long i= query.getSingleResult().longValue();
		return i;
	}

	//	count Total Products in database
	@SuppressWarnings("unchecked")
	public Long countTotalProducts() {
		Session session = HibernateConfig.getsessionFactory().openSession();
		Query<Long> query = session.createQuery("select count(*) from Products");

		long i = query.getSingleResult().longValue();
		return i;
	}

	//	count Total categories in database 
	@SuppressWarnings("unchecked")
	public Long countTotalCategory(){

		Session session = HibernateConfig.getsessionFactory().openSession();
		Query<Long> query = session.createQuery("select count(*) from Category");

		long i= query.getSingleResult().longValue();
		return i;
	}

	//	Retrieve category object for product form
	public Category getCategoryById(int category) {

		Session session = HibernateConfig.getsessionFactory().openSession();
		Category cat = session.get(Category.class, category);

		return cat;
	}

	//	Add Product to database
	public void addProduct(Products pro) {

		Session session = HibernateConfig.getsessionFactory().openSession();
		session.save(pro);
		session.beginTransaction().commit();
	}

	//	retrieve all products
	public List<Products> allProductList() {

		Session session = HibernateConfig.getsessionFactory().openSession();
		Query<Products> query = session.createNamedQuery("totalProducts", Products.class);

		List<Products> list = query.getResultList();

		return list;
	}

	//	retrieve all products by Category wise
	public List<Products> allProductbyCategoryID(int id) {
		Session session = HibernateConfig.getsessionFactory().openSession();
		Query<Products> query = session.createNamedQuery("totalProductsByCatID", Products.class);
		query.setParameter("id", id);
		List<Products> list = query.getResultList();

		return list;
	}

	//	Forget password and update new password
	public void forgetPass(String email, String pass) {
		// TODO Auto-generated method stub
		Session session = HibernateConfig.getsessionFactory().openSession();
		Query<User> query = session.createNamedQuery("forgetPass");
		query.setParameter("pass", pass);
		query.setParameter("email", email);
		Transaction tx = session.beginTransaction();
		query.executeUpdate();
		tx.commit();
	}

	//	get product object by id 
	public Products getProductByID(int id) {
		// TODO Auto-generated method stub
		Session session = HibernateConfig.getsessionFactory().openSession();
		Products pro = session.get(Products.class, id);
		return pro;
	}

	//	add product to cart to their respective User 
	public void addToCart(Cart c) {
		// TODO Auto-generated method stub
		Session session = HibernateConfig.getsessionFactory().openSession();

		session.save(c);
		session.beginTransaction().commit();
	}
	public List<Cart> getAllDataFromCart(int id) {
		// TODO Auto-generated method stub
		Session session = HibernateConfig.getsessionFactory().openSession();
//		Query<Cart> query = session.createNamedQuery("getCartData", Cart.class);
//		query.setParameter("id", id);
//		List<Cart> list = query.getResultList();
		List<Cart> list = new ArrayList<Cart>();
		return list;
	}





}
