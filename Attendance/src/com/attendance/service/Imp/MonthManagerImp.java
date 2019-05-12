package com.attendance.service.Imp;

import java.util.List;

import com.attendance.dao.Imp.MRecordDaoImp;
import com.attendance.javabean.MonthRecord;
import com.attendance.service.In.MonthManager;

public class MonthManagerImp implements MonthManager{

	@Override
	public List<MonthRecord> getAllMonthRecord() {
		// TODO Auto-generated method stub
		return new MRecordDaoImp().getAllRecord();
	}

}
