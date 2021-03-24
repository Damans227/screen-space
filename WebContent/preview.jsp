<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">


<%@include file="components/common_css_js.jsp"%>


<title>Insert title here</title>
</head>
<body>

	<%
	response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");

	if (session.getAttribute("uname") == null) {

		response.sendRedirect("login.jsp");
	}
	%>

	<%@include file="components/wdnavbar.jsp"%>
	
	<div class="slideshow-container">

		<c:forEach items="${imageUrlList}" var="item">
		
		<div class="mySlides fade">

				<img src="data:image/jpg;base64,${item.base64Image}" style="width: 100%">
				
		</div>

		</c:forEach>
		
	</div>
		
		

<div style="text-align:center">
<c:forEach items="${imageUrlList}" var="item"> 
  <span class="dot"></span> 
</c:forEach>
</div>	
	



<script>
var slideIndex = 0;
showSlides();
function showSlides() {
  var i;
  var slides = document.getElementsByClassName("mySlides");
  var dots = document.getElementsByClassName("dot");
  for (i = 0; i < slides.length; i++) {
    slides[i].style.display = "none";  
  }
  slideIndex++;
  if (slideIndex > slides.length) {slideIndex = 1}    
  for (i = 0; i < dots.length; i++) {
    dots[i].className = dots[i].className.replace(" active", "");
  }
  slides[slideIndex-1].style.display = "block";  
  dots[slideIndex-1].className += " active";
  setTimeout(showSlides, 2000); // Change image every 2 seconds
}
</script>
	

</body>
</html>