package com.attendance.dao.Imp;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.attendance.dao.In.OffRecordDao;
import com.attendance.javabean.OffRecord;

import net.sf.json.JSONArray;

public class OffRecordDaoImp implements OffRecordDao{

	@Override
	public List<OffRecord> getAllRecord() {
		List<OffRecord> list=null;
		Session session=null;
		try {
			session=HibernateUtils.getSession();
			session.beginTransaction();
			Query query=session.createQuery("from OffRecord");
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
		OffRecordDaoImp offRecordDaoImp=new OffRecordDaoImp();
		JSONArray jsonArray=JSONArray.fromObject(offRecordDaoImp.getAllRecord());
		System.out.println(jsonArray);
	}
}
