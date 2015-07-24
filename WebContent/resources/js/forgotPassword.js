/**
 * 
 */  

function getSecQuesEmail()
{
	var emailID = $("#email").val();
	
	var jsonfile= {json:emailID};  
	$.ajax({
	type:'POST',
	url: "fetchSecQuesWithEmail",
	data: jsonfile,
	success: function(response){
		
		 // alert(response);
			var div = document.getElementById("secQues");
			secQues.innerHTML=response;
		      
	},  
	dataType: "text" 
	});
	
}    

function getSecQuesName()
{
	var fname = $("#fname").val();
	var lname = $("#lname").val();
	
	var jsonfile= {json1:fname,json2:lname};  
	$.ajax({
	type:'POST',
	url: "fetchSecQuesWithName",
	data: jsonfile,
	success: function(response){
		
		 // alert(response);
			var div = document.getElementById("secQues");
			secQues.innerHTML=response;
		      
	},  
	dataType: "text" 
	});
	
}