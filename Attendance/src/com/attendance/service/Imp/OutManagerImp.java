package com.attendance.service.Imp;

import java.util.List;

import com.attendance.dao.Imp.OutRecordDaoImp;
import com.attendance.javabean.OutRecord;
import com.attendance.service.In.OutManager;

public class OutManagerImp implements OutManager{

	@Override
	public List<OutRecord> getAllOutRecord() {
		// TODO Auto-generated method stub
		return new OutRecordDaoImp().getAllRecord();
	}
}
