 function addFriend() {
	var message = $('#contactSearchBar').val();

	$.ajax({
		type : 'POST',
		url : 'getFriendList',
		data : {
			text : message
		},

		success : function(response) {
			$('#contactsBlock').html('')
			$('#contactsBlock')
			.append('<div> <div style="float: left; width: 7%; height: 200px;"> <img id="profilePicture" alt="Profile Picture"src=""></div></div><div style="width: 40%; height: 200px; float: left;"><a href="${home}">'+ response.firstName+ '</a><br> <label style="color: #A9A9A9"> friends</label><br> <label style="color: #A9A9A9">${friendCount[status.index]} friends</label></div>');
}

		
	});
	

	
}
