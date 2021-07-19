<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>Add Store</title>

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
			<c:when test="${store.id == 0}">
				<%text = "Add";%>
			</c:when>
			<c:otherwise>
				<%text = "Update";%>
			</c:otherwise>
		</c:choose>
	</display:column>
	<h1><%=text%>
		Store
	</h1>
	<p style="color: red; font-weight: 900">${msg }</p>
	<form action="<c:url value='/addStore'/>" method="post">
		<input type="hidden" name="id" value="${store.id }" /> Name :<input
			type="text" name="name" value="${store.name }" /> <span
			style="color: red; font-weight: 900">${errors.name }</span> <br />
		Address :<input type="text" name="address" value="${store.address }" />
		<span style="color: red; font-weight: 900">${errors.address }</span> <br />
		Zipcode :<input type="text" name="zipcode" value="${store.zipcode }" />
		<span style="color: red; font-weight: 900">${errors.name }</span> <br />
		Region : <select name="region">
			<c:forEach var="item" items="${listregion}">
				<option value="${item.id}"
					${item.id == store.region_id ? 'selected="selected"' : ''}>${item.name}</option>
			</c:forEach>
		</select><br /> <input type="submit" value="<%=text%>" />
	</form>
</body>
</html>