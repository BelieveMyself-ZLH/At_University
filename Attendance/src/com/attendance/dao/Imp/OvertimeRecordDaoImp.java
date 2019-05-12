package com.attendance.dao.Imp;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.attendance.dao.In.OvertimeRecordDao;
import com.attendance.javabean.OvertimeRecord;

import net.sf.json.JSONArray;

public class OvertimeRecordDaoImp implements OvertimeRecordDao{

	@Override
	public List<OvertimeRecord> getAllRecord() {
		List<OvertimeRecord> list=null;
		Session session=null;
		try {
			session=HibernateUtils.getSession();
			session.beginTransaction();
			Query query=session.createQuery("from OvertimeRecord");
			list=query.list();
			session.getTransaction().commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			session.getTransaction().rollback();
		}finally {
			HibernateUtils.close(session);
		}
		return list;
	}
	
	/**
	 * 用于测试的main方法
	 */
	public static void main(String[] args) {
		OvertimeRecordDaoImp overtimeRecordDaoImp=new OvertimeRecordDaoImp();
		JSONArray jsonArray=JSONArray.fromObject(overtimeRecordDaoImp.getAllRecord());
		System.out.println(jsonArray);
	}

}
