package com.sparkleweb.app.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.sparkleweb.app.model.User;
import com.sparkleweb.app.serviceI.ServiceI;
import com.sparkleweb.app.serviceImpl.ServiceImpl;

@WebServlet("/newRegister")
@MultipartConfig
public class RegistrationController extends HttpServlet{


	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		String userName =request.getParameter("userName");
		String userEmail=request.getParameter("userEmail");
		String userPassword=request.getParameter("userPassword");
		long userMobileNumber= Long.parseLong(request.getParameter("userMobileNumber"));
//		String  userPic=request.getParameter("userPic");

		Part part = request.getPart("userPic");
		
		String filePath = getServletContext().getRealPath("images") + File.separator + "users" + File.separator + part.getSubmittedFileName();
		
		FileOutputStream fos = new FileOutputStream(filePath);
		
		InputStream is = part.getInputStream();
		byte[] data = new byte[is.available()];
		
		is.read(data);
		
		fos.write(data);
		
		fos.close();
		
		User user = new User();
		user.setUserName(userName);
		user.setUserEmail(userEmail);
		user.setUserPassword(userPassword);
		user.setUserMobileNumber(userMobileNumber);
		user.setUserPic(part.getSubmittedFileName());
	
//		service Interface
		ServiceI serviceI = new ServiceImpl();
		serviceI.addNewUser(user);
		HttpSession session =request.getSession();
		session.setAttribute("msg", "You Are Successfully Registered...!!!");
		request.getRequestDispatcher("login.jsp").forward(request, response);
		
	}
}
