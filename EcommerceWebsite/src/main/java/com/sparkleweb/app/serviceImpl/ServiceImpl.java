package com.sparkleweb.app.serviceImpl;

import java.util.List;

import com.sparkleweb.app.daoI.DaoI;
import com.sparkleweb.app.daoImpl.DaoImpl;
import com.sparkleweb.app.model.Cart;
import com.sparkleweb.app.model.Category;
import com.sparkleweb.app.model.Products;
import com.sparkleweb.app.model.User;
import com.sparkleweb.app.serviceI.ServiceI;

public class ServiceImpl implements ServiceI {
	DaoI daoI =new DaoImpl();

	public void addNewUser(User user) {
		// TODO Auto-generated method stub
		daoI.addNewUser(user);
	}

	public User checkUser(String userEmail, String userPassword) {
		// TODO Auto-generated method stub
		return daoI.checkUser(userEmail, userPassword);
	}

	public void addCategory(Category cat) {
		// TODO Auto-generated method stub
		daoI.addCategory(cat);
	}

	public Category getCategoryById(int category) {
		// TODO Auto-generated method stub
		return daoI.getCategoryById(category);
	}

	public void addProduct(Products pro) {
		// TODO Auto-generated method stub
		daoI.addProduct(pro);
	}

	public void addTocart(Cart c) {
		// TODO Auto-generated method stub
		daoI.addToCart(c);
	}

	public void forgetPass(String email, String pass) {
		// TODO Auto-generated method stub
		daoI.forgetPass(email, pass);
	}

	public Products getProductByID(int id) {
		// TODO Auto-generated method stub
		return daoI.getProductByID(id);
	}

	public List<Cart> getAllDataFromCart(int id) {
		// TODO Auto-generated method stub
		return daoI.getAllDataFromCart(id);
	}

}