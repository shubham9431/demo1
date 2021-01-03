package com.sparkleweb.app.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sparkleweb.app.model.Category;
import com.sparkleweb.app.serviceI.ServiceI;
import com.sparkleweb.app.serviceImpl.ServiceImpl;

@WebServlet("/addCategory")
public class AddCategory extends HttpServlet{

	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String catName =request.getParameter("catName");
		String catDescription = request.getParameter("catDescription");
		
		ServiceI serviceI = new ServiceImpl();
		Category cat = new Category();
		cat.setCatName(catName);
		cat.setCatDescription(catDescription);
		
		serviceI.addCategory(cat);
		
		request.getRequestDispatcher("administration.jsp").forward(request, response);
		
	}
}
