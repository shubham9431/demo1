package com.sparkleweb.app.daoI;

import java.util.List;

import com.sparkleweb.app.model.Cart;
import com.sparkleweb.app.model.Category;
import com.sparkleweb.app.model.Products;
import com.sparkleweb.app.model.User;

public interface DaoI {

	void addNewUser(User user);

	User checkUser(String userEmail, String userPassword);

	void addCategory(Category cat);

	List<Category> dropdownCategory();

	Long  countTotalUsers();
	//	long totalProducts();
	Long countTotalProducts();

	Long  countTotalCategory();

	Category getCategoryById(int category);

	void addProduct(Products pro);

	List<Products> allProductList();

	List<Products> allProductbyCategoryID(int id);

	void addToCart(Cart c);

	void forgetPass(String email, String pass);

	Products getProductByID(int id);

	List<Cart> getAllDataFromCart(int id);
}
