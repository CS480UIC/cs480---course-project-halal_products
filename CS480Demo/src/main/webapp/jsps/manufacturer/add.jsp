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
	<h1>Add Manufacturer</h1>
	<p style="color: red; font-weight: 900">${msg }</p>
	<form action="<c:url value='/add'/>" method="post">
		<input type="hidden" name="method" value="regist" /> Name :<input
			type="text" name="name" value="${manufacturer.name }" /> <span
			style="color: red; font-weight: 900">${errors.name }</span> <br />
		<input type="submit" value="Add" />
	</form>
</body>
</html>