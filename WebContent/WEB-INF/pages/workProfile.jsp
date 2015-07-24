<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<tiles:insertDefinition name="workProfileTemplate">
	<tiles:putAttribute name="body">
	<div>
	
<table>
		<c:forEach items="${workProfile}" var="workProfile">
			<tr>
			<td>${workProfile.work_ProfileID}</td>
			<td>${workProfile.companyName}</td>
			<td>${workProfile.fromDate}</td>
			<td>${workProfile.toDate}</td>
			</tr>
		</c:forEach>
	</table>
	</div>
</tiles:putAttribute>
</tiles:insertDefinition>