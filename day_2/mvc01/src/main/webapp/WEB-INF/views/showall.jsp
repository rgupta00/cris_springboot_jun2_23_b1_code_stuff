<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All bank accounts</title>
</head>
<body>
	<table border=1>
		<thead>
			<tr>
				<th>Account id</th>
				<th>name</th>
				<th>balance</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${accounts}" var="account">
				<tr>
					<td>${account.id }</td>
					<td>${account.name}</td>
					<td>${account.balance}</td>
				</tr>
			</c:forEach>
		</tbody>
</body>
</html>