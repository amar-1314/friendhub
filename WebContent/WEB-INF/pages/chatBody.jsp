<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<ul id="messageList" class="media-list messageList">
			<c:forEach items="${messageList}" var="messages">
				<li class="media">
					<div class="media-body">
						<div class="media">
							<a class="pull-left" href="#"> <img
								class="media-object img-circle "
								style="height: 40px; width: 40px;"
								src="${messages.senderID.profilePicutreBase64String}" />
							</a>
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