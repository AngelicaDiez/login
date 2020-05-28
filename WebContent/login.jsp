<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
	<h1 align="center">LOGIN</h1>

	<div align="center">
		
		<form action="verify" method="post">
			<table>

				<tr>
					<td>Username</td>
					<td><input type="text" name="username"></td>
				</tr>
				<tr>
					<td>Password</td>
					<td><input type="password" name="password"></td>
				</tr>
				<tr>
					<td colspan=2 align="center"><input type="submit" value="Login"></td>
				</tr>

			</table>
		</form>
		<c:if test="${not empty msg}"> ${msg} </c:if>
	</div>
</body>
</html>