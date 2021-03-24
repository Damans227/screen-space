<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<%@include file="components/common_css_js.jsp" %>

</head>
<body>

<%

response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");

if(session.getAttribute("uname")==null){
	
	response.sendRedirect("login.jsp");
}


%>


	<%@include file="components/wdnavbar.jsp" %>
	<%@include file="components/sidebar.jsp" %>





	<div class="content">
	
		<div class="alert alert-secondary alert-dismissible fade show mt-3" role="alert">

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
					<input type="file" name="file"/> <input
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
							<td>${item} </td>
							<td><img src="data:image/jpg;base64,${item.base64Image}" class="img-thumbnail"
								style="width: 150px; height: 100px;"></td>
						</tr>
					</c:forEach>

				</table>
			</div>
		</div>

	</div>
	
	

<!-- Modal -->
<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Reset ScreenPlay</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
 			<p>CAUTION: Resetting ScreenPlay will remove all the images! </p>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
        <a href="deleteFiles" class="btn btn-danger">Reset</a>
      </div>
    </div>
  </div>
</div>



</body>
</html>