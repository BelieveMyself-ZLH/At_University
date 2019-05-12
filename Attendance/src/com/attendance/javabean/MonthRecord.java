package com.attendance.javabean;

/**
 * 对应月统计记录表
 * @author ZhouLinHu
 *
 */
public class MonthRecord {
	private String e_id;
	private int work_note_month;
	private int out_note_month;
	private int over_note_month;
	private int off_note_month;
	public String getE_id() {
		return e_id;
	}
	public void setE_id(String e_id) {
		this.e_id = e_id;
	}
	public int getWork_note_month() {
		return work_note_month;
	}
	public void setWork_note_month(int work_note_month) {
		this.work_note_month = work_note_month;
	}
	public int getOut_note_month() {
		return out_note_month;
	}
	public void setOut_note_month(int out_note_month) {
		this.out_note_month = out_note_month;
	}
	public int getOver_note_month() {
		return over_note_month;
	}
	public void setOver_note_month(int over_note_month) {
		this.over_note_month = over_note_month;
	}
	public int getOff_note_month() {
		return off_note_month;
	}
	public void setOff_note_month(int off_note_month) {
		this.off_note_month = off_note_month;
	}
	
}
