package com.sparkleweb.app.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sparkleweb.app.model.Cart;
import com.sparkleweb.app.model.Products;
import com.sparkleweb.app.model.User;
import com.sparkleweb.app.serviceI.ServiceI;
import com.sparkleweb.app.serviceImpl.ServiceImpl;

@WebServlet("/addToCart")
public class AddToCart extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int id= Integer.parseInt(request.getParameter("proId"));

		ServiceI service = new ServiceImpl();
		HttpSession session = request.getSession();
		User u = (User) session.getAttribute("userValid");

		if(u!=null) {
			//		get product object by ID
			Products pro = service.getProductByID(id);
			Cart c=new Cart();

			c.setCartItemImage(pro.getProPic());
			c.setCartItemName(pro.getProName());
			c.setCartItemPrice(pro.getProPrice());
			c.setCartItemQuantity(1);
			c.setUser(u);

			service.addTocart(c);
			//		session.setAttribute("msg", "Item Successfully Added To Cart");
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}

		else {
			session.setAttribute("msg","Please Login First Then Add Product to Cart...!!!");
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
	}
}
