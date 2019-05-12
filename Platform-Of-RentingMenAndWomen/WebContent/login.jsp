<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%
	String path=request.getContextPath();
	String basePath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<base href="<%=basePath %>">
	<title>用户登录</title>
	<meta content="no-cache" http-equiv="pragma">
	<meta content="no-cache" http-equiv="cache-control">
	<meta content="0" http-equiv="expires">
	<meta content="keyword1,keyword2,keyword3" http-equiv="keyword">
	<meta content="This is my page" http-equiv="description">
	<style type="text/css">
		body {position:center;}
	</style>
</head>
<body background="./images/2.jpg">
	<center>
		<font size="8">用户登录</font>
		<hr/>
		<form action="validate.jsp" method="post">
			&nbsp;用户名称：<input type="text" name="username">
		<br/>
		<br/>
			用户密码：<input type="password" name="password">
			<br/>
			<br/>
			<input type="submit" value="登录">
		</form>
	</center>
</body>
</html>