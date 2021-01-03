<%@page
	import="org.hibernate.engine.transaction.jta.platform.internal.TransactionManagerBasedSynchronizationStrategy"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>SparkleWeb - Log In</title>
<style>
body {
	background-image: url('images/background/login.jpg');
	background-repeat: no-repeat;
	background-attachment: fixed;
	background-size: cover;
}
</style>
</head>
<body>
	<%@include file="common/navbar.jsp"%>

	<div class="container">
		<div class="row mt-5">
			<div class="col-md-6 offset-md-3">
				<div class="card rounded-2">
					<!-- style="max-width: 50rem;" -->
					<div class="card-header bg-info">
						<h5>Log In</h5>
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

					<form action="login" method="post">
						<div class="card-body text-primary">
							<div class="form-group">
								<label for="userEmail"><strong>Email address</strong></label> <input
									type="email" class="form-control border border-primary"
									name="userEmail" placeholder="Enter Email" required="required">
							</div>
							<div class="form-group">
								<label for="userPassword"><strong>Password</strong></label> <input
									type="password" class="form-control border border-primary"
									name="userPassword" placeholder="Enter Password"
									required="required">
							</div>
							<div class="card-footer bg-transparent">
								<div class="text-center">
									<button class="btn btn-primary" type="submit">LogIn</button>
									<button class="btn btn-primary" type="reset">Reset</button>
								</div>
								<div class="mt-3 text-center">
									<p class="font-italic">
										<a href="forgetPass.jsp" class="badge badge-light">forgot
											password...???</a> <a href="register.jsp"
											class="badge badge-light">New User...???</a>
									</p>
								</div>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>

</body>
</html>