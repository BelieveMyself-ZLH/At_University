<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>success.jsp</title>
	<meta content="no-cache" http-equiv="pragma">
	<meta content="no-cache" http-equiv="cache-control">
	<meta content="0" http-equiv="expires">
	<meta content="keyword1,keyword2,keyword3" http-equiv="keyword">
	<meta content="This is my page" http-equiv="description">
</head>
<%!
	Map<String,String> map = new HashMap<String,String>();
	boolean flag=false;
%>
<%
	map.put("John","123456");
	map.put("Smith","222222");
	map.put("Bob","333333");
	map.put("Bruth","444444");
%>
<%!
	boolean validate(String username,String password)
	{
		String passwd=map.get(username);
		if(passwd!=null && passwd.equals(password))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
%>
<%
	String username=request.getParameter("username");
	String password=request.getParameter("password");
	if(username==null || username==" " || password==null || password==" ")
	{
		response.sendRedirect("login.jsp");
	}
	flag=validate(username,password);
	if(flag)
	{
		//保存在session对象中
		session.setAttribute("username",username);
		session.setAttribute("password",password);
		response.sendRedirect("shouye.jsp");
	}
%>
<body>
	<center>
		<font size="6">用户登录</font>
	</center>
	<br/>
	<center>
		<%if(!flag) {%>
			<a href="login.jsp">重新登陆系统</a>
			<%} %>
	</center>
</body>
</html>