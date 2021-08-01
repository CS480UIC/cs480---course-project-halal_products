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
		<form action="<c:url value='/getStoreProduct'/>" method="post">
			Product Name :<input type="text" name="product_name" value="${product_name }" />
			Zipcode :<input type="number" name="zipcode" value="${zipcode }" /> <span
				style="color: red; font-weight: 900">${msg }</span> <br /> <input
				type="submit" value="Search" />
		</form>
	</div>
	&nbsp;
	<table border="1" width="70%" align="center"
		style="background-color: #d3d3d3;">
		<tr>
			<th>Zipcode</th>
			<th>Store</th>
			<th>Product</th>
			<th>Address</th>
		</tr>
		<c:forEach items="${DetailList}" var="store">
			<tr>
				<td>${store.zipcode }</td>
				<td>${store.name }</td>
				<td>${store.product_name }</td>
				<td>${store.address }</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>