
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>FriendHub</title>
<link rel="stylesheet" type="text/css" href="resources/css/app.css">
<script type="text/javascript" src="resources/js/angular.js"> </script>
</head>
<body>
<spring:url value="/index" var="indexUrl" htmlEscape="true" />
	<div class="header-div">
		<div class="left-div">
			<h2><a href="${indexUrl}">FriendHub</a></h2>
			<br>
			<h4 style="color: #E1D8B7;">A lot will happen over FriendHub ...</h4>
		</div>
	


			<p style="color: #E1D8B7;">You have been successfully logged out</p>
</div>
	<footer class="footer-div">
		<div>
			<h5 style="color: #E1D8B7;">© 2015 FriendHub</h5>
		</div>
	</footer>



</body>
</html>


