<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<tiles:insertDefinition name="workDetails">
	<tiles:putAttribute name="body">
		<div class="menuLeft">


			<div>
				<h5>UPDATE DETAILS</h5>
				<spring:url value="/workDetails" var="Workdetailsurl"
					htmlEscape="true" />
				<a href="${Workdetailsurl}">Work details</a> <br>
				<spring:url value="/educationDetails" var="Educationaldetailsurl"
					htmlEscape="true" />
				<a href="${Educationaldetailsurl}">Educational details</a>
			</div>
			<br>
		</div>
		<div class="borderDiv"></div>
		<div id="bodyRight">


			<button class="add_field_button">Add Work Details</button>
			
			<div class="input_fields_wrap1">
			<c:forEach items="${workDetailsList}" var="workDetail">

				<form id="${workDetail.work_ProfileID}">
					<input value="${workDetail.userID.userID}" type="hidden" name="userID" />
					<div class="input_fields_wrap">

						<br> <br>

						<div class="basicfields">
							<label>Company Name:</label><span><input name="companyName" type="text" value="${workDetail.companyName}" size="35"/></span>
						</div>
						<br>
						<div style="width: 140%">
							<div class="basicfields">
								<label>From:</label><span><input name="fromDate" type="date" value="${workDetail.fromDate}"/></span> <label >To:</label><input
									type="date" name="toDate" value="${workDetail.toDate}"/>

							</div>
						</div>
						<input type="button" onclick="workDetailsUpdate(this)" 
							value="Save Changes">
					</div>
				</form>
			</c:forEach>
         </div>
		</div>
	</tiles:putAttribute>

</tiles:insertDefinition>
