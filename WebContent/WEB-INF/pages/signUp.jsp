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
	<h2>Sign Up Form.</h2>


	<div class="registerFormNames">
<form>
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
			type="button" name="confOTP" id="confOTP" value="Confirm OTP" class="appButtons"
			onclick="unhide()"><br /> <br />
		<label id="incorrectOTP"> </label>
</form>	
	
		<form:form action='signUp' method='post' commandName='userSignUpForm'>
			<div id="actualSignUp" class="divHide">
				<label style="font-style:bold;font-size:24px;">Your Details</label><br />
				<form:input path="emailID" type="email" id="emailCopy"
					class="divHide" />
				<label>First Name</label>
				<form:input path="firstName"
					style="position: relative; margin-left: 10px" type="text" required='true' pattern="[A-Za-z-]+" placeholder="Alphabets only" title="Alphabets only"
					id="fname" name="fname" maxlength="45"/>
				<label>Middle Name</label>
				<form:input path="middleName"
					style="position: relative; margin-left: 10px" type="text" pattern="[A-Za-z-]+" placeholder="Alphabets only" title="Alphabets only"
					id="mname" name="mname" maxlength="45" /><br/><br/>
				<label>Last Name</label>
				<form:input path="lName"
					style="position: relative; margin-left: 10px" type="text" pattern="[A-Za-z-]+" placeholder="Alphabets only" title="Alphabets only"
					id="mname" name="lname" maxlength="45" required="true" />
				<br/><br/>

				<label>Password</label>
				<form:input path="password"
					style="position: relative; margin-left: 10px" type="password" pattern=".{8,}" title="Minimum 8 charachters"
					id="inputPassword" maxlength="32" required="true" />
				<label class="default" id="complexity"></label><br/><br/> <label>Re-Enter
					Password</label><input style="position: relative; margin-left: 10px"
					type="password" id="reEnterPassword" maxlength="32" required
					onkeyup="matchPass()"> <span id="confirmMessage"
					class="confirmMessage"></span>
				<br/><br/><p style="font-size: 14px">
					By clicking Sign Up, you agree to our Terms and that you have read
					our <a href="dataPolicy.jsp" target="_blank">Data Policy</a>
				</p>
				<input
					class="appButtons"
					type="submit" name="register" id="register" value="Register" 
					onclick="dupEmail()">
			

		</div>
		</form:form>
	
	</div>


	<footer class="footer-div">
		<div>
			<h5>© 2015 FriendHub</h5>
		</div>
	</footer>



</body>
</html>

