<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<tiles:insertDefinition name="addPicture">
	<tiles:putAttribute name="body">
	<br>
	
	<form id="addphotos" method="post" action="addpicture">
  <input type="file" name="photos"><br /><br />
  <input type="submit" name="submit" value="Submit">
</form>

	</tiles:putAttribute>
</tiles:insertDefinition>