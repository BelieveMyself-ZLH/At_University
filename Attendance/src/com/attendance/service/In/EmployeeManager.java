package com.attendance.service.In;

import java.util.List;

import com.attendance.javabean.EmployeeInformation;

public interface EmployeeManager {
	/**
	 * ��ȡԱ������Ϣ
	 */
	public List<EmployeeInformation> getAllEmployeeInf();
	
	/**
	 * ��֤Ա����¼
	 * @return
	 */
	public boolean isLogo(String username,String password);
	
	public List<EmployeeInformation> getAllEmployeeInf(int page,int rowsPerPage);
	
	public int getTotalPerPage(int rowsPerPage);
}
