<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<tiles:insertDefinition name="profilePicture">
	<tiles:putAttribute name="body">
	<br>
	
<form:form id="addProfilePicture" action="profilePicture" enctype="multipart/form-data"  commandName='editProfilePicture'>
<form:label path="profilePicture">Picture</form:label>
        
  <input type="file" name="file" accept="image/jpeg" id="file"/><br /><br />
  <input type="submit" value="Upload">
</form:form>

	</tiles:putAttribute>

</tiles:insertDefinition>
