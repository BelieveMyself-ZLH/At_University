package com.attendance.dao.In;

import java.util.List;

import com.attendance.javabean.EmployeeInformation;

public interface EmployeeDao {
	/**
	 * ��ȡԱ������Ϣ
	 */
	public List<EmployeeInformation> getAllEmployeeInf();
	
	/**
	 * ��֤Ա����¼
	 * @return
	 */
	public boolean isLogo(String username,String password);
	
	public int getTotalPage(int rowsPerPage);
	
	public List<EmployeeInformation> getAllEmployeeInf(int page,int rowsPerPage);
}
