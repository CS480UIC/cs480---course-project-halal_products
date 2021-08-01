<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
	<h3 align="center">List of Halal Products - Unavailable at Stores</h3>
	<div style="text-align: center">
		
	</div>
	&nbsp;
	<table border="1" width="70%" align="center"
		style="background-color: #d3d3d3;">
		<tr>
			<th>product_name</th>
			<th>category_name</th>
			<th>manufacturer_name</th>
			<th>halal_status</th>
			
			
		</tr>
		<c:forEach items="${ProductList}" var="product">
			<tr>
				<td>${product.product_name }</td>
				<td>${product.category_name }</td>
				<td>${product.manufacturer_name }</td>
				<td>${product.halal_status }</td>
				
				
			</tr>
		</c:forEach>
	</table>
</body>
</html>