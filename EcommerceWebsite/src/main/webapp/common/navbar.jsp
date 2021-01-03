<%@page import="com.sparkleweb.app.model.User"%>
<%@page import="com.sparkleweb.app.daoImpl.DaoImpl"%>
<%@page import="com.sparkleweb.app.daoI.DaoI"%>
<%@page import="com.sparkleweb.app.model.Category"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>SparkleWeb - Navbar</title>
<%@include file="bootstrap_js_css.jsp"%>
</head>
<body>
<%
request.getSession();
%>
	<nav class="navbar navbar-expand-lg navbar-dark bg-primary">

		<div class="container">
			<a class="navbar-brand" href="index.jsp">SparkleWeb</a>
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>

			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav mr-auto">
					<li class="nav-item active"><a class="nav-link"
						href="index.jsp">Home</a></li>


					<li class="nav-item dropdown active"><a
						class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
						role="button" data-toggle="dropdown" aria-haspopup="true"
						aria-expanded="false"> Category </a>
						<div class="dropdown-menu" aria-labelledby="navbarDropdown">
							<%
								DaoI daoi = new DaoImpl();
							List<Category> list1 = daoi.dropdownCategory();
							for (Category cat1 : list1) {
							%>
							<a class="dropdown-item"
								href="index.jsp?catId=<%=cat1.getCatId()%>"><%=cat1.getCatName()%></a>
							<%
								}
							%>
						</div></li>

				</ul>
				<form class="form-inline my-2 my-lg-0">
					<input class="form-control mr-sm-2" type="search"
						placeholder="Search" aria-label="Search">
					<button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
				</form>
				<%
					String adm = (String) session.getAttribute("adminValid");
				User us = (User) session.getAttribute("userValid");
				%>
				<ul class="navbar-nav ml-auto">
					<%
						if (adm != null) {
					%>
					<li class="navbar-text text-warning"><strong>Welcome
							<%
						out.print(adm);
					%>
					</strong></li>
					<li class="nav-item active"><a class="nav-link" href="logout">Logout</a></li>
					<li class="nav-item active"><a class="nav-link"
						href="administration.jsp">Admin Page</a></li>
					<%
						} else if (us != null) {
					%>
					<li class="navbar-text text-warning"><strong>Welcome
							<%
						out.print(us.getUserName());
					%>
					</strong></li>
					<li class="nav-item active"><a class="nav-link" href="logout">Logout</a></li>
					<li class="nav-item active"><a class="nav-link"
						href="cart.jsp">Cart</a></li>
					<%
						} else {
					%>
					<li class="nav-item active"><a class="nav-link"
						href="login.jsp">Login</a></li>
					<li class="nav-item active"><a class="nav-link"
						href="register.jsp">Register</a></li>
					<li class="nav-item active"><a class="nav-link"
						href="cart.jsp">Cart</a></li>
					<%
						}
					%>
				</ul>
			</div>
		</div>
	</nav>

</body>
</html>