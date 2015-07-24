$(document).ready(function() {
   var addressLine2 = $('#picString').val();
    
    $('#profilePicture').attr('src',addressLine2);
});

function validateform() {

	var phoneno = /^\d{10}$/;
	document.forms["basicDetails"]["phonenumber"].style.border = "";
	document.forms["basicDetails"]["zipcode"].style.border = "";
	document.forms["basicDetails"]["city"].style.border = "";
	document.forms["basicDetails"]["firstname"].style.border = "";
	document.forms["basicDetails"]["middlename"].style.border = "";
	document.forms["basicDetails"]["lastname"].style.border = "";
	
	var name = /^[a-zA-Z]+$/;
	if (!name.test(!document.forms["basicDetails"]["firstname"].value)) {
		document.forms["basicDetails"]["firstname"].style.border = "solid 1px red";
		return false;
	}

	if (!document.forms["basicDetails"]["middlename"].value.match(name)) {
		document.forms["basicDetails"]["middlename"].style.border = "solid 1px red";
		return false;
	}

	if (!document.forms["basicDetails"]["lastname"].value.match(name)) {
		document.forms["basicDetails"]["lastname"].style.border = "solid 1px red";
		return false;
	}
	
	
	if (document.forms["basicDetails"]["phonenumber"].value.length > 0) {
		if (!document.forms["basicDetails"]["phonenumber"].value.match(phoneno)) {
			document.forms["basicDetails"]["phonenumber"].style.border = "solid 1px red";
			return false;
		}
	}


	var cityRegex = /^[a-zA-Z]+$/;
	if (document.forms["basicDetails"]["city"].value.length > 0) {
		if (!document.forms["basicDetails"]["city"].value.match(cityRegex)) {
			document.forms["basicDetails"]["city"].style.border = "solid 1px red";
			//return false;
		}
	}

	var zipcode = /^\d{5}$/;
	if (document.forms["basicDetails"]["zipcode"].value.length > 0) {
		if (!document.forms["basicDetails"]["zipcode"].value.match(zipcode)) {
			document.forms["basicDetails"]["zipcode"].style.border = "solid 1px red";
			return false;
		}
	}
	
	
	return true;

}

  
function changeimage() {
	var target = document.getElementById("profilePicture");
	var current = profilePicture.src;
	var url = prompt("change address to:", current);
	profilePicture.src = url;
}
function validateworkform() {

}

function Upload() {
    var fileUpload = document.getElementById("profilepicture");
    return true;
}
