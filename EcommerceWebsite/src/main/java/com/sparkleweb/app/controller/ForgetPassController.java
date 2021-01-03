package com.sparkleweb.app.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sparkleweb.app.serviceI.ServiceI;
import com.sparkleweb.app.serviceImpl.ServiceImpl;

@WebServlet("/forgetPass")
public class ForgetPassController extends HttpServlet  {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub


		String email = request.getParameter("userEmail");
		String pass = request.getParameter("userPassword");
		String passConfirm = request.getParameter("userPassword1");

		ServiceI service = new ServiceImpl();
		HttpSession session = request.getSession();

		if(pass.equals(passConfirm)) {

			service.forgetPass(email, pass);
			session.setAttribute("msg", "Password Successfully Changed..!!!");
			request.getRequestDispatcher("login.jsp").forward(request, response);

		}else {
			session.setAttribute("msg", "Both Passwords Must Be SAME... Please Try Again!!! ");
			request.getRequestDispatcher("forgetPass.jsp").forward(request, response);
		}

	}
}
