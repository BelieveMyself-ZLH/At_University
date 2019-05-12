package com.attendance.dao.Imp;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.attendance.dao.In.OutRecordDao;
import com.attendance.javabean.OutRecord;

import net.sf.json.JSONArray;

public class OutRecordDaoImp implements OutRecordDao{

	@Override
	public List getAllRecord() {
		List<OutRecord> list=null;
		Session session=null;
		try {
			session=HibernateUtils.getSession();
			session.beginTransaction();
			Query query=session.createQuery("from OutRecord");
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
	 * 用来测试的main方法
	 */
	public static void main(String[] args) {
		OutRecordDaoImp outRecordDaoImp=new OutRecordDaoImp();
		List<OutRecord> list=outRecordDaoImp.getAllRecord();
		JSONArray jsonArray=JSONArray.fromObject(list);
		System.out.println(jsonArray);
	}
}
