<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<tiles:insertDefinition name="uploadPictures">
	<tiles:putAttribute name="body">
	<br>
	
<form:form id="addProfilePicture" action="profilePicture" enctype="multipart/form-data" commandName='uploadPicture'>
<form:label path="profilePicture">Picture</form:label>
        
  <input type="file" name="file" id="file"/><br /><br />
  <input type="submit" value="Upload">
</form:form>

	</tiles:putAttribute>

</tiles:insertDefinition>