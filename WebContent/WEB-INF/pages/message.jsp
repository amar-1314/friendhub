<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%-- <li class="media">

	<div class="media-body">

		<div class="media">
			<a class="pull-left" href="#"> <img
				class="media-object img-circle " style="height: 40px;width: 40px;" src="${message.senderID.profilePicutreBase64String}" />
			</a>
			<div class="media-body">
				<p>${message.message}</p>
				<br /> <small class="text-muted">${message.senderID.firstName}
					| <span class="glyphicon glyphicon-time"></span> ${message.timeStamp} </small>
				<hr />
			</div>
		</div>

	</div>
</li> --%>

<li class="media">
	<div class="media-body">
		<div class="media">
			<a class="pull-left" href="#"> <img
				class="media-object img-circle " style="height: 40px; width: 40px;"
				src="${message.senderID.profilePicutreBase64String}" />
			</a>
			<c:choose>
				<c:when test="${fn:startsWith(message.message,'Attachment:') }">
					<div class="media-body">
						<p>
							<a id="${message.id}"
								href="downloadAttachment?id=${message.id}">${message.message}</a>
						</p>
						<br /> <small class="text-muted">${message.senderID.firstName}
							| <span class="glyphicon glyphicon-time"></span>
							${message.timeStamp}
						</small>
						<hr />
					</div>
				</c:when>

				<c:otherwise>
					<div class="media-body">
						<p>${message.message}</p>
						<br /> <small class="text-muted">${message.senderID.firstName}
							| <span class="glyphicon glyphicon-time"></span>
							${message.timeStamp}
						</small>
						<hr />
					</div>
				</c:otherwise>
			</c:choose>

		</div>
	</div>
</li>