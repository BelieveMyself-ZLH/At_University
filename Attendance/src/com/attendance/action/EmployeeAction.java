package com.attendance.action;

import java.util.List;

import com.attendance.javabean.EmployeeInformation;
import com.attendance.service.Imp.EmployeeManagerImp;
import com.opensymphony.xwork2.ActionSupport;

public class EmployeeAction extends ActionSupport{
	
	private int page=1;
	private List<EmployeeInformation> projectList;
	private int totalPage;
	

	public int getPage() {
		return page;
	}


	public void setPage(int page) {
		this.page = page;
	}


	public List<EmployeeInformation> getProjectList() {
		return projectList;
	}


	public void setProjectList(List<EmployeeInformation> projectList) {
		this.projectList = projectList;
	}


	public int getTotalPage() {
		return totalPage;
	}


	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}


	public String execute() {
		System.out.println(page);
		EmployeeManagerImp employeeManagerImp=new EmployeeManagerImp();
		totalPage=employeeManagerImp.getTotalPerPage(10);
		projectList=employeeManagerImp.getAllEmployeeInf(page,10);
		return "success";
	}
}
