package com.attendance.javabean;

/**
 * 对应请假记录表
 * @author ZhouLinHu
 *
 */
public class OffRecord {
	private String e_id;
	private String off_num;
	private String off_time_begin;
	private String off_time_end;
	private int off_days;
	public String getE_id() {
		return e_id;
	}
	public void setE_id(String e_id) {
		this.e_id = e_id;
	}
	public String getOff_num() {
		return off_num;
	}
	public void setOff_num(String off_num) {
		this.off_num = off_num;
	}
	public String getOff_time_begin() {
		return off_time_begin;
	}
	public void setOff_time_begin(String off_time_begin) {
		this.off_time_begin = off_time_begin;
	}
	public String getOff_time_end() {
		return off_time_end;
	}
	public void setOff_time_end(String off_time_end) {
		this.off_time_end = off_time_end;
	}
	public int getOff_days() {
		return off_days;
	}
	public void setOff_days(int off_days) {
		this.off_days = off_days;
	}
	
}
