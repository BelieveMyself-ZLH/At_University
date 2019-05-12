package com.attendance.dao.In;

import java.util.List;

import com.attendance.javabean.AttendanceRecord;

public interface ARecordDao {
	/**
	 * 得到所有员工的出勤记录
	 * @return
	 */
	public List<AttendanceRecord> getAllARecord();
}
