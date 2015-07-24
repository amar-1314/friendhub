$(document).ready(function() {
    var maxnumber_fields      = 5; //maximum input boxes allowed
    var wrapper         = $(".input_fields_wrap1"); //Fields wrapper
    var adding_button      = $(".add_educationalfield_button"); //Add button ID
    
    var x = 1; //initlal text box count
    $(adding_button).click(function(e){ //on add input button click
        e.preventDefault();
        if(x < maxnumber_fields){ //max input box allowed
            x++; //text box increment
            $(wrapper).append('<form id="${educationDetail.education_profile_ID}"><br><div><div class ="basicfields"><label>College Name:</label><span><input type="text" name="collegeName"></span></div><br><div style="width: 140%"><div class="basicfields"><label>From:</label><span><input type="date" name="fromDate"></span><label id = "to-label">To:</label><input type="date" name="toDate"></div></div></div><input type="button" onclick="addeducationDetailsUpdate(this)" value="Save Changes"</div><a href="#" class="remove_field">Remove</a></div></form>'); //add input box
        }
    });
    
    $(wrapper).on("click",".remove_field", function(e){ //user click on remove text
        e.preventDefault(); $(this).parent('div').remove(); x--;
    })
});

function educationDetailsUpdate(element){
	
	var form = $(element).closest('form');
	
	$(form).submit(function( event ) {
		  alert( "Handler for .submit() called." );
		  event.preventDefault();
		});
	
	
	var educationProfileID = $(form).attr('id');
	var userID =  $(form).find('input[name="userID"]').val();
	var collegename  = $(form).find('input[name="collegeName"]').val();
	var fromDate =  $(form).find('input[name="fromDate"]').val();
	var toDate = $(form).find('input[name="toDate"]').val();

	$.ajax({
		type:'POST',
		url: "addEducationDetails",
		data : {
			education_profile_ID:educationProfileID,
			userID : userID,
			collegeName : collegename,
			fromDate : fromDate,
			toDate : toDate
			
		},
		success: function(response){
			
		},
		});
}

function addeducationDetailsUpdate(element){
	
	var form = $(element).closest('form');
	
	$(form).submit(function( event ) {
		  alert( "Handler for .submit() called." );
		  event.preventDefault();
		});
	
	
	
	var collegename  = $(form).find('input[name="collegeName"]').val();
	var fromDate =  $(form).find('input[name="fromDate"]').val();
	var toDate = $(form).find('input[name="toDate"]').val();

	$.ajax({
		type:'POST',
		url: "addNewEducationDetails",
		data : {
			
			collegeName : collegename,
			fromDate : fromDate,
			toDate : toDate
			
		},
		success: function(response){
			
		},
		});
}