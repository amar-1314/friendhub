<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 <title>FriendHub</title>
<link rel="stylesheet" type="text/css" href="resources/css/bootstrap.css" />
<link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
<link rel="stylesheet" type="text/css" href="resources/css/app.css"/>
<link rel="stylesheet" type="text/css" href="http://fonts.googleapis.com/css?family=PT+Sans	"/>
<script type="text/javascript" src="resources/js/vendor/jquery.js"> </script>
<script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
<script type="text/javascript" src="resources/js/passwordStrength.js"></script>
<script type="text/javascript" src="resources/js/passwordMatch.js"></script>
<script type="text/javascript" src="resources/js/workDetails.js"></script>
<script type="text/javascript" src="resources/js/educationDetails.js"></script>
<script type="text/javascript" src="resources/js/validations.js"></script>
<script type="text/javascript" src="resources/js/app.js"> </script>
<script type="text/javascript" src="resources/js/script.js"> </script>

</head>
<body >
		<tiles:insertAttribute name="header" />
			<div id="wrapperDiv">
				<tiles:insertAttribute name="body" />
			</div>
		<tiles:insertAttribute name="footer" />
</body>
</html>