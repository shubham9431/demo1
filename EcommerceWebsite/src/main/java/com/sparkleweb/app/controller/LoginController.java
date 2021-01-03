package com.sparkleweb.app.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sparkleweb.app.model.User;
import com.sparkleweb.app.serviceI.ServiceI;
import com.sparkleweb.app.serviceImpl.ServiceImpl;

@WebServlet("/login")
public class LoginController extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String userEmail = request.getParameter("userEmail");
		String userPassword = request.getParameter("userPassword");

		ServiceI serviceI = new ServiceImpl();
		
		HttpSession session = request.getSession(false);
		
		if(userEmail.equals("admin@gmail.com") && userPassword.equals("admin")) {	
			String admin = "ADMIN";
			session.setAttribute("adminValid", admin);
			request.getRequestDispatcher("administration.jsp").forward(request, response);
		}
		else {
			User user =	serviceI.checkUser(userEmail,userPassword);

			if(user != null) {
				 session.setAttribute("userValid", user); 
				 request.getRequestDispatcher("index.jsp").forward(request, response);
			}else {
				session.setAttribute("msg", "Invalid Email Address OR Password");
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}
		}



	}

}
