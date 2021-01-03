<%@page import="com.sparkleweb.app.serviceImpl.ServiceImpl"%>
<%@page import="com.sparkleweb.app.serviceI.ServiceI"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>SparklWeb - Cart</title>
<style>
body {
	background-image: url('images/background/cart.jpg');
	background-repeat: no-repeat;
	background-attachment: fixed;
	background-size: cover;
}
</style>
</head>
<body>
	<%@include file="common/navbar.jsp"%>
	<div class="container">

		<%
		ServiceI serv = new ServiceImpl();
		User u =(User) session.getAttribute("userValid");
		List list = serv.getAllDataFromCart(u.getUserId());
		
		%>

		<div class="row mt-5">
			<div class="text-center">
				<h5>Cart</h5>
				<div class="row">
					<div class="col-3 text-center">
						<img src="/images/products/<%=%>" class="rounded" alt="...">
					</div>
					<div class="col-6">
						<p>
							<strong>Item Title</strong>
						</p>
						<p>Item description</p>
					</div>
					<div class="col-3 text-center">
						<p>
							<strong>12345</strong>
						</p>
					</div>
				</div>
				<div class="row">
					<div class="col-5">
						<button onclick="minusItem()">-</button>
						<input type="number" name="itemQuantity">
						<button onclick="plusItem()">+</button>
					</div>
					<div class="col-3">
						<a href=""><button>Remove Item</button></a>
					</div>
				</div>
			</div>

		</div>


	</div>

</body>
</html>