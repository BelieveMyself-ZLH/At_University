package com.attendance.action;

import java.util.List;

import com.attendance.javabean.OutRecord;
import com.attendance.javabean.OvertimeRecord;
import com.attendance.service.Imp.OutManagerImp;
import com.attendance.service.Imp.OvertimeManagerImp;

public class OvertimeAction {
	private int page=1;
	private List<OvertimeRecord> projectList;
	private int totalPage;
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public List<OvertimeRecord> getProjectList() {
		return projectList;
	}
	public void setProjectList(List<OvertimeRecord> projectList) {
		this.projectList = projectList;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	
	public String execute() {
		OvertimeManagerImp overtimeManagerImp=new OvertimeManagerImp();
		projectList=overtimeManagerImp.getAllORecord();
//		for(AttendanceRecord attendanceRecord : projectList) {
//			System.out.println(employeeInformation.getE_name()+employeeInformation.getE_sex());
//		}
		return "success";
	}
}
