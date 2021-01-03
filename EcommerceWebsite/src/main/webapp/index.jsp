<%@page import="com.sparkleweb.app.model.Products"%>
<%@page import="java.util.List"%>
<%@page import="com.sparkleweb.app.daoImpl.DaoImpl"%>
<%@page import="com.sparkleweb.app.daoI.DaoI"%>
<%@page import="com.sparkleweb.app.helper.HibernateConfig"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>SparkleWeb - Home</title>
<style>
body {
	background-image: url('images/background/index.jpg');
	background-repeat: no-repeat;
	background-attachment: fixed;
	background-size: cover;
}
</style>
</head>
<body>

	<%@include file="common/navbar.jsp"%>

	<div class="container">
		<div>
			<%
				String message = (String) session.getAttribute("msg");
			if (message != null) {
			%>
			<div class="alert alert-warning alert-dismissible fade show"
				role="alert">
				<strong> <%
 	out.print(message);
 %>
				</strong>
				<button type="button" class="close" data-dismiss="alert"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<%
				}
			session.removeAttribute("msg");
			%>
		</div>
		<div class="row mt-5">
			<!-- Category wise DATA(Products) rendering -->
			<%
				DaoI daoI = new DaoImpl();
			String catID = request.getParameter("catId");
			List<Products> list = null;

			if (catID != null) {
				int i = Integer.parseInt(catID);
				list = daoI.allProductbyCategoryID(i);
			} else {
				list = daoI.allProductList();
			}

			for (Products pro : list) {
			%>
			<div class="col-4">
				<div class="card mb-3">
					<img class="card-img-top"
						src="images/products/<%=pro.getProPic()%>"
						alt="<%=pro.getProPic()%>">
					<div class="card-body">
						<h5 class="card-title"><%=pro.getProName()%></h5>
						<p class="card-text"><%=pro.getProDiscription()%></p>
						<br>
						<p class="card-text">
							<strong>&#8377; <%=pro.getProPrice()%></strong>
						</p>
						<a href="addToCart?proId=<%=pro.getProId()%>"
							class="btn btn-primary">Add To Cart</a>
					</div>
				</div>
			</div>

			<%
				}
			%>
		</div>
	</div>

</body>
</html>