package com.attendance.action;

import java.util.List;

import com.attendance.javabean.MonthRecord;
import com.attendance.service.Imp.MonthManagerImp;

public class MonthAction {
	private int page=1;
	private List<MonthRecord> projectList;
	private int totalPage;
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public List<MonthRecord> getProjectList() {
		return projectList;
	}
	public void setProjectList(List<MonthRecord> projectList) {
		this.projectList = projectList;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	
	public String execute() {
		MonthManagerImp managerImp=new MonthManagerImp();
		projectList=managerImp.getAllMonthRecord();
//		for(AttendanceRecord attendanceRecord : projectList) {
//			System.out.println(employeeInformation.getE_name()+employeeInformation.getE_sex());
//		}
		return "success";
	}
}
