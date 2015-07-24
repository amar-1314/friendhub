/**
 * 
 */

function makeChanges(){

	if($("#switch1").is(':checked')) {			//Searchable only by Friends
		// alert( $("#switch1").val());
		alert("Enabled");
		document.getElementById("sf").value="1";
	} 
	else{
		document.getElementById("sf").value="0";
	}
	if($("#switch2").is(':checked')) {			//Profile Data visible to Friends
		// alert( $("#switch1").val());
		alert("Enabled");
		document.getElementById("pd").value="F";
		document.getElementById("pp").value="F";
	}
	else{
		document.getElementById("pd").value="P";
		document.getElementById("pp").value="P";
	}
	if($("#switch3").is(':checked')) {			//Status
		// alert( $("#switch1").val());
		alert("Enabled");
		document.getElementById("stf").value="F";
	} 
	else{
		document.getElementById("stf").value="P";
		
	}
	
	if($("#switch5").is(':checked')) {			//Messaging
		// alert( $("#switch1").val());
		alert("Enabled");
		document.getElementById("mf").value="F";
	} 
	else{
		document.getElementById("mf").value="P";
		
	}
	
	
}
