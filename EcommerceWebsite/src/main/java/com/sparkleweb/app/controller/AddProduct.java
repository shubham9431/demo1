package com.sparkleweb.app.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.persistence.ManyToOne;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.sparkleweb.app.model.Category;
import com.sparkleweb.app.model.Products;
import com.sparkleweb.app.serviceI.ServiceI;
import com.sparkleweb.app.serviceImpl.ServiceImpl;

@WebServlet("/addProduct")
@MultipartConfig
public class AddProduct extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String proNumber = request.getParameter("proNumber");
		String proName = request.getParameter("proName");
		String proDiscription = request.getParameter("proDiscription");
		int proPrice = Integer.parseInt(request.getParameter("proPrice"));
		int proQuantity = Integer.parseInt(request.getParameter("proQuantity"));
		int category =Integer.parseInt( request.getParameter("category"));

		//		Image upload
		Part part = request.getPart("proPic");
		//		set Path to upload
		String filePath = getServletContext().getRealPath("images") + File.separator + "products" + File.separator + part.getSubmittedFileName();
		System.out.println(filePath);
		//		Upload image code
		//		
		FileOutputStream fos = new FileOutputStream(filePath);
		//		
		InputStream is = part.getInputStream();
		
		//		read Data
		byte[] data = new byte[is.available()];
		is.read(data);
		
		//		Writing data
		fos.write(data);

		fos.close();

		Products pro = new Products();
		pro.setProNumber(proNumber);
		pro.setProName(proName);
		pro.setProDiscription(proDiscription);
		pro.setProPrice(proPrice);
		pro.setProQuantity(proQuantity);

		pro.setProPic(part.getSubmittedFileName());

		ServiceI serviceI = new ServiceImpl();
		Category cat = serviceI.getCategoryById(category);

		pro.setCategory(cat);


		serviceI.addProduct(pro);

		request.getRequestDispatcher("administration.jsp").forward(request, response);
	}
}
