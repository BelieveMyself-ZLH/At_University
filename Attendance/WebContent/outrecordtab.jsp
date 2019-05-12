<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Out record</title>
</head>
<body>
	<h1>Out record Information</h1>
	<table width="90%" border="2" align="center">
		<tr>
			<td>ID</td>
			<td>出差编号</td>
			<td>开始时间</td>
			<td>返回时间</td>
			<td>统计天数</td>
		</tr>
		<c:forEach items="${projectList }" var="list">
			<tr>
				<td>${list.e_id }</td>
				<td>${list.out_num }</td>
				<td>${list.out_time }</td>
				<td>${list.back_time }</td>
				<td>${list.out_days }</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>