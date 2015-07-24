<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<script type="text/javascript">
	function triggerInput() {
		$('#inputFile').click();
	}
	var f = document.getElementById('inputFile');

	f.onchange = function(e) {
		var ext = this.value.match(/\.([^\.]+)$/)[1];
		switch (ext) {
		case 'js':
		case 'exe':
			alert('Input file not supported');
			this.value = '';
			return;
		default:
			if (this.files[0].size > 20000000) {
				this.value = '';
				alert('Cannot upload File : File size exceeds maximum limit');
				return;
			}
		}

		//	 var formData = new FormData($('form')[0]);
		var formData = new FormData();
		formData.append("file", inputFile.files[0]);

		var friendID = $('.friendID').attr("id");
		formData.append("friendID", friendID);
		$.ajax({
			url : 'uploadAttachment',
			data : formData,
			dataType : 'text',
			processData : false,
			contentType : false,

			enctype : 'multipart/form-data',
			type : 'POST',
			success : function(response) {
				// $('#result').html(data);
				$("#messageList").append(response);
				alert("file uploaded successfully")
			}
		});

	};
</script>
<div id="chatWindowHtml" class="panel panel-primary">
	<div class="panel-heading row">
		<span style="text-align: left; color: white;" class="col-md-10">Chat
			With ${friendName}</span>
		<div class="col-md-1">
			<form enctype="multipart/form-data">
				<input name="file" type="file" id="inputFile" style="display: none" />
				<a href="javascript:void(0)" onclick="triggerInput()"
					data-toggle="tooltip" data-placement="top" title="Add Attachments"
					style="color: black;"> <span
					class="glyphicon glyphicon-paperclip"></span></a>
			</form>
		</div>

		<a href="#" style="color: black;" data-toggle="tooltip"
			data-placement="top" title="Close" class="col-md-1"><span
			class="glyphicon glyphicon-remove icon_close" id="chat_window_1"></span></a>
	</div>

	<div class="panel-body" id="chatBody">
		<ul id="messageList" class="media-list messageList">
			<c:forEach items="${messageList}" var="messages">
				<li class="media">
					<div class="media-body">
						<div class="media">
							<c:if
								test="${not empty messages.senderID.profilePicutreBase64String}">
								<a class="pull-left" href="#"> <img
									class="media-object img-circle "
									style="height: 40px; width: 40px;"
									src="${messages.senderID.profilePicutreBase64String}" />
								</a>
							</c:if>
							<c:if test="${empty messages.senderID.profilePicutreBase64String}">
								<a class="pull-left" href="#"> <img
									class="media-object img-circle "
									style="height: 40px; width: 40px;"
									src="resources/images/default.png" />
								</a>
							</c:if>
							<c:choose>
								<c:when test="${fn:startsWith(messages.message,'Attachment:') }">
									<div class="media-body">
										<p>
											<a id="${messages.id}"
												href="downloadAttachment?id=${messages.id}">${messages.message}</a>
										</p>
										<br /> <small class="text-muted">${messages.senderID.firstName}
											| <span class="glyphicon glyphicon-time"></span>
											${messages.timeStamp}
										</small>
										<hr />
									</div>
								</c:when>

								<c:otherwise>
									<div class="media-body">
										<p>${messages.message}</p>
										<br /> <small class="text-muted">${messages.senderID.firstName}
											| <span class="glyphicon glyphicon-time"></span>
											${messages.timeStamp}
										</small>
										<!-- 23rd June at 5:00pm -->
										<hr />
									</div>
								</c:otherwise>
							</c:choose>

						</div>
					</div>
				</li>
			</c:forEach>
		</ul>
	</div>
	<div class="panel-footer">
		<div class="input-group">
			<input type="text" id="chatMessage" class="form-control"
				placeholder="Enter Message" /> <span class="input-group-btn">
				<button id="${friendID}" class="btn btn-info friendID" type="button"
					onclick="sendMessage(this)">SEND</button>
			</span>
		</div>
	</div>
</div>
