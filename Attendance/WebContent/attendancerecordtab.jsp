<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Attendance</title>
</head>
<body>
	<h1>Attendance record Information</h1>
	<table width="90%" border="2" align="center">
		<tr>
			<td>ID</td>
			<td>出勤编号</td>
			<td>上时间</td>
			<td>下班时间</td>
			<td>缺勤记录</td>
		</tr>
		<c:forEach items="${projectList }" var="list">
			<tr>
				<td>${list.e_id }</td>
				<td>${list.e_num }</td>
				<td>${list.work_time }</td>
				<td>${list.end_time }</td>
				<td>${list.work_note }</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>