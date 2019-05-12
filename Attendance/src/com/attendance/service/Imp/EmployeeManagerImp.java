package com.attendance.service.Imp;

import java.util.List;

import com.attendance.dao.Imp.EmployeeDaoImp;
import com.attendance.javabean.EmployeeInformation;
import com.attendance.service.In.EmployeeManager;

public class EmployeeManagerImp implements EmployeeManager{

	@Override
	public List<EmployeeInformation> getAllEmployeeInf() {
		return new EmployeeDaoImp().getAllEmployeeInf();
	}

	@Override
	public boolean isLogo(String username, String password) {
		return new EmployeeDaoImp().isLogo(username, password);
	}

	@Override
	public List<EmployeeInformation> getAllEmployeeInf(int page, int rowsPerPage) {
		// TODO Auto-generated method stub
		return new EmployeeDaoImp().getAllEmployeeInf(page,rowsPerPage);
	}

	@Override
	public int getTotalPerPage(int rowsPerPage) {
		// TODO Auto-generated method stub
		return new EmployeeDaoImp().getTotalPage(rowsPerPage);
	}
}
