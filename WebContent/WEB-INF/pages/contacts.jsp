<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<tiles:insertDefinition name="contacts">
	<tiles:putAttribute name="body">

		<div class="menuLeft">
			<div>
				<div>
					<img style="width: 102px; height: 120px;" id="profilePicture" alt="Profile Picture"
						src="${user.profilePicutreBase64String}">
				</div>
				<div id="userNameDiv">
					<label> ${user.firstName} </label>

				</div>
			</div>
			<div id="profileNameDiv">
				<spring:url value="/editProfile" var="Editurl" htmlEscape="true" />
				<a href="${Editurl}">Edit Profile</a>
			</div>
			<div>
				<h5>FAVORITES</h5>
				<spring:url value="/home" var="home" htmlEscape="true" />
				<a href="${home}" class="newsFeed">News Feed</a><br>
				<spring:url value="/chat" var="chat" htmlEscape="true" />
				<a href="${chat}" class="messages">Messages</a><br>
			</div>
			<br>
			<div>
				<h5>CONNECT</h5>
				<a href="contacts" class="contacts">My Contacts</a><br>
			</div>
			<br>
			<div>
				<h5>CATEGORIES</h5>
				<a href="friends" class="friends">Friends</a><br> <a
					href="family" class="family">Family</a><br> <a
					href="education" class="education">Education</a><br> <a
					href="work" class="work">Work</a><br>
			</div>


		</div>


		<div class="borderDiv"></div>


		<div id="bodyRight">


			<div style="float: right; width: 70%">
				<label for="contactSearchBar">Search in Contacts: </label> <input
					onfocus="onSearch()" id="contactSearchBar">
				<button id="contactsSearchButton" onclick="onClickSearch()">
					<img src="resources/images/search.svg"
						style="width: 15px; height: 15px">

				</button>

			</div>
			<br> <br> <br> <input type="hidden" id="friendNames"
				value="${friendNames}" />

			<div id="contactsBlock">


				<c:forEach items="${friendList}" var="friendList" varStatus="status">
					<div>
						<div style="float: left; width: 7%; height: 200px;">
							<img id="profilePicture" alt="Profile Picture"
								src="${friendList.friendUserID.profilePicutreBase64String}">
						</div>

					</div>
					<form name="friendListDetails" action="getFriendProfile"
						method="post">
						<div style="width: 40%; height: 200px; float: left;">
							<input type="hidden" name="userIdField"
								value="${friendList.friendUserID.userID}" /> <a
								href="javaScript:void(0);" onclick="loadUserProfileAjax(this)">${friendList.friendUserID.firstName}</a>
							<br> <label style="color: #A9A9A9">${friendCount[status.index]}
								friends</label>
						</div>
					</form>
				</c:forEach>

			</div>

		</div>





	</tiles:putAttribute>
</tiles:insertDefinition>
