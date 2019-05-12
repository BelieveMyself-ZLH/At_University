<<<<<<< HEAD
package cdu_pfms.database.data;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * 管理员操作信息持久化类
 * 
 * @author ZhouLinHu
 * @createTime 2018年11月9日 上午10:59:23
 * @lastTime 2018年11月9日 上午10:59:23
 * @version 1.0.0
 */
public class AdminOper implements Serializable {
	private int adOperId;
	private String accId;
	private String adId;
	private Timestamp adOperTime;
	private int adOperType;

	public int getAdOperId() {
		return adOperId;
	}

	public void setAdOperId(int adOperId) {
		this.adOperId = adOperId;
	}

	public String getAccId() {
		return accId;
	}

	public void setAccId(String accId) {
		this.accId = accId;
	}

	public String getAdId() {
		return adId;
	}

	public void setAdId(String adId) {
		this.adId = adId;
	}

	public Timestamp getAdOperTime() {
		return adOperTime;
	}

	public void setAdOperTime(Timestamp adOperTime) {
		this.adOperTime = adOperTime;
	}

	public int getAdOperType() {
		return adOperType;
	}

	public void setAdOperType(int adOperType) {
		this.adOperType = adOperType;
	}

	@Override
	public String toString() {
		return "AdminOper [adOperId=" + adOperId + ", accId=" + accId + ", adId=" + adId + ", adOperTime=" + adOperTime
				+ ", adOperType=" + adOperType + "]";
	}

}
=======
package cdu_pfms.database.data;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * 管理员操作信息持久化类
 * 
 * @author ZhouLinHu
 * @createTime 2018年11月9日 上午10:59:23
 * @lastTime 2018年11月9日 上午10:59:23
 * @version 1.0.0
 */
public class AdminOper implements Serializable {
	private int adOperId;
	private String accId;
	private String adId;
	private Timestamp adOperTime;
	private int adOperType;

	public int getAdOperId() {
		return adOperId;
	}

	public void setAdOperId(int adOperId) {
		this.adOperId = adOperId;
	}

	public String getAccId() {
		return accId;
	}

	public void setAccId(String accId) {
		this.accId = accId;
	}

	public String getAdId() {
		return adId;
	}

	public void setAdId(String adId) {
		this.adId = adId;
	}

	public Timestamp getAdOperTime() {
		return adOperTime;
	}

	public void setAdOperTime(Timestamp adOperTime) {
		this.adOperTime = adOperTime;
	}

	public int getAdOperType() {
		return adOperType;
	}

	public void setAdOperType(int adOperType) {
		this.adOperType = adOperType;
	}

	@Override
	public String toString() {
		return "AdminOper [adOperId=" + adOperId + ", accId=" + accId + ", adId=" + adId + ", adOperTime=" + adOperTime
				+ ", adOperType=" + adOperType + "]";
	}

}
>>>>>>> second commit
