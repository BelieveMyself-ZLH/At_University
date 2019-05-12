package com.attendance.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

public class DakaAction {
	
	public HttpServletRequest getRequest() {
		return ServletActionContext.getRequest();
	}
	
	public HttpServletResponse getResponse() {
		return ServletActionContext.getResponse();
	}
	public String addRecord() {
		HttpServletRequest request=getRequest();
		String id=null;
		id=request.getParameter("userName");
		System.out.println(id);
		return "success";
	}
}
