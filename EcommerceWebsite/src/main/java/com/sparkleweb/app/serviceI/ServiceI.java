package com.sparkleweb.app.serviceI;

import java.util.List;

import com.sparkleweb.app.model.Cart;
import com.sparkleweb.app.model.Category;
import com.sparkleweb.app.model.Products;
import com.sparkleweb.app.model.User;

public interface ServiceI {

	void addNewUser(User user);

	User checkUser(String userEmail, String userPassword);

	void addCategory(Category cat);

	Category getCategoryById(int category);

	void addProduct(Products pro);

	void addTocart(Cart c);

	void forgetPass(String email, String pass);

	Products getProductByID(int id);
	
	List<Cart> getAllDataFromCart(int id);
	
	
}
