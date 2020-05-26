<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="CarroServlet" method="post">
		<input type="submit" value="Listar Carros">
		<c:forEach items="${ lista }" var="nome">
		<p>${ nome }</p>
	</form>
</body>
</html>