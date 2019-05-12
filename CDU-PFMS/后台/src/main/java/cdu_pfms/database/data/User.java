<<<<<<< HEAD
package cdu_pfms.database.data;

import java.io.Serializable;
import java.sql.Date;

/**
 * 用户信息数据持久化类
 * 
 * @author ZhouLinHu
 * @createTime 2018年11月9日 上午10:55:41
 * @lastTime 2018年11月9日 上午10:55:41
 * @version 1.0.0
 */
public class User implements Serializable{
	private Integer userId;
	private String userName;
	private String userGender;
	private Date userBirthday;
	private String userAddress;
	private String userPhone;
	private String userIdcard;
	private String userMailbox;
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
	public String getUserGender() {
		return userGender;
	}
	public void setUserGender(String userGender) {
		this.userGender = userGender;
	}
	public Date getUserBirthday() {
		return userBirthday;
	}
	public void setUserBirthday(Date userBirthday) {
		this.userBirthday = userBirthday;
	}
	public String getUserAddress() {
		return userAddress;
	}
	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}
	public String getUserPhone() {
		return userPhone;
	}
	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}
	public String getUserIdcard() {
		return userIdcard;
	}
	public void setUserIdcard(String userIdcard) {
		this.userIdcard = userIdcard;
	}
	public String getUserMailbox() {
		return userMailbox;
	}
	public void setUserMailbox(String userMailbox) {
		this.userMailbox = userMailbox;
	}

	
}
=======
package cdu_pfms.database.data;

import java.io.Serializable;
import java.sql.Date;

/**
 * 用户信息数据持久化类
 * 
 * @author ZhouLinHu
 * @createTime 2018年11月9日 上午10:55:41
 * @lastTime 2018年11月9日 上午10:55:41
 * @version 1.0.0
 */
public class User implements Serializable{
	private Integer userId;
	private String userName;
	private String userGender;
	private Date userBirthday;
	private String userAddress;
	private String userPhone;
	private String userIdcard;
	private String userMailbox;
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
	public String getUserGender() {
		return userGender;
	}
	public void setUserGender(String userGender) {
		this.userGender = userGender;
	}
	public Date getUserBirthday() {
		return userBirthday;
	}
	public void setUserBirthday(Date userBirthday) {
		this.userBirthday = userBirthday;
	}
	public String getUserAddress() {
		return userAddress;
	}
	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}
	public String getUserPhone() {
		return userPhone;
	}
	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}
	public String getUserIdcard() {
		return userIdcard;
	}
	public void setUserIdcard(String userIdcard) {
		this.userIdcard = userIdcard;
	}
	public String getUserMailbox() {
		return userMailbox;
	}
	public void setUserMailbox(String userMailbox) {
		this.userMailbox = userMailbox;
	}

	
}
>>>>>>> second commit
