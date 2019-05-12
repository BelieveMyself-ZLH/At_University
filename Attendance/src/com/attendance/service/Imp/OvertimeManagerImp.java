package com.attendance.service.Imp;

import java.util.List;

import com.attendance.dao.Imp.OvertimeRecordDaoImp;
import com.attendance.javabean.OvertimeRecord;
import com.attendance.service.In.OvertimeManager;

public class OvertimeManagerImp implements OvertimeManager{

	@Override
	public List<OvertimeRecord> getAllORecord() {
		// TODO Auto-generated method stub
		return new OvertimeRecordDaoImp().getAllRecord();
	}

}
