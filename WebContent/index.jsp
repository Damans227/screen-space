<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<%@include file="components/common_css_js.jsp"%>

<title>Screenspace</title>
</head>

<script>
	function validateform() {
		var uname = document.myform.uname.value;
		var pass = document.myform.pass.value;
		var email = document.myform.email.value;
		var phone = document.myform.phone.value;

		if (uname == null || uname == "") {
			alert("Username can't be left blank!");
			return false;
		} else if (email == null || email == "") {
			alert("Email can't be left blank!");
			return false;
		} else if (pass == null || pass == "") {
			alert("Password can't be left blank!");
			return false;
		} else if (phone == null || phone == "") {
			alert("Phone can't be left blank!");
			return false;
		}

	}
</script>

<body>

	<%@include file="components/navbar.jsp"%>



	<div class="row mt-5">
		<div class="col-md-4 offset-md-4">
			<div class="card mt-5">
				<div class="card-body px-5">

					<h3 class="text-center mt-2">Welcome to Screenspace!</h3>

					<form name="myform" method="post" action="signupController"
						onsubmit="return validateform()">

						<div class="form-group">
							<label for="uname">Username:</label> <input name="uname"
								type="text" class="form-control" id="uname"
								aria-describedby="unameHelp" placeholder="Enter Username">
						</div>

						<div class="form-group">
							<label for="email">Email Address:</label> <input name="email"
								type="email" class="form-control" id="email"
								aria-describedby="emailHelp" placeholder="Enter Email Address">
						</div>

						<div class="form-group">
							<label for="pass">Password:</label> <input name="pass"
								type="password" class="form-control" id="pass"
								aria-describedby="passHelp" placeholder="Enter Password">
						</div>

						<div class="form-group">
							<label for="phone">Phone number:</label> <input name="phone"
								type="text" class="form-control" id="phone"
								aria-describedby="phoneHelp" placeholder="Enter Phone Number">
						</div>




						<div class="container text-center">
							<input class="btn btn-secondary" type="submit" value="Sign Up">
							<a class="btn btn-outline-success" href="login.jsp">Login</a>

						</div>



					</form>


				</div>


			</div>
		</div>
	</div>

</body>
</html>