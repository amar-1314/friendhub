<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<link rel="stylesheet" type="text/css" href="resources/css/app.css">
<link rel="stylesheet" type="text/css"
	href="http://fonts.googleapis.com/css?family=PT+Sans">
<script type="text/javascript" src="resources/js/vendor/jquery.js"></script>
<script type="text/javascript" src="resources/js/passwordMatch.js"></script>

<tiles:insertDefinition name="privacySettings">
	<tiles:putAttribute name="body">

<script type="text/javascript" src="resources/js/privacySettings.js"></script>	
			<div class="menuLeft">
			<div>
				<div>
					<img id="profilePicture" alt="Profile Picture"
						src="${user.profilePicutreBase64String}">
				</div>
				<div id = "userNameDiv">
					<label>${user.firstName} </label>
					
				</div>
			</div>
			<div id ="profileNameDiv">
			 <spring:url value="/editProfile" var="Editurl" htmlEscape="true"/>
 <a href="${Editurl}">Edit Profile</a>
				</div>
					<spring:url value="/accountSettings" var="accSett" htmlEscape="true" />
				<a style="color: #000;" href="${accSett}">Account Settings</a><br/>
			<spring:url value="/prvcySettings" var="prvcSett" htmlEscape="true" />
				<a style="color: #000;" href="${prvcSett}">Privacy Settings</a>
			<div>
				<h5>FAVORITES</h5>
				<spring:url value="/home" var="home" htmlEscape="true" />
				<a href="${home}" class="newsFeed">News Feed</a><br>
				<spring:url value="/chat" var="chat" htmlEscape="true" />
				<a href="${chat}" class="messages">Messages</a><br>
				<spring:url value="/addimage" var="image" htmlEscape="true" />
				<a href="${image}" class="images">Images</a><br>
			</div>
			<br>
			<div>
				<h3>CONNECT</h3>
				<a href="contacts" class="iconified">My Contacts</a><br> <a
					href="searchFriends" class="iconified">Connections Search</a><br>
			</div>
			<br>
			<div>
				<h3>CATEGORIES</h3>
				<a href="friends" class="iconified">Friends</a><br> <a
					href="family" class="iconified">Family</a><br> <a
					href="education" class="iconified">Education</a><br> <a
					href="work" class="iconified">Work</a><br>
			</div>


		</div>


		<div class="borderDiv"></div>


		<div id="bodyRight">
			<h2>PRIVACY SETTINGS</h2><br/>
		<!-- 	<h3>Searchable on FriendHub By</h3><br/> -->
			
			<form name="Searchable" method="POST">
				<div class="basicfields_accSett">
				
				
				
				</div>
			
			<form:form name='Privacy_Settings' action='setPrivSet' method='post' accept-charset='UTF-8' commandName='updatePvcySettings'>
			
			<div style="width:400px">
			<h3>Searchable</h3><br/><label>Currently Visible to</label> <form:input path="searchableFlag" id="sf" readOnly='true'/>	<br/>
    			<input type="checkbox" id="switch1" name="switch1" class="switch" />
    			<label for="switch1">Friends only</label>
			</div><br/>
			
			<div class="clear">&nbsp;</div>
			
			<h3>Data Protection</h3><br/>
			<div style="width:400px">
			<label>Profile Picture:</label><br/><label>Currently Visible to</label> <form:input path="profileDataFlag" id="pp" readOnly='true'/>	<br/>
			<input type="checkbox" id="switch2" name="switch2" class="switch" />
    			<label for="switch2">Friends only</label>
			</div><br/>
			<div class="clear">&nbsp;</div>
			
			<div style="width:400px">
			<label>Status:</label><br/><label>Currently Visible to</label> <form:input path="statusFlag" id="stf" readOnly='true'/>	<br/>
			<input type="checkbox" id="switch3" name="switch3" class="switch" />
    			<label for="switch3">Friends only</label>
			</div><br/>
			<div class="clear">&nbsp;</div>
			
			<div style="width:400px">
			<label>Personal Information:</label><br/><label>Currently Visible to</label> <form:input path="profileDataFlag" id="pd" readOnly='true'/>	<br/>
			<input type="checkbox" id="switch4" name="switch4" class="switch" />
    			<label for="switch4">Friends only</label>
			</div><br/>
			<div class="clear">&nbsp;</div>
			
			<h3>Messaging</h3><br/><br/><label>Currently Messageable by</label> <form:input path="messageFlag" id="mf" readOnly='true'/>	<br/>
			<div style="width:400px">
			<input type="checkbox" id="switch5" name="switch5" class="switch" />
    			<label for="switch5">Friends only</label>
			</div><br/>
			<div class="clear">&nbsp;</div>
			
			<h3>Block Users</h3><br/>
			
			
			<input class="centerAlignment" type="submit" value="Apply Changes" class="applyChanges" onclick="makeChanges()">
				
			</form:form>
		</form>
		</div>
	

	</tiles:putAttribute>
</tiles:insertDefinition>
