
/**
 Functions for Verifying Email 
 */
function dupEmail(){
	var orgEmail=document.getElementById("email");
	var dupEmail=document.getElementById("emailCopy");
	dupEmail.value=orgEmail.value;
	
};

function getEmail()
{
	var emailID = $("#email").val();
	var incOTP=document.getElementById("sendOTPStatus");

	var jsonfile= {json:JSON.stringify(emailID)};
	$.ajax({
	type:'POST',
	url: "sendOTP",
	data: jsonfile,
	dataType: "text",
	success: function(response){
		if(response=="success"){
			//Email Id Already present. Did not send OTP
			//alert("OTP Sent");
			incOTP.innerHTML="Sent OTP to this email. Please check email and enter here";

			var div = document.getElementById("email");
		}
		else{
			incOTP.innerHTML="Invalid Email";
			//alert("Email already exists. OTP not sent.")
		}
	},
	});
}
function getOTP()
{
	var otp = $("#otp").val();
	var incOTP=document.getElementById("incorrectOTP");

	var jsonfile= {json:otp};  
	$.ajax({
	type:'POST',
	url: "otpVerification",
	data: jsonfile,
	success: function(response){
		if(response=="success"){
			incOTP.innerHTML="Correct OTP";

			var div = document.getElementById("actualSignUp");
			if (div.style.display == "none") {
				div.style.display = "block";
			} else {
				
				div.style.display = "block";
			} 
		}
		else{
		//alert(response);
		incOTP.innerHTML="Incorrect OTP.Please retry.";
		}
	},  
	dataType: "text"
	});
	
}
