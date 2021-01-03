package com.sparkleweb.app.helper;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import org.terracotta.modules.ehcache.store.nonstop.NoOpOnTimeoutStore;

import com.sparkleweb.app.model.User;
//@WebFilter("/login")
public class AuthoFilter implements Filter {

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
//
//		HttpServletRequest req= (HttpServletRequest)request;
//		
//		HttpSession session =req.getSession();
//		
//		User user = (User)session.getAttribute("userValid");
//		String admin = (String)session.getAttribute("adminValid");
//		PrintWriter out=response.getWriter();
//		if(user!=null) {
//		chain.doFilter(request, response);	
//		}
//		else if(admin!=null) {
//			chain.doFilter(request, response);	
//		}
//		else {
//		session.setAttribute("msg", "You Are Not Authorized User...!!! Please LOGIN...!!!");
//			request.getRequestDispatcher("login.jsp").forward(request, response);
//		}
	}
}
