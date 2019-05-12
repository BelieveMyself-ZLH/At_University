<<<<<<< HEAD
package cdu_pfms.database.data;

import java.io.Serializable;
import java.sql.Date;

/**
 * 新闻信息持久化类
 * @author ZhouLinHu
 * @createTime 2018年11月9日 上午10:59:37
 * @lastTime 2018年11月9日 上午10:59:37
 * @version 1.0.0
 */
public class News implements Serializable {
	private int newsId;
	private int adOperId;
	private String newsTitle;
	private String newsSum;
	private String newsContent;
	private Date newsTime;
	public int getNewsId() {
		return newsId;
	}
	public void setNewsId(int newsId) {
		this.newsId = newsId;
	}
	public int getAdOperId() {
		return adOperId;
	}
	public void setAdOperId(int adOperId) {
		this.adOperId = adOperId;
	}
	public String getNewsTitle() {
		return newsTitle;
	}
	public void setNewsTitle(String newsTitle) {
		this.newsTitle = newsTitle;
	}
	public String getNewsSum() {
		return newsSum;
	}
	public void setNewsSum(String newsSum) {
		this.newsSum = newsSum;
	}
	public String getNewsContent() {
		return newsContent;
	}
	public void setNewsContent(String newsContent) {
		this.newsContent = newsContent;
	}
	public Date getNewsTime() {
		return newsTime;
	}
	public void setNewsTime(Date newsTime) {
		this.newsTime = newsTime;
	}
	@Override
	public String toString() {
		return "News [newsId=" + newsId + ", adOperId=" + adOperId + ", newsTitle=" + newsTitle + ", newsSum=" + newsSum
				+ ", newsContent=" + newsContent + ", newsTime=" + newsTime + "]";
	}
	
}
=======
package cdu_pfms.database.data;

import java.io.Serializable;
import java.sql.Date;

/**
 * 新闻信息持久化类
 * @author ZhouLinHu
 * @createTime 2018年11月9日 上午10:59:37
 * @lastTime 2018年11月9日 上午10:59:37
 * @version 1.0.0
 */
public class News implements Serializable {
	private int newsId;
	private int adOperId;
	private String newsTitle;
	private String newsSum;
	private String newsContent;
	private Date newsTime;
	public int getNewsId() {
		return newsId;
	}
	public void setNewsId(int newsId) {
		this.newsId = newsId;
	}
	public int getAdOperId() {
		return adOperId;
	}
	public void setAdOperId(int adOperId) {
		this.adOperId = adOperId;
	}
	public String getNewsTitle() {
		return newsTitle;
	}
	public void setNewsTitle(String newsTitle) {
		this.newsTitle = newsTitle;
	}
	public String getNewsSum() {
		return newsSum;
	}
	public void setNewsSum(String newsSum) {
		this.newsSum = newsSum;
	}
	public String getNewsContent() {
		return newsContent;
	}
	public void setNewsContent(String newsContent) {
		this.newsContent = newsContent;
	}
	public Date getNewsTime() {
		return newsTime;
	}
	public void setNewsTime(Date newsTime) {
		this.newsTime = newsTime;
	}
	@Override
	public String toString() {
		return "News [newsId=" + newsId + ", adOperId=" + adOperId + ", newsTitle=" + newsTitle + ", newsSum=" + newsSum
				+ ", newsContent=" + newsContent + ", newsTime=" + newsTime + "]";
	}
	
}
>>>>>>> second commit
