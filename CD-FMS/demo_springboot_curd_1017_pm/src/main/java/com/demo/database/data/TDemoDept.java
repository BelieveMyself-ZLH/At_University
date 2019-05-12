<<<<<<< HEAD
package com.demo.database.data;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

/**
 * 部门表持久化类
 * 
 * @author Teacher
 * @createTime 2018年10月15日 上午9:01:43
 * @lastTime 2018年10月15日 上午9:01:43
 * @version 1.0.0
 */
public class TDemoDept implements Serializable {

	private Integer deptId; //部门ID
	private String deptName; //部门名称
	private Date deptCreateTime; //成立时间
	private Timestamp operTime; //操作时间
	private List<TDemoUser> TDemoUsers; //部门关联的用户集合

	public Integer getDeptId() {
		return deptId;
	}

	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public Date getDeptCreateTime() {
		return deptCreateTime;
	}

	public void setDeptCreateTime(Date deptCreateTime) {
		this.deptCreateTime = deptCreateTime;
	}

	public Timestamp getOperTime() {
		return operTime;
	}

	public void setOperTime(Timestamp operTime) {
		this.operTime = operTime;
	}

	public List<TDemoUser> getTDemoUsers() {
		return TDemoUsers;
	}

	public void setTDemoUsers(List<TDemoUser> tDemoUsers) {
		TDemoUsers = tDemoUsers;
	}

}
=======
package com.demo.database.data;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

/**
 * 部门表持久化类
 * 
 * @author Teacher
 * @createTime 2018年10月15日 上午9:01:43
 * @lastTime 2018年10月15日 上午9:01:43
 * @version 1.0.0
 */
public class TDemoDept implements Serializable {

	private Integer deptId; //部门ID
	private String deptName; //部门名称
	private Date deptCreateTime; //成立时间
	private Timestamp operTime; //操作时间
	private List<TDemoUser> TDemoUsers; //部门关联的用户集合

	public Integer getDeptId() {
		return deptId;
	}

	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public Date getDeptCreateTime() {
		return deptCreateTime;
	}

	public void setDeptCreateTime(Date deptCreateTime) {
		this.deptCreateTime = deptCreateTime;
	}

	public Timestamp getOperTime() {
		return operTime;
	}

	public void setOperTime(Timestamp operTime) {
		this.operTime = operTime;
	}

	public List<TDemoUser> getTDemoUsers() {
		return TDemoUsers;
	}

	public void setTDemoUsers(List<TDemoUser> tDemoUsers) {
		TDemoUsers = tDemoUsers;
	}

}
>>>>>>> second commit
