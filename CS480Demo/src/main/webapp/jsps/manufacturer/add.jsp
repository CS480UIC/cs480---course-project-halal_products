<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>Add Manufacturer</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<meta http-equiv="content-type" content="text/html;charset=utf-8">
</head>
<body>
	<%String text = "Add";%>
	<display:column>
		<c:choose>
			<c:when test="${empty manufacturer.id}"><%text = "Add";%></c:when>
			<c:when test="${manufacturer.id == 0}"><%text = "Add";%></c:when>
			<c:otherwise><%text = "Update";%></c:otherwise>
		</c:choose>
	</display:column>
	<h1><%=text%> Manufacturer</h1>
	<p style="color: red; font-weight: 900">${msg }</p>
	<form action="<c:url value='/add'/>" method="post">
		<input type="hidden" name="id" value="${manufacturer.id }" /> Name :<input
			type="text" name="name" value="${manufacturer.name }" required/> <span
			style="color: red; font-weight: 900">${errors.name }</span> <br /> <input
			type="submit" value="<%=text%>" />
	</form>
</body>
</html>