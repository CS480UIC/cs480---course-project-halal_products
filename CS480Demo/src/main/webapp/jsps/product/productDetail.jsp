<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
	<h3 align="center">Halal Product Detail</h3>
	<div style="text-align: center">
		<form action="<c:url value='/getProductDetail'/>" method="post">
			Region Name :<input type="text" name="region_name" value="${region_name }" />
			<span style="color: red; font-weight: 900">${msg }</span> <br /> <input
				type="submit" value="Search" />
		</form>
	</div>
	&nbsp;
	<table border="1" width="70%" align="center"
		style="background-color: #d3d3d3;">
		<tr>
			<th>Product</th>
			<th>Manufacturer</th>
			<th>Store</th>
			<th>Region</th>
			<th>Certifications</th>
		</tr>
		<c:forEach items="${DetailList}" var="product">
			<tr>
				<td>${product.product_name }</td>
				<td>${product.manufacturer_name }</td>
				<td>${product.store_name }</td>
				<td>${product.region_name }</td>
				<td>${product.certifications }</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>