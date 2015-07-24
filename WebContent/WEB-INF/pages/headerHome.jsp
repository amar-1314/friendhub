<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="header-div">

	<div class="left-div">
		<spring:url value="/home" var="homeUrl" htmlEscape="true" />
		<h2>
			<a href="${homeUrl}">FriendHub</a>
		</h2>
	</div>


	<div id="notificationBar">
		<img src="resources/images/friend.svg" class="icons">

		<div id="msgNotification" class="btn-group show-on-hover">
			<img src="resources/images/message.svg" class="icons dropdown-toggle"
				data-toggle="dropdown">
		</div>
		<img src="resources/images/notification.svg" class="icons">







	</div>

	<div style="float: right; width: 70%">
		<label style="color: #E1D8B7;" for="globalSearchBar">Search: </label> <input
			id="globalSearchBar" onfocus="onGlobalPeopleSearch()">
		<button id="globalPeopleSearch" onclick="onClickGlobalPeopleSearch()">
			<img src="resources/images/search.svg"
				style="width: 15px; height: 15px">
		</button>
		<spring:url value="/logoutSuccess" var="logoutUrl" htmlEscape="true" />
		<a style="padding-left: 440px" href="${logoutUrl}">Logout</a>



	</div>






</div>

