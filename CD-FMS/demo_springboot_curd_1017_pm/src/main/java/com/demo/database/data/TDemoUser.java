<<<<<<< HEAD
package com.demo.database.data;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

/**
 * 用户表的持久化类
 * @author Teacher
 * @createTime 2018年10月12日 下午3:05:05
 * @lastTime 2018年10月17日 上午09:30:00
 * @version 1.0.0
 */
public class TDemoUser implements Serializable {

	private Integer userId; // 用户ID
	private String userName; // 用户名
	private String userPassword; //密码
	private TDemoDept TDemoDept; //部门
	private String userGender; //性别
	private Date userInTime; //入职时间
	private Timestamp operTime; //操作时间

	//alt+shift+s r  alt+a
	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public TDemoDept getTDemoDept() {
		return TDemoDept;
	}

	public void setTDemoDept(TDemoDept tDemoDept) {
		TDemoDept = tDemoDept;
	}

	public String getUserGender() {
		return userGender;
	}

	public void setUserGender(String userGender) {
		this.userGender = userGender;
	}

	public Date getUserInTime() {
		return userInTime;
	}

	public void setUserInTime(Date userInTime) {
		this.userInTime = userInTime;
	}

	public Timestamp getOperTime() {
		return operTime;
	}

	public void setOperTime(Timestamp operTime) {
		this.operTime = operTime;
	}

}
=======
package com.demo.database.data;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

/**
 * 用户表的持久化类
 * @author Teacher
 * @createTime 2018年10月12日 下午3:05:05
 * @lastTime 2018年10月17日 上午09:30:00
 * @version 1.0.0
 */
public class TDemoUser implements Serializable {

	private Integer userId; // 用户ID
	private String userName; // 用户名
	private String userPassword; //密码
	private TDemoDept TDemoDept; //部门
	private String userGender; //性别
	private Date userInTime; //入职时间
	private Timestamp operTime; //操作时间

	//alt+shift+s r  alt+a
	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public TDemoDept getTDemoDept() {
		return TDemoDept;
	}

	public void setTDemoDept(TDemoDept tDemoDept) {
		TDemoDept = tDemoDept;
	}

	public String getUserGender() {
		return userGender;
	}

	public void setUserGender(String userGender) {
		this.userGender = userGender;
	}

	public Date getUserInTime() {
		return userInTime;
	}

	public void setUserInTime(Date userInTime) {
		this.userInTime = userInTime;
	}

	public Timestamp getOperTime() {
		return operTime;
	}

	public void setOperTime(Timestamp operTime) {
		this.operTime = operTime;
	}

}
>>>>>>> second commit
