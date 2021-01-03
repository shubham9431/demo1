package com.sparkleweb.app.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sparkleweb.app.model.User;
@WebServlet("/logout")
public class LogoutController extends HttpServlet {


	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub

		HttpSession session = req.getSession(false);
		session.invalidate();

		//		String adm = (String) session.getAttribute("");
		//		User user = (User) req.getAttribute("");
		//		if(adm!=null) {
		//			
		//		}else if(user!=null) {
		//
		//		}
		
		req.getRequestDispatcher("index.jsp").forward(req, resp);

	}

}
