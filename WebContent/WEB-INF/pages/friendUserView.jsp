<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<tiles:insertDefinition name="friendView">
	<tiles:putAttribute name="body">

<div class="menuLeft">
			<div>
				<div>
					<img style="width: 102px; height: 120px;" id="profilePicture" alt="Profile Picture"
						src="${user.profilePicutreBase64String}">
				</div>
				<div id="userNameDiv">
					<label>${user.firstName}</label>
				</div>
			</div>
			<div id="profileNameDiv">
				<spring:url value="/editProfile" var="Editurl" htmlEscape="true" />
				<a href="${Editurl}">Edit Profile</a>
			</div>
			<spring:url value="/accountSettings" var="accSett" htmlEscape="true" />
			<a href="${accSett}">Account Settings</a><br />
			<spring:url value="/prvcySettings" var="prvcSett" htmlEscape="true" />
			<a href="${prvcSett}">Privacy Settings</a>
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
				<spring:url value="/list" var="list" htmlEscape="true" />
				<a href="${list}">List Users</a><br>
				<spring:url value="/workProfile" var="workProfile" htmlEscape="true" />
				<a href="${workProfile}">Work Profile</a><br>
			</div>
		</div>
		<div class="borderDiv"></div>

		<div id="bodyRight">

<form id="friendDetails" method="post" action="adduser"  class="basicfields">

<input name="userID" type="hidden" id="friendUserID" value="${friendUser.userID}"/>	
<div id="addfriend">

<c:choose>
<c:when test="${showVal == 1}">
<input type="submit" value="ADD FRIEND">
<br>
<br>
 <label>Select Category </label><select name="itemCategory"> 
    <option value="1">Friends</option>
    <option value="2">Work</option>
    <option value="3">Education</option>
     <option value="4">Family</option>
  </select>
  <br>
</c:when>
<c:when test="${showVal == 0}">
<input type="submit" value="UNFRIEND">
</c:when>

</c:choose>
<br>
<div id="profileDetails">	
<label>First name:	</label><span> ${friendUser.firstName}  </span>
<br>
<label>Middle name:	</label>${friendUser.middleName}  
<br>   
<label>Last name: </label> <span> ${friendUser.lName}  </span>
<br>
<label>Phone number:</label> <span>  ${friendUser.phoneNumber}</span>
<br>
<label>Birthday : </label><span> ${friendUser.dob} </span>
<br>
<label>Gender : </label> <span>${friendUser.gender} </span>
<br>
<label>Address:</label> <span>${friendUser.addressLine1} </span>
<br>
<label>Street:</label><span> ${friendUser.addressLine2} </span>
<br>
<label>City:</label><span> ${friendUser.city} </span>
<br>
<label>State:</label><span>   ${friendUser.state}</span> 
<br>
</div>		
</div>
</form>



			
			
			</div>


	</tiles:putAttribute>
</tiles:insertDefinition>