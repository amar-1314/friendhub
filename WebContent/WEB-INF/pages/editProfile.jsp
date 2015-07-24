<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<tiles:insertDefinition name="editProfile">
	<tiles:putAttribute name="body">

			<div class="menuLeft">
			
			
			<div>
				<h5>UPDATE DETAILS</h5>
				<br>
				<br>
				
		<form>		 
    <div>
       
					<img src="${user.profilePicutreBase64String}" alt="Profile Picture" width="102px" height="120px">
						
					
   </div>
   </form>
   <br>
   <br>
 <spring:url value="/workDetails" var="Workdetailsurl" htmlEscape="true"/>
 <a href="${Workdetailsurl}">Work details</a>
 <br>
 <spring:url value="/educationDetails" var="Educationaldetailsurl" htmlEscape="true"/>
 <a href="${Educationaldetailsurl}">Educational details</a>
 <br>
 <spring:url value="/profilePicture" var="profilePictureurl" htmlEscape="true"/>
 <a href="${profilePictureurl}">Profile picture</a>
 <br>
			</div>
			<br>
			</div>
<div class="borderDiv"></div>
<div id="bodyRight">
<form:form id="basicDetails" method="post" action="editProfile" commandName='editProfileForm' class="basicfields">

<form:input path="userID" type="hidden" id="userID" size="40" maxlength="40" required="true" />

<label>First name:</label><span> <form:input path="firstName" type="text" id="firstname" pattern="[A-Za-z-]+" title="Alphabets only"   size="40" maxlength="40" required="true" /> </span>
<br>
<br>
<label>Middle name:</label><span> <form:input path="middleName" type="text" id="middlename" pattern="[A-Za-z-]+" title="Alphabets only"  size="40" maxlength="40"/></span>
<br>
<br>
<form:input type="hidden" path="addressLine2" id="picString"/>
<label>Last name: </label><span> <form:input path="lName" type="text" id="lastname" size="40" pattern="[A-Za-z-]+" title="Alphabets only"  maxlength="40" required="true"/></span>
<br>
<br>
<label>Phone number:</label> <span> <form:input path="phoneNumber" type="text" id="phonenumber" pattern="[0-9-]+" title="Numbers only" size="10" maxlength="10"/> </span>
<br>
<br>
<label>Birthday : </label><span><form:input path="dob" type="date" name="birthday" max="2000-12-31" min="1930-12-31"/> </span>
<br>
<br>
<label>Gender : </label> <span><form:radiobutton path="gender" name="sex" value="M"/>Male
<form:radiobutton path="gender" name="sex" value="F"/>Female </span>
<br>
<br>
<label>Address:</label>
<br>
<br>
<label>Street:</label><span> <form:input path="addressLine1" type="text" name="street" size="40"/></span>
<br>
<br>
<label>City:</label><span><form:input path="city" type="text" id="city" pattern="[A-Za-z-]+" title="Alphabets only" size="40"/></span>
<br>
<br>
<label>State:</label><span><form:input path="state" type="text" id="state" pattern="[A-Za-z-]+" title="Alphabets only" size="40"/></span>
<br>
<br>
<label>Country:</label><span><form:input path="country" type="text" id="state" pattern="[A-Za-z-]+" title="Alphabets only" size="40"/></span>
<br>
<br>
<label>Pin code:</label> <span><form:input path="zip" type="text" id="zipcode" pattern="[0-9-]+" title="Numbers only" size="5"/></span>
<br>
<br>
<input type="submit" value="Save Changes">
</form:form>

</div>

	</tiles:putAttribute>
</tiles:insertDefinition>
