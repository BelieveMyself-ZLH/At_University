<<<<<<< HEAD
package cdu_pfms.database.data;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * 账户信息持久化类
 * @author ZhouLinHu
 * @createTime 2018年11月9日 上午10:58:51
 * @lastTime 2018年11月9日 上午10:58:51
 * @version 1.0.0
 */
public class Account implements Serializable {
	private String accountId;
	private Integer userId;
	private String accountPassword;
	private double accountBalance;
	private int accountState;
	private Timestamp accountCreateTime;

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getAccountPassword() {
		return accountPassword;
	}

	public void setAccountPassword(String accountPassword) {
		this.accountPassword = accountPassword;
	}

	public double getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(double accountBalance) {
		this.accountBalance = accountBalance;
	}

	public int getAccountState() {
		return accountState;
	}

	public void setAccountState(int accountState) {
		this.accountState = accountState;
	}

	public Timestamp getAccountCreateTime() {
		return accountCreateTime;
	}

	public void setAccountCreateTime(Timestamp accountCreateTime) {
		this.accountCreateTime = accountCreateTime;
	}

	@Override
	public String toString() {
		return "Account [accountId=" + accountId + ", userId=" + userId + ", accountPassword=" + accountPassword
				+ ", accountBalance=" + accountBalance + ", accountState=" + accountState + ", accountCreateTime="
				+ accountCreateTime + "]";
	}

	
}


=======
package cdu_pfms.database.data;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * 账户信息持久化类
 * @author ZhouLinHu
 * @createTime 2018年11月9日 上午10:58:51
 * @lastTime 2018年11月9日 上午10:58:51
 * @version 1.0.0
 */
public class Account implements Serializable {
	private String accountId;
	private Integer userId;
	private String accountPassword;
	private double accountBalance;
	private int accountState;
	private Timestamp accountCreateTime;

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getAccountPassword() {
		return accountPassword;
	}

	public void setAccountPassword(String accountPassword) {
		this.accountPassword = accountPassword;
	}

	public double getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(double accountBalance) {
		this.accountBalance = accountBalance;
	}

	public int getAccountState() {
		return accountState;
	}

	public void setAccountState(int accountState) {
		this.accountState = accountState;
	}

	public Timestamp getAccountCreateTime() {
		return accountCreateTime;
	}

	public void setAccountCreateTime(Timestamp accountCreateTime) {
		this.accountCreateTime = accountCreateTime;
	}

	@Override
	public String toString() {
		return "Account [accountId=" + accountId + ", userId=" + userId + ", accountPassword=" + accountPassword
				+ ", accountBalance=" + accountBalance + ", accountState=" + accountState + ", accountCreateTime="
				+ accountCreateTime + "]";
	}

	
}


>>>>>>> second commit
