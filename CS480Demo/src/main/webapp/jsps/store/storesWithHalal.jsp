<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
	<h3 align="center">Stores With Halal Products</h3>
	<table border="1" width="70%" align="center"
		style="background-color: #d3d3d3;">
		<tr>
			<th>Name</th>
			<th>Address</th>
			<th>Zipcode</th>
			<th>Region</th>
			
		</tr>
		<c:forEach items="${StoreList}" var="store">
			<tr>
				<td>${store.name }</td>
				<td>${store.address }</td>
				<td>${store.zipcode }</td>
				<td>${store.region_name }</td>
				
			</tr>
		</c:forEach>
	</table>


</body>
</html>