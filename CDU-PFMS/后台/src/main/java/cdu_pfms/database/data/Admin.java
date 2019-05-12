<<<<<<< HEAD
package cdu_pfms.database.data;

import java.io.Serializable;

/**
 * 管理员信息数据持久化类
 * @author ZhouLinHu
 * @createTime 2018年11月9日 上午10:58:24
 * @lastTime 2018年11月9日 上午10:58:24
 * @version 1.0.0
 */
public class Admin implements Serializable {
	private String adminId;
	private String adminName;
	private String adminPassword;
	private String adminGender;
	private String adminIdcard;
	private String adminPhone;
	private String adminMailbox;

	public String getAdminId() {
		return adminId;
	}

	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}

	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public String getAdminPassword() {
		return adminPassword;
	}

	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}

	public String getAdminGender() {
		return adminGender;
	}

	public void setAdminGender(String adminGender) {
		this.adminGender = adminGender;
	}

	public String getAdminIdcard() {
		return adminIdcard;
	}

	public void setAdminIdcard(String adminIdcard) {
		this.adminIdcard = adminIdcard;
	}

	public String getAdminPhone() {
		return adminPhone;
	}

	public void setAdminPhone(String adminPhone) {
		this.adminPhone = adminPhone;
	}

	public String getAdminMailbox() {
		return adminMailbox;
	}

	public void setAdminMailbox(String adminMailbox) {
		this.adminMailbox = adminMailbox;
	}

	@Override
	public String toString() {
		return "Admin [adminId=" + adminId + ", adminName=" + adminName + ", adminPassword=" + adminPassword
				+ ", adminGender=" + adminGender + ", adminIdcard=" + adminIdcard + ", adminPhone=" + adminPhone
				+ ", adminMailbox=" + adminMailbox + "]";
	}
	
}
=======
package cdu_pfms.database.data;

import java.io.Serializable;

/**
 * 管理员信息数据持久化类
 * @author ZhouLinHu
 * @createTime 2018年11月9日 上午10:58:24
 * @lastTime 2018年11月9日 上午10:58:24
 * @version 1.0.0
 */
public class Admin implements Serializable {
	private String adminId;
	private String adminName;
	private String adminPassword;
	private String adminGender;
	private String adminIdcard;
	private String adminPhone;
	private String adminMailbox;

	public String getAdminId() {
		return adminId;
	}

	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}

	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public String getAdminPassword() {
		return adminPassword;
	}

	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}

	public String getAdminGender() {
		return adminGender;
	}

	public void setAdminGender(String adminGender) {
		this.adminGender = adminGender;
	}

	public String getAdminIdcard() {
		return adminIdcard;
	}

	public void setAdminIdcard(String adminIdcard) {
		this.adminIdcard = adminIdcard;
	}

	public String getAdminPhone() {
		return adminPhone;
	}

	public void setAdminPhone(String adminPhone) {
		this.adminPhone = adminPhone;
	}

	public String getAdminMailbox() {
		return adminMailbox;
	}

	public void setAdminMailbox(String adminMailbox) {
		this.adminMailbox = adminMailbox;
	}

	@Override
	public String toString() {
		return "Admin [adminId=" + adminId + ", adminName=" + adminName + ", adminPassword=" + adminPassword
				+ ", adminGender=" + adminGender + ", adminIdcard=" + adminIdcard + ", adminPhone=" + adminPhone
				+ ", adminMailbox=" + adminMailbox + "]";
	}
	
}
>>>>>>> second commit
