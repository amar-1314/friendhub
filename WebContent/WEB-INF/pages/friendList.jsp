<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:forEach items="${friendlistAutoComplete}" var="friend" varStatus="status">
	<div>
		<div style="float: left; width: 7%; height: 200px;">
			<img id="profilePicture" alt="Profile Picture"
				src="${friend.friendUserID.profilePicutreBase64String}">
		</div>

	</div>
	<form name="friendListDetails" action="getFriendProfile" method="post">
		<div style="width: 40%; height: 200px; float: left;">
			<input type="hidden" name="userIdField"
				value="${friend.friendUserID.userID}" /> <a
				href="javaScript:void(0);" onclick="loadUserProfileAjax(this)">${friend.friendUserID.firstName}</a>
			<br> <label style="color: #A9A9A9">friends</label>
		</div>
	</form>
</c:forEach>