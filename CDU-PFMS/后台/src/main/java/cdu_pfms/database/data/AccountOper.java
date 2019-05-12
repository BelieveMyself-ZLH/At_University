<<<<<<< HEAD
package cdu_pfms.database.data;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * 账户操作信息持久化类
 * 
 * @author ZhouLinHu
 * @createTime 2018年11月9日 上午10:59:07
 * @lastTime 2018年11月9日 上午10:59:07
 * @version 1.0.0
 */
public class AccountOper implements Serializable {
	private int userOperId;
	private String accId;
	private double userOperAmount;
	private int userOperType;
	private Timestamp userOperTime;
	private String user_OperAccount;

	public int getUserOperId() {
		return userOperId;
	}

	public void setUserOperId(int userOperId) {
		this.userOperId = userOperId;
	}

	public String getAccId() {
		return accId;
	}

	public void setAccId(String accId) {
		this.accId = accId;
	}

	public double getUserOperAmount() {
		return userOperAmount;
	}

	public void setUserOperAmount(double userOperAmount) {
		this.userOperAmount = userOperAmount;
	}

	public int getUserOperType() {
		return userOperType;
	}

	public void setUserOperType(int userOperType) {
		this.userOperType = userOperType;
	}

	public Timestamp getUserOperTime() {
		return userOperTime;
	}

	public void setUserOperTime(Timestamp userOperTime) {
		this.userOperTime = userOperTime;
	}

	public String getUser_OperAccount() {
		return user_OperAccount;
	}

	public void setUser_OperAccount(String user_OperAccount) {
		this.user_OperAccount = user_OperAccount;
	}

	@Override
	public String toString() {
		return "UserOper [userOperId=" + userOperId + ", accId=" + accId + ", userOperAmount=" + userOperAmount
				+ ", userOperType=" + userOperType + ", userOperTime=" + userOperTime + ", user_OperAccount="
				+ user_OperAccount + "]";
	}

}
=======
package cdu_pfms.database.data;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * 账户操作信息持久化类
 * 
 * @author ZhouLinHu
 * @createTime 2018年11月9日 上午10:59:07
 * @lastTime 2018年11月9日 上午10:59:07
 * @version 1.0.0
 */
public class AccountOper implements Serializable {
	private int userOperId;
	private String accId;
	private double userOperAmount;
	private int userOperType;
	private Timestamp userOperTime;
	private String user_OperAccount;

	public int getUserOperId() {
		return userOperId;
	}

	public void setUserOperId(int userOperId) {
		this.userOperId = userOperId;
	}

	public String getAccId() {
		return accId;
	}

	public void setAccId(String accId) {
		this.accId = accId;
	}

	public double getUserOperAmount() {
		return userOperAmount;
	}

	public void setUserOperAmount(double userOperAmount) {
		this.userOperAmount = userOperAmount;
	}

	public int getUserOperType() {
		return userOperType;
	}

	public void setUserOperType(int userOperType) {
		this.userOperType = userOperType;
	}

	public Timestamp getUserOperTime() {
		return userOperTime;
	}

	public void setUserOperTime(Timestamp userOperTime) {
		this.userOperTime = userOperTime;
	}

	public String getUser_OperAccount() {
		return user_OperAccount;
	}

	public void setUser_OperAccount(String user_OperAccount) {
		this.user_OperAccount = user_OperAccount;
	}

	@Override
	public String toString() {
		return "UserOper [userOperId=" + userOperId + ", accId=" + accId + ", userOperAmount=" + userOperAmount
				+ ", userOperType=" + userOperType + ", userOperTime=" + userOperTime + ", user_OperAccount="
				+ user_OperAccount + "]";
	}

}
>>>>>>> second commit
