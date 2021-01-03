<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>SparkleWeb - Registration</title>
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
				<div class="card mb-3">
					<form action="newRegister" method="post"
						enctype="multipart/form-data">
						<div class="card-header bg-info">
							<h5>Sign Up</h5>
						</div>
						<div class="card-body text-primary">
							<div class="form-group ">
								<label for="userName"><strong>User Name</strong></label> <input
									type="text" class="form-control border border-primary"
									name="userName" placeholder="Enter Your Name"
									required="required">
							</div>
							<div class="form-group">
								<label for="userEmail"><strong>Email address</strong></label> <input
									type="email" class="form-control border border-primary"
									name="userEmail" placeholder="Enter Valid Email"
									required="required">
							</div>
							<div class="form-group">
								<label for="userPassword"><strong>Password</strong></label> <input
									type="text" class="form-control border border-primary"
									name="userPassword" placeholder="Enter Your Password"
									required="required">
							</div>
							<div class="form-group">
								<label for="userMobileNumber"><strong>Mobile
										Number</strong></label> <input type="text"
									class="form-control border border-primary"
									name="userMobileNumber" placeholder="Enter Mobile Number"
									required="required">
							</div>
							<div class="form-group">
								<label for="userPic"><strong>Profile Image</strong></label> <input
									type="file" class="form-control border border-primary"
									name="userPic" placeholder="Upload Profile Pic"
									required="required">
							</div>
						</div>
						<div class="card-footer bg-transparent">
							<div class="text-center">
								<button class="btn btn-primary" type="submit">Register</button>
								<button class="btn btn-warnimg" type="reset">Reset</button>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>