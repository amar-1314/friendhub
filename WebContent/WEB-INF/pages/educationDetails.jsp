<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<tiles:insertDefinition name="educationDetails">
	<tiles:putAttribute name="body">
	<div class="menuLeft">
			
			
			<div>
				<h5>UPDATE DETAILS</h5>
 <spring:url value="/workDetails" var="Workdetailsurl" htmlEscape="true"/>
 <a href="${Workdetailsurl}">Work details</a>
 <br>
 <spring:url value="/educationDetails" var="Educationaldetailsurl" htmlEscape="true"/>
 <a href="${Educationaldetailsurl}">Educational details</a>
			</div>
			<br>
			</div>
<div class="borderDiv"></div>
<div id="bodyRight">

<button class="add_educationalfield_button">Add Educational Details</button>
<div class="input_fields_wrap1">
<c:forEach items="${educationDetailsList}" var="educationDetail">
              <form id="${educationDetail.education_profile_ID}">
              
              <input value="${educationDetail.userID.userID}" type="hidden" name="userID" />
				<div class="input_educationalfields_wrap">
					
					<br> <br>

					<div class="basicfields">
						<label>College Name:</label><span><input type="text" name="collegeName" value="${educationDetail.collegeName}" size="35"/></span>
					</div>
					       <br>
						<div style="width: 140%">
						<div class="basicfields">
							<label>From:</label><span><input type="date" name="fromDate" value="${educationDetail.fromDate}"/></span>
							
						<label id = "to-label">To:</label><input type="date" name="toDate" value="${educationDetail.toDate}"/>
		
					   </div>
					   </div>
					   
					   <input type="button" onclick="educationDetailsUpdate(this)" 
							value="Save Changes">
				</div>
			</form>
			</c:forEach>
			</div>
</div>
</tiles:putAttribute>

</tiles:insertDefinition>
