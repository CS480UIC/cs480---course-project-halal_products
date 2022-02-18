<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
	<h3 align="center">Region Table</h3>
	<div style="text-align: center">
		<a align="center" href="<c:url value='/jsps/region/add.jsp'/>" target="body">Add
			Region</a>
	</div>
	&nbsp;
	<table border="1" width="70%" align="center"
		style="background-color: #d3d3d3;">
		<tr>
			<th>Name</th>
			<th>Actions</th>
		</tr>
		<c:forEach items="${RegionList}" var="region">
			<tr>
				<td>${region.name }</td>
				<td><a href="<c:url value='/deleteRegion?id=${region.id }'/>"
					target="body">Delete</a> |&nbsp; <a
					href="<c:url value='/addregion?id=${region.id }'/>"
					target="body">Update</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>