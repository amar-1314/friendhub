<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<tiles:insertDefinition name="education">
	<tiles:putAttribute name="body">

	<div class="menuLeft">
			<div>
				<div>
					<img id="profilePicture" alt="Profile Picture"
						src="${user.profilePicutreBase64String}">
				</div>
				<div id="userNameDiv">
					<label>${user.firstName} </label>

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
		
		<div id = "educationContactsBlock">
			
				<c:forEach items="${eduFriendList}" var="eduFriendList" varStatus="status">
					<div>
						<div style="float: left; width: 7%; height: 200px;">
							<img id="profilePicture" alt="Profile Picture"
								src="${eduFriendList.friendUserID.profilePicutreBase64String}">
						</div>

					</div>
							
					<div style="width: 40%; height: 200px; float: left;">
						<label>${eduFriendList.friendUserID.firstName}</label>
						<br>
						<img src="resources/images/education.svg" style="width: 30px; height: 30px">
					</div>
					</c:forEach>
			
					
			</div>
		</div>
		
				
				
	
		

	</tiles:putAttribute>
</tiles:insertDefinition>
