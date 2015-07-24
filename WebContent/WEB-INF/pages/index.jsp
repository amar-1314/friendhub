<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>FriendHub</title>
<link rel="stylesheet" type="text/css" href="resources/css/app.css">

    <link rel="stylesheet" type="text/css" href="http://fonts.googleapis.com/css?family=PT+Sans">
<script type="text/javascript" src="resources/js/angular.js"> </script>
<script type="text/javascript" src="resources/js/vendor/jquery.js"> </script>

</head>
<script>
function dupEmail(){
// alert("in js");
 document.getElementById("emailcopy").value=document.getElementById("email").value;
//alert(document.getElementById("emailcopy").value);	
	
	
}
</script>
<body>

	<div class="header-div" style="height: 16%;">
		<div class="left-div">
			<h2>FriendHub</h2>
			<br>
			<h3 style="color: #E1D8B7;">A lot will happen over FriendHub ...</h3>
		</div>
		<div  style="float: right; height: 10%;">
			<div>
				<form name="login" action="login" method="post"
					accept-charset="utf-8" class="loginForm">
					<label for="username">Email</label> <input type="email"
						name="username" id="email" placeholder="yourname@email.com" required>
					<label for="password">Password</label> <input type="password"
						name="password" placeholder="password" required> <input
						type="submit" class="btn" value="Login" onclick="dupEmail()">
				</form>
			</div>
			<label  style="color: #E1D8B7;">${OTPmessage}</label>
			<div style="display: ${hideOrUnhideOTPBlock}">
			<form  name="otpLogin" action="OTPlogin" method="post">
			<input type="hidden" id=emailcopy name=emailcopy style="background-color:#7D110C; color:#7D110C" value="${emailcopy}">
			<input style="width: 250px; height: 30px; font-size: 20px;" type="text" placeholder="Enter OTP here" id=otpLogin name=otplogin>
			<input class="btnOTP" type="submit" value="login with OTP">
			</form>
			</div>
			<label  style="color: #E1D8B7;">${message}</label>
			<div style="float: right">
					
				<spring:url value="/forgotPassword" var="forPswd" htmlEscape="true" />
				<a href="${forPswd}" class="links">Forgot Password</a>

			</div>
      <br> 
      <br>
					<div style="float: right">
					<label style="font-size:25px; color: #E1D8B7;">Get me started. </label>
					<spring:url value="/signUp" var="signUpUrl" htmlEscape="true"/>
 						 	<a  href="${signUpUrl}" class="links">Sign Up here</a>
				</div>

		</div>

	</div>

			<img src="resources/images/IU_original.jpg" alt="Login" class="loginImage">

	<footer class="footer-div">
		<div>
			<h5 style="color: #E1D8B7;">© 2015 FriendHub</h5>
		</div>
	</footer>



</body>
</html>

