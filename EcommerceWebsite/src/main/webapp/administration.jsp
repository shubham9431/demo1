<%@page import="com.sparkleweb.app.model.Category"%>
<%@page import="java.util.List"%>
<%@page import="com.sparkleweb.app.daoImpl.DaoImpl"%>
<%@page import="com.sparkleweb.app.daoI.DaoI"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>


<%
	String admin = (String) session.getAttribute("adminValid");

if (admin == null) {
	out.println("<div  style='text-align: center; padding-top: 50px;'>");
	out.println("<h3>You Are Not The ADMIN... You Can not ACCESS this Page...!!!</h3><br>");
	out.println("<a href='login.jsp'>Click Here</a>");

	out.println("</div>");

	return;
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>SparkleWeb - Administration</title>
<style>
body {
	background-image: url('images/background/administration.jpg');
	background-repeat: no-repeat;
	background-attachment: fixed;
	background-size: cover;
}
</style>
</head>
<body>
	<%@ include file="common/navbar.jsp"%>

	<%
		DaoI daoI = new DaoImpl();
	%>
	<div class="container">
		<div class="mt-3">
			<p class="text-center text-danger display-4">
				<u>ADMIN PANEL</u>
			</p>
		</div>

		<div class="row mt-5 text-center">

			<div class="col-4">
				<div class="card text-white bg-success mb-3 ">
					<div class="card-header">TOTAL USER</div>
					<div class="card-body">
						<h5 class="card-title"><%=daoI.countTotalUsers()%></h5>
					</div>
				</div>
			</div>
			<div class="col-4">
				<div class="card text-white bg-danger mb-3 ">
					<div class="card-header">TOTAL CATEGORIES</div>
					<div class="card-body">
						<h5 class="card-title"><%=daoI.countTotalCategory()%></h5>
					</div>
				</div>
			</div>
			<div class="col-4">
				<div class="card text-white bg-warning mb-3 ">
					<div class="card-header">TOTAL PRODUCTS</div>
					<div class="card-body">
						<h5 class="card-title"><%=daoI.countTotalProducts()%></h5>
					</div>
				</div>
			</div>
		</div>
		<div class="row mt-3 text-center">
			<div class="col-5">
				<div class="card text-white bg-primary mb-3" data-toggle="modal"
					data-target="#add_category">
					<div class="card-header">ADD CATEGORY</div>
					<div class="card-body">
						<h5 class="card-title">Click Here To Add New Category</h5>
					</div>
				</div>
			</div>
			<div class="col-5">
				<div class="card text-white bg-info mb-3" data-toggle="modal"
					data-target="#add_product">
					<div class="card-header">ADD PRODUCT</div>
					<div class="card-body">
						<h5 class="card-title">Click Here To Add New Product</h5>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- Modal for category -->
	<div class="modal fade" id="add_category" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">New Category
						Details</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">Close</span>
					</button>
				</div>
				<div class="modal-body">
					<form action="addCategory" method="post">
						<div class="form-group">
							<label for="catName">Category Name</label> <input type="text"
								class="form-control" name="catName"
								placeholder="Enter Category Name" required="required">
						</div>
						<div class="form-group">
							<label for="catDescription">Category Description</label> <input
								type="text" class="form-control" name="catDescription"
								placeholder="Enter Category Description" required="required">
						</div>

						<div class="text-center">
							<button type="submit" class="btn btn-primary">Add
								Category</button>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>

	<!-- Modal for product -->
	<div class="modal fade" id="add_product" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalLongTitle" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLongTitle">New Product
						Details</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">Close</span>
					</button>
				</div>
				<div class="modal-body">
					<form action="addProduct" method="post"
						enctype="multipart/form-data">
						<div class="form-group">
							<label for="proNumber">Product Number</label> <input type="text"
								class="form-control" name="proNumber"
								placeholder="Enter Product Number" required="required">
						</div>
						<div class="form-group">
							<label for="proName">Product Name</label> <input type="text"
								class="form-control" name="proName"
								placeholder="Enter Product Name" required="required">
						</div>
						<div class="form-group">
							<label for="proDiscription">Product Description</label> <input
								type="text" class="form-control" name="proDiscription"
								placeholder="Enter Product Description" required="required">
						</div>
						<div class="form-group">
							<label for="proPrice">Product Price</label> <input type="number"
								class="form-control" name="proPrice"
								placeholder="Enter Product Price" required="required">
						</div>
						<div class="form-group">
							<label for="proQuantity">Product Quantity</label> <input
								type="number" class="form-control" name="proQuantity"
								placeholder="Enter Product Quantity" required="required">
						</div>
						<div class="form-group">
							<label for="category">Product Category</label>
							<div>
								<select class="form-control" name="category">
									<%
										List<Category> list = daoI.dropdownCategory();

									for (Category cat : list) {
									%>
									<option value="<%=cat.getCatId()%>"><%=cat.getCatName()%></option>

									<%
										}
									%>
								</select>
							</div>
						</div>
						<div class="form-group">
							<label for="proPic">Product Image</label> <input type="file"
								name="proPic" required="required" />
						</div>
						<div class="text-center">
							<button type="submit" class="btn btn-primary">Add
								Product</button>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>

</body>
</html>