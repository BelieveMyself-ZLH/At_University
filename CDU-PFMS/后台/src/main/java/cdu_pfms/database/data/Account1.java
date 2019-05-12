<<<<<<< HEAD
package cdu_pfms.database.data;

import java.sql.Timestamp;


/**
 * 改变User类型
 */
public class Account1 {

	private String accountId;
	private User user;
	private String accountPassword;
	private Double accountBalance;
	private Integer accountState;   //是否冻结
	private Timestamp accountCreateTime;
	
	public Timestamp getAccountCreateTime() {
		return accountCreateTime;
	}

	public void setAccountCreateTime(Timestamp accountCreateTime) {
		this.accountCreateTime = accountCreateTime;
	}

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getAccountPassword() {
		return accountPassword;
	}

	public void setAccountPassword(String accountPassword) {
		this.accountPassword = accountPassword;
	}

	public Double getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(Double accountBalance) {
		this.accountBalance = accountBalance;
	}

	public Integer getAccountState() {
		return accountState;
	}

	public void setAccountState(Integer accountState) {
		this.accountState = accountState;
	}

	@Override
	public String toString() {
		return "Account{" +
				"accountId='" + accountId + '\'' +
				", user=" + user +
				", accountPassword='" + accountPassword + '\'' +
				", accountBalance=" + accountBalance +
				", accountState=" + accountState +
				", accountCreatetime=" + accountCreateTime +
				'}';
	}
}
=======
package cdu_pfms.database.data;

import java.sql.Timestamp;


/**
 * 改变User类型
 */
public class Account1 {

	private String accountId;
	private User user;
	private String accountPassword;
	private Double accountBalance;
	private Integer accountState;   //是否冻结
	private Timestamp accountCreateTime;
	
	public Timestamp getAccountCreateTime() {
		return accountCreateTime;
	}

	public void setAccountCreateTime(Timestamp accountCreateTime) {
		this.accountCreateTime = accountCreateTime;
	}

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getAccountPassword() {
		return accountPassword;
	}

	public void setAccountPassword(String accountPassword) {
		this.accountPassword = accountPassword;
	}

	public Double getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(Double accountBalance) {
		this.accountBalance = accountBalance;
	}

	public Integer getAccountState() {
		return accountState;
	}

	public void setAccountState(Integer accountState) {
		this.accountState = accountState;
	}

	@Override
	public String toString() {
		return "Account{" +
				"accountId='" + accountId + '\'' +
				", user=" + user +
				", accountPassword='" + accountPassword + '\'' +
				", accountBalance=" + accountBalance +
				", accountState=" + accountState +
				", accountCreatetime=" + accountCreateTime +
				'}';
	}
}
>>>>>>> second commit
