package com.attendance.dao.In;

import java.util.List;

import com.attendance.javabean.EmployeeInformation;

public interface EmployeeDao {
	/**
	 * 获取员工的信息
	 */
	public List<EmployeeInformation> getAllEmployeeInf();
	
	/**
	 * 验证员工登录
	 * @return
	 */
	public boolean isLogo(String username,String password);
	
	public int getTotalPage(int rowsPerPage);
	
	public List<EmployeeInformation> getAllEmployeeInf(int page,int rowsPerPage);
}
