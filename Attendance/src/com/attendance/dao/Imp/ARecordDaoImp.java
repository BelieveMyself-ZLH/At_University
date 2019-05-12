package com.attendance.dao.Imp;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.attendance.dao.In.ARecordDao;
import com.attendance.javabean.AttendanceRecord;

import net.sf.json.JSONArray;

public class ARecordDaoImp implements ARecordDao{

	@Override
	public List<AttendanceRecord> getAllARecord() {
		List<AttendanceRecord> list=null;
		Session session=null;
		try {
			session=HibernateUtils.getSession();
			session.beginTransaction();
			Query query=session.createQuery("from AttendanceRecord");
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
	 * 用来测试的方法main
	 * @param args
	 */
	public static void main(String[] args) {
		ARecordDaoImp aRecordDaoImp=new ARecordDaoImp();
		List<AttendanceRecord> list=aRecordDaoImp.getAllARecord();
		JSONArray jsonArray=JSONArray.fromObject(list);
		System.out.println(jsonArray);
	}

}
