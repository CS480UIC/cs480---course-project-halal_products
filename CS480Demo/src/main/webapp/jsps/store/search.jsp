<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>Search Store</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<meta http-equiv="content-type" content="text/html;charset=utf-8">
</head>
<body>
	<%String text = "Search ";%>
	<p style="color: red; font-weight: 900">${msg }</p>

	<form action="<c:url value='/searchStore'/>" method="post">
		Search by Region : <select name="region">
			<c:forEach var="item" items="${listregion}">
				<option value="${item.id}"
					${item.id == store.region_id ? 'selected="selected"' : ''}>${item.name}</option>
			</c:forEach>
		</select><br /> <input type="submit" value="Search By Region" name="button" />

		<br> <br> Name :<input type="text" name="name"
			value="${store.name }" /> <span style="color: red; font-weight: 900">${errors.name }</span>
		<input type="submit" value="Search By StoreName" name="button" /> <br />
		<br> <br> Search by Zipcode :<input type="text" name="zip"
			value="${store.zipcode }" /> <span
			style="color: red; font-weight: 900">${errors.zipcode }</span> <input
			type="submit" value="Search By Zip" name="button" /> <br> <br>


		<table border="1" width="70%" align="center"
			style="background-color: #d3d3d3;">
			<tr>
				<th>Name</th>
				<th>Address</th>
				<th>Zipcode</th>
				<th>Region Name</th>

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
	</form>
</body>
</html>