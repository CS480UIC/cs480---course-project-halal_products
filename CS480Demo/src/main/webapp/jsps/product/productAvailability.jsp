<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
	<h3 align="center">Store Products</h3>
	<div style="text-align: center">
		<form action="<c:url value='/ProductAvailability'/>" method="post">
			Region : <select name="region">
				<option value="">No Selection</option>
				<c:forEach var="item" items="${listregion}">
					<option value="${item.id}"
						${item.id == region_id ? 'selected="selected"' : ''}>${item.name}</option>
				</c:forEach>
				<span style="color: red; font-weight: 900">${msg }</span>
				<br />
				<input type="submit" value="Search" />
		</form>
	</div>
	&nbsp;
	<table border="1" width="70%" align="center"
		style="background-color: #d3d3d3;">
		<tr>
			<th>Region</th>
			<th>Availability</th>
			<th>Store</th>
			<th>Product</th>
			<th>Manufacturer</th>
		</tr>
		<c:forEach items="${DetailList}" var="store">
			<tr>
				<td>${store.region_name }</td>
				<td>${store.availability }</td>
				<td>${store.store_name }</td>
				<td>${store.product_name }</td>
				<td>${store.manufacturer_name }</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>