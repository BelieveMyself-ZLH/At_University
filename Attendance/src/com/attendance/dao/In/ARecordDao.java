package com.attendance.dao.In;

import java.util.List;

import com.attendance.javabean.AttendanceRecord;

public interface ARecordDao {
	/**
	 * �õ�����Ա���ĳ��ڼ�¼
	 * @return
	 */
	public List<AttendanceRecord> getAllARecord();
}
