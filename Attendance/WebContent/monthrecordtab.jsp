<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Overtime</title>
</head>
<body>
	<h1>Overtime record Information</h1>
	<table width="90%" border="2" align="center">
		<tr>
			<td>ID</td>
			<td>出勤月统计</td>
			<td>出差月统计</td>
			<td>加班月统计</td>
			<td>请假月统计</td>
		</tr>
		<c:forEach items="${projectList }" var="list">
			<tr>
				<td>${list.e_id }</td>
				<td>${list.work_note_month }</td>
				<td>${list.out_note_month }</td>
				<td>${list.over_note_month }</td>
				<td>${list.off_note_month }</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>