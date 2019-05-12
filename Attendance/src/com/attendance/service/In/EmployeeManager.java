package com.attendance.service.In;

import java.util.List;

import com.attendance.javabean.EmployeeInformation;

public interface EmployeeManager {
	/**
	 * 获取员工的信息
	 */
	public List<EmployeeInformation> getAllEmployeeInf();
	
	/**
	 * 验证员工登录
	 * @return
	 */
	public boolean isLogo(String username,String password);
	
	public List<EmployeeInformation> getAllEmployeeInf(int page,int rowsPerPage);
	
	public int getTotalPerPage(int rowsPerPage);
}
