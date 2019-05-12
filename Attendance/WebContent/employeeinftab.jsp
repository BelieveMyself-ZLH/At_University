<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Employee</title>
</head>
<body>
	<h1>Employee Information</h1>
	
	<table width="90%" border="2" align="center">
		<tr>
			<td>ID</td>
			<td>姓名</td>
			<td>性别</td>
			<td>年龄</td>
			<td>手机</td>
			<td>email</td>
			<td>部门ID</td>
		</tr>
		<c:forEach items="${projectList }" var="list">
			<tr>
				<td>${list.e_id }</td>
				<td>${list.e_name }</td>
				<td>${list.e_sex }</td>
				<td>${list.e_age }</td>
				<td>${list.e_phone }</td>
				<td>${list.e_email }</td>
				<td>${list.departmentId }</td>
			</tr>
		</c:forEach>
	</table>
	<h2>
		<c:choose>
			<c:when test="${page gt 1 }"><a href="employee.action?page=${page-1 }">上一页</a></c:when>
			<c:otherwise>上一页</c:otherwise>
		</c:choose>
		|第
		${page }
		页|
		<a href="employee.action?page=1">1</a>
		<a href="employee.action?page=2">2</a>
		<a href="employee.action?page=3">3</a>
		<a href="employee.action?page=4">4</a>
		<a href="employee.action?page=5">5</a>
		<a href="">...</a>
		<c:choose>
			<c:when test="${page lt totalPage }"><a href="employee.action?page=${page+1 }">下一页</a></c:when>
			<c:otherwise>下一页</c:otherwise>
		</c:choose>
	</h2>
</body>
</html>