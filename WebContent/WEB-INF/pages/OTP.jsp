<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>FriendHub</title>
<link rel="stylesheet" type="text/css" href="resources/css/app.css">
<link rel="stylesheet" type="text/css"
	href="http://fonts.googleapis.com/css?family=PT+Sans">
<script type="text/javascript" src="resources/js/vendor/jquery.js">
	
</script>

</head>
<script type="text/javascript" src="resources/js/passwordStrength.js">
	
</script>
<script type="text/javascript" src="resources/js/passwordMatch.js">
	
</script>
<script type="text/javascript" src="resources/js/verifyEmail.js">
	
</script>
<script>
	function unhide() {
		getOTP();
		/* var otp = document.getElementById("otp");
		if (otp.value == "123456") {

			var div = document.getElementById("actualSignUp");
			if (div.style.display == "none") {
				div.style.display = "block";
			} else {
				div.style.display = "block";
			}
		}
		 */
	}
</script>
<body>

	<div class="header-div">
		<div class="left-div">
			<h2>FriendHub</h2>
			<br>
			<h4>A lot will happen over FriendHub ...</h4>
		</div>

	</div>



	<div class="registerFormNames">
<form action="OTPlogin" method="POST">
		<label class="labelHead"><b>E-Mail Confirmation:</b></label><br/><label>E-Mail
			Address*</label> <input type="email" id="email" name="email" maxlength="45"
			placeholder="example@email.com" required>  <input
			class="appButtons"
			type="button" name="reqOTP" id="reqOTP" value="Get OTP"
			onclick="getEmail()">		
			<br /><label id="sendOTPStatus"> </label><br/><br/> <label>Enter the OTP
			sent to your e-mail address*</label><input
			type="number" id="otp"
			name="otp" maxlength="6" required> <input
			type="submit" name="confOTP" id="confOTP" value="Confirm OTP" class="appButtons"
			><br /> <br />
		<label id="incorrectOTP"> </label>
</form>	
	
	
	
	</div>


	<footer class="footer-div">
		<div>
			<h5>© 2015 FriendHub</h5>
		</div>
	</footer>



</body>
</html>

