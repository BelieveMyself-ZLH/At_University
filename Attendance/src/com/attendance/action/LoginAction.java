package com.attendance.action;

import com.attendance.service.Imp.EmployeeManagerImp;

public class LoginAction {
	public String name;
	public String password;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String islogin() {
		if (new EmployeeManagerImp().isLogo(name, password)) {
			return "success";
		}else {
			return "error";
		}
	}
}
