/**
 This file is for handling User's updates to his account settings
 */
function update2FactorAuth(){
	var TwoFacStatus;
	var emailID= document.getElementById("hiddenEmail").value;

	if($("#switch1").is(':checked')) {
		// alert( $("#switch1").val());
		//alert("Enabled");
		TwoFacStatus="Enabled";
	} else {
		/* alert( $('input[type=hidden]').val());*/
		//alert("Disabled");
		TwoFacStatus="Disabled";
	}
	var jsonfile= {json1:emailID}; 
	if(TwoFacStatus=="Enabled"){
		$.ajax({
			type:'POST',
			url: "updateTwoFactorWithEmail",
			data: jsonfile,
			dataType: "text",
			success: function(response){
				if(response=="success"){
					//alert("updated");
					document.getElementById("TwoFacStatus").innerHTML="Updated";
				}
				else{
					//alert("Could not update");
					document.getElementById("TwoFacStatus").innerHTML="Coult not Update";
				}
			},
		});
	}
	else{
		$.ajax({
			type:'POST',
			url: "disableTwoFactorWithEmail",
			data: jsonfile,
			dataType: "text",
			success: function(response){
				if(response=="success"){
					//alert("updated");
				}
				else{
				//	alert("Could not update")
				}
			},
		});
	}
}
function editSecQuesAns(){
	$("#secQues").prop('readonly', false);
	$("#secAns").prop('readonly', false);
}

function updateSecQuesAns(){
	$("#secQues").prop('readonly', true);
	$("#secAns").prop('readonly', true);
	
	var secQues = $("#secQues").val();
	var secAns =  $("#secAns").val();
	var emailID= document.getElementById("hiddenEmail").value;
	
	var jsonfile= {json1:secQues,json2:secAns,json3:emailID}; 
	$.ajax({
		type:'POST',
		url: "updateSecQuesAns",
		data: jsonfile,
		dataType: "text",
		success: function(response){
			if(response=="success"){
				//alert("updated");
				document.getElementById("SecStatus").innerHTML="Updated";

			}
			else{
				document.getElementById("SecStatus").innerHTML="Coult not Update";

				//alert("Could not update")
			}
		},
		});
}

function deactUser(){
	var emailID= document.getElementById("hiddenEmail").value;
	var jsonfile= {json1:emailID}; 
	$.ajax({
	type:'POST',
	url: "deactivateUserWithEmail",
	data: jsonfile,
	dataType: "text",
	success: function(response){
		if(response=="success"){
			
		//alert("Deactivated");	
		document.getElementById("deactStatus").innerHTML="Deactivated";

		}
		else{
			document.getElementById("deactStatus").innerHTML="Could not Deactivate";

			//alert("Could not Deactivate");
		}
	},
	});
}

function deleteUser(){
	var emailID= document.getElementById("hiddenEmail").value;
	var jsonfile= {json1:emailID}; 
	$.ajax({
	type:'POST',
	url: "deleteUserWithEmail",
	data: jsonfile,
	dataType: "text",
	success: function(response){
		if(response=="success"){
			
	//	alert("Deleted");	
		}
		else{
			//alert("Could not Delete");
		}
	},
	});
}

function verifyPassword(){
	//alert("in js");
	var currPassword=document.getElementById("currPwd").value;
	var emailID= document.getElementById("hiddenEmail").value;
	var jsonfile= {json1:emailID,json2:currPassword}; 
	$.ajax({
		type:'POST',
		url: "verifyPassword",
		data: jsonfile,
		dataType: "text",
		success: function(response){
			if(response=="verified"){
				document.getElementById("pwdResult").innerHTML="Verified";
				//alert("You are Verified");
				document.getElementById("changePassword").disabled = false;
				document.getElementById("inputPassword").readOnly=false;
				document.getElementById("reEnterPassword").readOnly=false;
			
				
			}
			else{
				document.getElementById("pwdResult").innerHTML="Incorrect.";
				
				//alert("Incorrect");
			}
		},
		});
}

function updatePassword(){
	var emailID= document.getElementById("hiddenEmail").value;
	 var pwd = document.getElementById('inputPassword').value;
	 
	var jsonfile= {json1:emailID,json2:pwd}; 

	 $.ajax({
			type:'POST',
			url: "updatePassword",
			data: jsonfile,
			dataType: "text",
			success: function(response){
				if(response=="success"){
					
			//	alert("update");
					
				}
				else{
				//	alert("could not");
				}
			},
			});
}

