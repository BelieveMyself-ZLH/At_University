package com.attendance.action;

import java.util.List;

import com.attendance.javabean.AttendanceRecord;
import com.attendance.javabean.OutRecord;
import com.attendance.service.Imp.AttendanceManagerImp;
import com.attendance.service.Imp.OutManagerImp;

public class OutAction {
	private int page=1;
	private List<OutRecord> projectList;
	private int totalPage;
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public List<OutRecord> getProjectList() {
		return projectList;
	}
	public void setProjectList(List<OutRecord> projectList) {
		this.projectList = projectList;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	
	public String execute() {
		OutManagerImp outManagerImp=new OutManagerImp();
		projectList=outManagerImp.getAllOutRecord();
//		for(AttendanceRecord attendanceRecord : projectList) {
//			System.out.println(employeeInformation.getE_name()+employeeInformation.getE_sex());
//		}
		return "success";
	}
}
