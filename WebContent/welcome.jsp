<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome</title>
</head>
<body>

	<div align="center">
		<c:if test="${gender =='M' }">Benvenuto ${username}</c:if>
		<c:if test="${gender =='F' }">Benvenuta ${username}</c:if>
		<br>
		Ultimo accesso ${last_login}
		
		<form action="logout" method="GET">
			<input type="submit" value="Logout">
		</form>
	</div>
</body>
</html>