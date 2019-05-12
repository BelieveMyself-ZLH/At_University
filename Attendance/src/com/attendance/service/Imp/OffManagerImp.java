package com.attendance.service.Imp;

import java.util.List;

import com.attendance.dao.Imp.OffRecordDaoImp;
import com.attendance.javabean.OffRecord;
import com.attendance.service.In.OffManager;

public class OffManagerImp implements OffManager{

	@Override
	public List<OffRecord> getOffRecord() {
		// TODO Auto-generated method stub
		return new OffRecordDaoImp().getAllRecord();
	}

}
