<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<%@include file="components/common_css_js.jsp"%>

<title>Insert title here</title>
</head>


<script>  
function validateform(){  
var uname=document.myform.uname.value;  
var pass=document.myform.pass.value;  
  
if (uname==null || uname==""){  
  alert("Username can't be left blank!");  
  return false;  
}else if(pass==null || pass==""){  
  alert("Password can't be left blank!");  
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
					<form name="myform" action="loginController" method="post"
						onsubmit="return validateform()">

						<div class="form-group">
							<label for="uname">Username:</label> <input name="uname"
								type="text" class="form-control" id="uname"
								aria-describedby="phoneHelp" placeholder="Enter Username">
						</div>

						<div class="form-group">
							<label for="pass">Password:</label> <input name="pass"
								type="password" class="form-control" id="pass"
								aria-describedby="phoneHelp" placeholder="Enter Password">
						</div>

						<div class="container text-center">
							<input class="btn btn-secondary" type="submit" value="Login">
							<a class="btn btn-outline-primary" href="/Screenspace">Sign
								Up</a>

						</div>



					</form>
				</div>
			</div>
		</div>
	</div>


</body>
</html>