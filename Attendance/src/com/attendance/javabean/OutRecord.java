package com.attendance.javabean;

/**
 * 对应出差记录表
 * @author Administrator
 *
 */
public class OutRecord {
	private String e_id;
	private String out_num;
	private String out_time;
	private String back_time;
	private int out_days;
	public String getE_id() {
		return e_id;
	}
	public void setE_id(String e_id) {
		this.e_id = e_id;
	}
	public String getOut_num() {
		return out_num;
	}
	public void setOut_num(String out_num) {
		this.out_num = out_num;
	}
	public String getOut_time() {
		return out_time;
	}
	public void setOut_time(String out_time) {
		this.out_time = out_time;
	}
	public String getBack_time() {
		return back_time;
	}
	public void setBack_time(String back_time) {
		this.back_time = back_time;
	}
	public int getOut_days() {
		return out_days;
	}
	public void setOut_days(int out_days) {
		this.out_days = out_days;
	}
	
}
