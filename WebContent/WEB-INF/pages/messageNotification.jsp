<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%-- <c:forEach items="${notificationsList}" var="notification">
	<li><spring:url value="/chat" var="chat" htmlEscape="true" /><a id="${notification.senderID.userID}" href="${chat}" onclick="showChatWindow(this)">You have ${notification.count} new messages from ${notification.senderID.firstName}</a></li>
	<li><a id="${notification.senderID.userID}"
		href="javascript:void(0)" onclick="loadChatWindowForfriend(this)">You
			have ${notification.count} new messages from
			${notification.senderID.firstName}</a></li>
</c:forEach>
 --%>
<img src="resources/images/message.svg" class="icons dropdown-toggle"
	data-toggle="dropdown">
<c:if test="${fn:length(notificationsList) gt 0}">

	<span class="badge">${fn:length(notificationsList)}</span>
	<ul id="msgNotification" class="dropdown-menu" role="menu">
		<c:forEach items="${notificationsList}" var="notification">
			<li><a id="${notification.senderID.userID}"
				href="javascript:void(0)" onclick="loadChatWindowForfriend(this)">You
					have ${notification.count} new messages from
					${notification.senderID.firstName}</a></li>
		</c:forEach>
	</ul>
</c:if>