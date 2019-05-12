package com.attendance.dao.Imp;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.attendance.dao.In.MRecordDao;
import com.attendance.javabean.MonthRecord;

import net.sf.json.JSONArray;

public class MRecordDaoImp implements MRecordDao{

	@Override
	public List<MonthRecord> getAllRecord() {
		List<MonthRecord> list=null;
		Session session=null;
		try {
			session=HibernateUtils.getSession();
			session.beginTransaction();
			Query query=session.createQuery("from MonthRecord");
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
		MRecordDaoImp mRecordDaoImp=new MRecordDaoImp();
		JSONArray jsonArray=JSONArray.fromObject(mRecordDaoImp.getAllRecord());
		System.out.println(jsonArray);
	}

}
