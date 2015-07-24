<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<tiles:insertDefinition name="allusers">
	<tiles:putAttribute name="body">

		<div class="menuLeft">
			<div>
				<div>
					<img id="profilePicture" alt="Profile Picture"
						src="">
				</div>
				<div id="userNameDiv">
					<label>User Name </label>

				</div>
			</div>
			<div id="profileNameDiv">
				<spring:url value="/editProfile" var="Editurl" htmlEscape="true" />
				<a href="${Editurl}">Edit Profile</a>
			</div>
			<div>
				<h5>FAVORITES</h5>
				<spring:url value="/home" var="home" htmlEscape="true" />
				<a href="${home}" class="newsFeed">News Feed</a><br> <a
					href="messages" class="messages">Messages</a><br>
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
					href="family" class="iconified">Family</a><br> <a
					href="education" class="education">Education</a><br> <a
					href="work" class="work">Work</a><br>
			</div>


		</div>


		<div class="borderDiv"></div>


		<div id="bodyRight">


			
			<br> <br> <br> <input type="hidden" id="friendNames"
				value="${friendNames}" />

			<div id="contactsBlock">


				<c:forEach items="${alluserlist}" var="alluserlist" varStatus="status">
					<div>
						<div style="float: left; width: 7%; height: 200px;">
							<img id="profilePicture" alt="Profile Picture"
								src="${alluserlist.profilePicutreBase64String}">
						</div>

					</div>
					<form name="friendListDetails" action="getFriendProfile"
						method="post">
						<div style="width: 40%; height: 200px; float: left;">
							<input type="hidden" name="userIdField"
								value="${alluserlist.userID}" /> <a
								href="javaScript:void(0);" onclick="loadUserProfileAjax(this)">${alluserlist.firstName}</a>
							<br> <%-- <label style="color: #A9A9A9">${friendCount[status.index]}
								friends</label> --%>
						</div>
					</form>
				</c:forEach>

			</div>

		</div>





	</tiles:putAttribute>
</tiles:insertDefinition>
