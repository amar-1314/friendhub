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
<script type="text/javascript" src="resources/js/vendor/jquery.js"> </script>

</head>
<script type="text/javascript" src="resources/js/passwordStrength.js">

</script>
<script type="text/javascript" src="resources/js/passwordMatch.js">

</script>
<script type="text/javascript" src="resources/js/forgotPassword.js">

</script>
<script>
	 //Fetch Sec Ques by Using Name
/* 	 function dupEmail(){
	var orgEmail=document.getElementById("email");
	var dupEmail=document.getElementById("duplicateEmail");
	dupEmail.value=orgEmail.value;
} */
	var authMeth="byEmail";
	function unhideDiv1()
	{
		var div=document.getElementById("div1");
		authMeth="byName";
		div.style.display="block";
		var divOther=document.getElementById("div2");
		if(divOther.style.display="block")
			divOther.style.display="none";
		
	}
	function unhideDiv2()
	{
		 // authType=1; Indicate: Fetch Sec Ques by using Email
		 authMeth="byEmail";
		var div=document.getElementById("div2");
		div.style.display="block";
		var divOther=document.getElementById("div1");
		if(divOther.style.display="block")
			divOther.style.display="none";
	}
		
	function loadVerSection()
	{
		if(authMeth=="byEmail")
			getSecQuesEmail(); 
		else
			getSecQuesName();
		
			/* dupEmail(); */
		var div=document.getElementById("verDiv");
		var div1=document.getElementById("div2");
		var div2=document.getElementById("div1");
		if((div1.style.display!="none") || (div2.style.display!="none"))
		div.style.display="block";
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
	
	<label style="height:30px;width:300px;font-size:30px">Login Details Recovery</label>
	
	<div style="top:30%;padding-left:20%;padding-right:40%">
					<h2>Identify Yourself: You have only one chance</h2>
		
		<form name="forgot" method="POST" action="forgotLogin">	
			<input type="button" value="Forgot Email Address" style="width:300px;height:45px;font-size:20px;font-style:bold;background-color:grey"
			 		onclick=unhideDiv1()><br />
			<div id=div1 class=divHide>
				<br /> <label style="height:40px;width:100px;font-size:20px">First Name</label><input style="float:right;width:300px;height:40px;font-size:20px;"  pattern="[A-Za-z-]+" placeholder="Alphabets only" 
					 type="text"
					id="fname" name="fname" maxlength="45"><br/><br/> <label style="height:40px;width:100px;font-size:20px">Middle
					Name</label><input pattern="[A-Za-z-]+" placeholder="Alphabets only"  style="float:right;width:300px;height:40px;font-size:20px"
					type="text" id="mname" name="mname" maxlength="45"> <br/><br/><label style="height:40px;width:200px;font-size:20px">Last
					Name</label><input  pattern="[A-Za-z-]+" placeholder="Alphabets only" style=" float:right;width:300px;height:40px;font-size:20px"
					type="text" id="lname" name="lname" maxlength="45"><br /><br/>
				<input type="button" value="OK" style="height:40px;width:100px" onclick="loadVerSection()">
				<div class="basicfields">
				</div>

			</div><br/><br/><br/><br/>

			<input type="button" value="Forgot Password" style="width:300px;height:45px;font-size:20px;background-color:grey;font-style:bold" onclick=unhideDiv2()><br />
	
			<div id=div2 class=divHide>
				<br /> <label style="height:40px;width:100px;font-size:20px">Email Address</label><br/><br/><input style="width:400px;height:40px;font-size:20px"
					type="text" 
					id="email" name="email" maxlength="45"> <input style="height:40px;width:100px"
					type="button" value="OK" onclick="loadVerSection()">
			</div>
		<div>
			<div id=verDiv class=divHide>
				<h1>Authenticate Yourself:</h1><br/>
				<label style="height:30px;width:100px;font-size:20px"> Security Question: </label> <label id=secQues style="height:30px;width:100px;font-size:20px">
					</label><br/>
				<label style="height:30px;width:100px;font-size:20px"> Security Answer: </label><input type=text size="45" id=secAns name=secAns placeholder="Your Answer" maxlength="45" style="width:200px;height:30px;font-size:20px"><br/> <input style="width:200px;height:30px;font-size:20x;"
					type="submit" value="Verify" id=subVer>
			</div>
		</div>   
	</form>
	</div>
         

	<footer class="footer-div">
		<div>
			<h5>© 2015 FriendHub</h5>
		</div>
	</footer>



</body>
</html>

