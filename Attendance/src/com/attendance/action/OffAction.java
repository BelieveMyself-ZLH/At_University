package com.attendance.action;

import java.util.List;

import com.attendance.javabean.OffRecord;
import com.attendance.javabean.OutRecord;
import com.attendance.service.Imp.OffManagerImp;
import com.attendance.service.Imp.OutManagerImp;

public class OffAction {
	private int page=1;
	private List<OffRecord> projectList;
	private int totalPage;
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public List<OffRecord> getProjectList() {
		return projectList;
	}
	public void setProjectList(List<OffRecord> projectList) {
		this.projectList = projectList;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	
	public String execute() {
		OffManagerImp offManagerImp =new OffManagerImp();
		projectList=offManagerImp.getOffRecord();
//		for(AttendanceRecord attendanceRecord : projectList) {
//			System.out.println(employeeInformation.getE_name()+employeeInformation.getE_sex());
//		}
		return "success";
	}
}
