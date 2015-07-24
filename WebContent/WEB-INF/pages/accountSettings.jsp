<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<link rel="stylesheet" type="text/css" href="resources/css/app.css">
<link rel="stylesheet" type="text/css"
	href="http://fonts.googleapis.com/css?family=PT+Sans">
<script type="text/javascript" src="resources/js/vendor/jquery.js"></script>
<script type="text/javascript" src="resources/js/passwordMatch.js"></script>

<tiles:insertDefinition name="accountSettings">
	<tiles:putAttribute name="body">
	<script type="text/javascript" src="resources/js/passwordStrength.js"></script>
	

	<script type="text/javascript" src="resources/js/accountSettings.js"></script>
		<div class="menuLeft">
			<div>
				<div>
					<img id="profilePicture" alt="Profile Picture"
						src="${updateAccSettings.profilePicutreBase64String}">
				</div>
				<div id="userNameDiv">
					<label>${updateAccSettings.firstName} </label>

				</div>
			</div>
			<div id="profileNameDiv">
				<spring:url value="/editProfile" var="Editurl" htmlEscape="true" />
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
			<h2>ACCOUNT SETTINGS</h2>
			<br />
			
			<h3>Security Question and Answer</h3>
			<br />

			<form:form name='Security_Q_A' action='getHome' method='post' accept-charset='UTF-8' commandName='updateAccSettings'>
				<form:input path="emailID" type="hidden" id="hiddenEmail" />
				<div class="basicfields_accSett">
					<label>Select a Security Question: </label> 
					<span><form:input path="securityQuestion"
						type="text" name="securityQues" id="secQues" size="40" maxlength="45"
						placeholder="Your Custom Ques" readonly="true"/></span>

				</div>
				<br />
				<br />
				<div class="basicfields_accSett">
					<label>Answer to the Security Question:</label><span><form:input path="securityAnswer"
						type="text" name="securityAnswer" id="secAns" size="40" maxlength="20"
						placeholder="Your Answer" required="true" readonly="true"/></span>
				</div>
				<br />
				<input type="button" value="Edit" onclick="editSecQuesAns()">
				<input type="button" value="Apply" onclick="updateSecQuesAns()">
				<label id=SecStatus></label>


				<div style="width: 400px">
					<h3>2 Factor Authentication</h3>
					<br /> <label> Enable/Disable 2 Factor Authentication:</label> <input
						type="checkbox" id="switch1" name="switch1" class="switch" /> <label
						for="switch1">Enable</label>
				</div>
				<br />
				<input type="button" value="Apply" onclick="update2FactorAuth()">
				<label id=TwoFacStatus></label>
			
		
				<div class="clear">&nbsp;</div>
				<h3>Change Password</h3>
				<br />
				<div class="basicfields_accSett">
					<label>Enter Current Password:</label><input type="password"
						name="CurrentPassword" id="currPwd" maxlength="32" size="40"
						placeholder="Maximum 32 charachters"><br /><label id=pwdResult></label>
						<input type="button" value="Verify" onclick="verifyPassword()"/>
					<br /> <label>Enter New Password :</label> <input
						 type="password" id="inputPassword" pattern=".{8,}" title="Minimum 8 charachters"
						name="NewPassword" maxlength="32" size="40" 
						placeholder="Maximum 32 charachters" readOnly>
					<div class="default" id="complexity"></div><br/>
					<label>Re-Enter
					Password</label><input style="position: relative; margin-left: 10px"
					type="password" id="reEnterPassword" maxlength="32" readOnly
					onkeyup="matchPass()"> <span id="confirmMessage"
					class="confirmMessage"></span>
				</div>
				<input type="button" value="Apply" id="changePassword" disabled onclick="updatePassword()">
				
				<div style="width: 450px">
					<h3>Deactivate My Account</h3>
					<label>Your profile will not be visible to other users</label> <input
						style="float: right" type="button" value="Yes.Deactivate" onClick="deactUser()">
						<label id="deactStatus"></label>
				</div>
				<div style="width: 450px">
					<br />
					<h3>Delete My Account</h3>
					<label>This is permanent. </label> <input style="float: right"
						type="button" value="Yes.Delete"><br />
					<br />
				</div>
					<input type="submit" value="OK.Done" class="applyChanges" onclick="makechanges()">
			</form:form>

		</div>


	</tiles:putAttribute>
</tiles:insertDefinition>
