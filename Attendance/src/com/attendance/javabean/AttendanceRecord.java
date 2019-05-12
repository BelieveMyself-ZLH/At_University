package com.attendance.javabean;

/**
 * 对应考勤信息记录表
 * @author Administrator
 *
 */
public class AttendanceRecord {
	private String e_id;
	private String e_num;
	private String work_time;
	private String end_time;
	private String work_note;
	public String getE_id() {
		return e_id;
	}
	public void setE_id(String e_id) {
		this.e_id = e_id;
	}
	public String getE_num() {
		return e_num;
	}
	public void setE_num(String e_num) {
		this.e_num = e_num;
	}
	public String getWork_time() {
		return work_time;
	}
	public void setWork_time(String work_time) {
		this.work_time = work_time;
	}
	public String getEnd_time() {
		return end_time;
	}
	public void setEnd_time(String end_time) {
		this.end_time = end_time;
	}
	public String getWork_note() {
		return work_note;
	}
	public void setWork_note(String work_note) {
		this.work_note = work_note;
	}
	
}
