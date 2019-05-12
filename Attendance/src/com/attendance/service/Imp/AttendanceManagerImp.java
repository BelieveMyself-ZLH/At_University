package com.attendance.service.Imp;

import java.util.List;

import com.attendance.dao.Imp.ARecordDaoImp;
import com.attendance.javabean.AttendanceRecord;
import com.attendance.service.In.AttendanceManager;

public class AttendanceManagerImp implements AttendanceManager{

	@Override
	public List<AttendanceRecord> getAttenRecord() {
		
		return new ARecordDaoImp().getAllARecord();
	}

}
