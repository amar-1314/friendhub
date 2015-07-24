$(document).ready(function() {
	// auto-refresh task
	setInterval('updateChatHistory()', 5000);
	//setInterval('updateMessageNotifications()', 10000);

});

function updateMessageNotifications() {
	$.ajax({
		type : 'GET',
		url : 'updateMessageNotifications',
		success : function(response) {
			/*
			 * $('#chatBody').html(''); $('#chatBody').append(response)
			 */
			$('#msgNotification').html('');
			$('#msgNotification').append(response);
		},
	});
}

function updateChatHistory() {
	if ($("#messageList").children("li").length > 0) {
		var friendUserID = $('#chatMessage').siblings('span').find('button')
				.attr('id');
		$.ajax({
			type : 'GET',
			url : 'updateChatHistory',
			data : {
				friendUserID : friendUserID
			},
			success : function(response) {
				$('#chatBody').html('');
				$('#chatBody').append(response)
			},
		});
	}

}