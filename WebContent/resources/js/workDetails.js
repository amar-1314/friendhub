$(document).ready(function() {
    var maxnumber_fields      = 5; //maximum input boxes allowed
    var wrapper         = $(".input_fields_wrap1"); //Fields wrapper
    var adding_button      = $(".add_field_button"); //Add button ID
    
    var x1 = 1; //initlal text box count
    $(adding_button).click(function(e){ //on add input button click
        e.preventDefault();
        if(x1 < maxnumber_fields){ //max input box allowed
            x1++; //text box increment
            $(wrapper).append('<form id="${workDetail.work_ProfileID}"><form:input path="userID" type="hidden" name="userID" /><br><div class="input_fields_wrap"><div><div class ="basicfields"><label>Company Name:</label><span><input type="text" name="companyName"></span></div><div class ="basicfields"><div style="width: 140%"><div class="basicfields"><label>From:</label><span><input type="date" name="fromDate"></span><label id = "to-label">To:</label><input type="date" name="toDate"></div></div></div><input type="button" onclick="addWorkDetailsUpdate(this)" value="Save Changes"></div><a href="#" class="remove_field">Remove</a></div></form>'); //add input box
        }
    });
    
    $(wrapper).on("click",".remove_field", function(e){ //user click on remove text
        e.preventDefault(); $(this).parent('div').remove(); x1--;
    })
});





function workDetailsUpdate(element){
	//var form = element.form;
	//alert($(form).attr('${workDetail.work_ProfileID}'));
	var form = $(element).closest('form');
	
	$(form).submit(function( event ) {
		  alert( "Handler for .submit() called." );
		  event.preventDefault();
		});
	
	
	var workProfileID = $(form).attr('id');
	var userID =  $(form).find('input[name="userID"]').val();
	var workCompanyName  = $(form).find('input[name="companyName"]').val();
	var fromDate =  $(form).find('input[name="fromDate"]').val();
	var toDate = $(form).find('input[name="toDate"]').val();

	$.ajax({
		type:'POST',
		url: "updateWorkDetails",
		data : {
			work_ProfileID : workProfileID,
			userID : userID,
			companyName : workCompanyName,
			fromDate : fromDate,
			toDate : toDate
			
		},
		success: function(response){
			
		},
		});
}

function addWorkDetailsUpdate(element){
	//var form = element.form;
	//alert($(form).attr('${workDetail.work_ProfileID}'));
	var form = $(element).closest('form');
	
	$(form).submit(function( event ) {
		  alert( "Handler for .submit() called." );
		  event.preventDefault();
		});
	
	
	
	var workCompanyName  = $(form).find('input[name="companyName"]').val();
	var fromDate =  $(form).find('input[name="fromDate"]').val();
	var toDate = $(form).find('input[name="toDate"]').val();

	$.ajax({
		type:'POST',
		url: "addWorkDetails",
		data : {
			
			companyName : workCompanyName,
			fromDate : fromDate,
			toDate : toDate
			
		},
		success: function(response){
			
		},
		});
}
