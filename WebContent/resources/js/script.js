function updateStatus() {

	var message = $('textarea#statusUpdateText').val();
	$.ajax({
		type : 'POST',
		url : 'updateStatus',
		dataType : 'json',
		data : {
			text : message
		},
		success : function(response) {
		}
	});
	document.getElementById("statusUpdateText").value = "";
}

function updateNewsFeed() {

	$.ajax({
		type : 'POST',
		url : "home",
		success : function(response) {

			$("#chat").fadeOut(1000);
			$('#chat').html(response);
			$('#chat').fadeIn(1000);
		},
		dataType : "text"
	});

}

function updateLikeComment(element) {
	var flag;
	var statusUpdateID = $(element).parent().parent().attr("id").trim();
	var likeVal = $(element).text().trim();
	var comparator = likeVal;
	if (comparator == "Liked")
		{
		$(element).text("Like");
		flag  = 2;
		}
		
	else if (comparator == "Like")
		{
		$(element).text("Liked");
		
		var trimText = $(element).next().text().trim();
		if(trimText == "Disliked")
			 $(element).next().text("Dislike");
		
		flag  = 1;
		}
	

	$.ajax({
		type : 'POST',
		url : "updateLikeTable",
		dataType : 'json',
		data : {
			statusUpdateID : statusUpdateID,
			flagVal : flag
		},
		success : function(response) {
		},
		dataType : "text"
	});
}

function updateDisLikeComment(element) {
var flag;
	var statusUpdateID = $(element).parent().parent().attr("id").trim();
	var dislikeVal = $(element).text().trim();
	var comparator = dislikeVal;
	if (comparator == "Disliked")
		{
		$(element).text("Dislike");
		flag  = 2;
		}
		
	else if (comparator == "Dislike")
		{
		$(element).text("Disliked");
		
		var trimText = $(element).prev().text().trim();
		if(trimText == "Liked")
			 $(element).prev().text("Like");
		
		var flag = 0;
		}
	$.ajax({
		type : 'POST',
		url : "updateLikeTable",
		dataType : 'json',
		data : {
			statusUpdateID : statusUpdateID,
			flagVal : flag
		},
		success : function(response) {
		},
		dataType : "text"
	});
}

function updateComment(element)
{
	var comment = $(element).prev().prev().val();
	var statUpID =  $(element).parent().parent().parent().attr('id');
	var appendPlease =  $(element).parent().parent().attr('id');
	
	$.ajax({
		type : 'POST',
		url : 'updateComment',
		dataType : 'json',
			 accepts: "application/json; charset=utf-8",
		data : {
			text : comment,
			statusUpdateID : statUpID
		},
		
		success : function(response) {
			
		}
	});
	var userName = $(element).next().val();
	var appenderDiv = $(element).parent();
	var appenderDivId = $(element).parent().attr("id");
	$(appenderDiv).replaceWith('<div style="border: 1px solid black;"><div></div><div id="'+appenderDivId+'" class="varclass"><p style="color:#7D110C">'+userName+'</p></div><div><p>'+comment+'</p></div></div>');
	
	 $('#'+appendPlease).append('<div><textarea placeholder="Any Comments ?" style="width: 40%; height: 40%;"  maxlength="200" ></textarea><br><input class="commentBtn" type="button" value="Post" onclick="updateComment(this)"></div>');
}


