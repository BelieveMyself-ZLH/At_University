package com.attendance.action;

import java.util.List;

import com.attendance.javabean.AttendanceRecord;
import com.attendance.javabean.EmployeeInformation;
import com.attendance.service.Imp.AttendanceManagerImp;
import com.attendance.service.Imp.EmployeeManagerImp;

public class AttendanceAction {
	private int page=1;
	private List<AttendanceRecord> projectList;
	private int totalPage;
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public List<AttendanceRecord> getProjectList() {
		return projectList;
	}
	public void setProjectList(List<AttendanceRecord> projectList) {
		this.projectList = projectList;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	
	public String getAllRecord() {
		AttendanceManagerImp attendanceManagerImp=new AttendanceManagerImp();
		projectList=attendanceManagerImp.getAttenRecord();
//		for(AttendanceRecord attendanceRecord : projectList) {
//			System.out.println(employeeInformation.getE_name()+employeeInformation.getE_sex());
//		}
		return "success";
	}
}
