package com.attendance.javabean;

/**
 * 对应加班记录表
 * @author ZhouLinHu
 *
 */
public class OvertimeRecord {
	private String e_id;
	private String overtime_num;
	private String overtime_time_begin;
	private String overtime_time_end;
	private String overtime_days;
	public String getE_id() {
		return e_id;
	}
	public void setE_id(String e_id) {
		this.e_id = e_id;
	}
	public String getOvertime_num() {
		return overtime_num;
	}
	public void setOvertime_num(String overtime_num) {
		this.overtime_num = overtime_num;
	}
	public String getOvertime_time_begin() {
		return overtime_time_begin;
	}
	public void setOvertime_time_begin(String overtime_time_begin) {
		this.overtime_time_begin = overtime_time_begin;
	}
	public String getOvertime_time_end() {
		return overtime_time_end;
	}
	public void setOvertime_time_end(String overtime_time_end) {
		this.overtime_time_end = overtime_time_end;
	}
	public String getOvertime_days() {
		return overtime_days;
	}
	public void setOvertime_days(String overtime_days) {
		this.overtime_days = overtime_days;
	}
	
}
