<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Screenspace</title>

<%@include file="components/common_css_js.jsp"%>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

<script>
	var MAX_FILE_SIZE = 2 * 1024 * 1024; // 2MB

	$(document).ready(function() {
		$('#file').change(function() {
			fileSize = this.files[0].size;
			if (fileSize > MAX_FILE_SIZE) {
				this.setCustomValidity("File must not exceed 2 MB!");
				this.reportValidity();
			} else {
				this.setCustomValidity("");
			}
		});
	});
</script>
</head>
<body>

	<%
	response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");

	if (session.getAttribute("uname") == null) {

		response.sendRedirect("login.jsp");
	}
	%>


	<%@include file="components/wdnavbar.jsp"%>
	<%@include file="components/sidebar.jsp"%>





	<div class="content">

		<div class="alert alert-secondary alert-dismissible fade show mt-3"
			role="alert">

			<h4 class="alert-heading">Welcome ${uname}, How are you ?</h4>
			<p>This is your Screenspace Dashboard.</p>

			<ul>
				<li>You can use it to view or edit your user profile.</li>
				<li>Upload images for your digital signage.</li>
				<li>Preview your signage screen.</li>
			</ul>

			<hr>
			<p class="mb-0">Lets get started!</p>

			<button type="button" class="close" data-dismiss="alert"
				aria-label="Close">
				<span aria-hidden="true">&times;</span>
			</button>
		</div>
		<hr>

		<div class="card">
			<h5 class="card-header">Screen Configuration</h5>
			<div class="card-body">
				<h5 class="card-title">Upload Images</h5>
				<p class="card-text">Please upload images you would like to see
					on your digital signage. You can upload multiple images at once.</p>

				<form action="imageController" method="post"
					enctype="multipart/form-data">
					<input type="file" name="file" id="file" /> <input
						class="btn btn-secondary" type="submit" value="Upload">
				</form>
				<%@include file="components/message.jsp"%>
			</div>
		</div>
		<hr>

		<div class="card">
			<div class="card-body">
				<table class="table table-striped table-hover mt-4">

					<tr>
						<th>#</th>
						<th scope="col">Image Properties</th>
						<th scope="col">Image File</th>

					</tr>

					<c:forEach items="${imageUrlList}" var="item">
						<tr>
							<td></td>
							<td>${item}</td>
							<td><img src="data:image/jpg;base64,${item.base64Image}"
								class="img-thumbnail" style="width: 150px; height: 100px;"></td>
						</tr>
					</c:forEach>

				</table>
			</div>
		</div>

	</div>



	<!-- Modal -->
	<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">Reset
						ScreenPlay</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<p>CAUTION: Resetting ScreenPlay will remove all the images!</p>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary"
						data-dismiss="modal">Close</button>
					<a href="deleteFiles" class="btn btn-danger">Reset</a>
				</div>
			</div>
		</div>
	</div>

	<!-- Purchase Modal -->
	<div class="modal fade bd-example-modal-lg" id="purchaseModal"
		tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
		aria-hidden="true">
		<div class="modal-dialog modal-lg" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">Order
						ScreenPlayer</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<img src="images/Raspberry.png" style="width: 750px; height: 300px">
					<div class="alert alert-danger" role="alert">Sorry! we're out
						of stock at the moment.</div>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary"
						data-dismiss="modal">Close</button>
					<button type="button" class="btn btn-primary">Buy Now</button>
				</div>
			</div>
		</div>
	</div>

	<!-- Purchase Modal -->
	<div class="modal fade bd-example-modal-lg" id="supportModal"
		tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
		aria-hidden="true">
		<div class="modal-dialog modal-lg" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">Support Center</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<form>
						<div class="form-group">
							<label for="exampleFormControlInput1">Email address</label> <input
								type="email" class="form-control" id="exampleFormControlInput1"
								placeholder="name@example.com">
						</div>
						<div class="form-group">
							<label for="exampleFormControlSelect1">Select Issue
								Severity</label> <select class="form-control"
								id="exampleFormControlSelect1">
								<option>1</option>
								<option>2</option>
								<option>3</option>
								<option>4</option>
								<option>5</option>
							</select>
						</div>
						<div class="form-group">
							<label for="exampleFormControlTextarea1">Problem
								Description</label>
							<textarea class="form-control" id="exampleFormControlTextarea1"
								rows="3"></textarea>
						</div>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary"
						data-dismiss="modal">Close</button>
					<button type="button" class="btn btn-primary">Log a ticket</button>
				</div>
			</div>
		</div>
	</div>
	
	
	<!--User Modal -->
	<div class="modal fade" id="userModal" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">User Profile</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">


					<table class="table">
						<thead>
							<tr>
								<th scope="col">#</th>
								<th scope="col">Category</th>
								<th scope="col">Details</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<th scope="row">1</th>
								<td>Username</td>
								<td>${uname}</td>
							</tr>
							<tr>
								<th scope="row">2</th>
								<td>Password</td>
								<td>${pass}</td>

							</tr>
							<tr>
								<th scope="row">3</th>
								<td>Email</td>
								<td>${email}</td>

							</tr>
							<tr>
								<th scope="row">4</th>
								<td>Phone</td>
								<td>${phone}</td>

							</tr>
						</tbody>
					</table>

				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary"
						data-dismiss="modal">Close</button>
				</div>
			</div>
		</div>
	</div>




</body>
</html>