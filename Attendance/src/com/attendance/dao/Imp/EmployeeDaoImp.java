package com.attendance.dao.Imp;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.attendance.dao.In.EmployeeDao;
import com.attendance.javabean.EmployeeInformation;

import net.sf.json.JSONArray;

public class EmployeeDaoImp implements EmployeeDao{

	public static final String findAll1="from EmployeeInformation";
	@Override
	public List<EmployeeInformation> getAllEmployeeInf() {
		List<EmployeeInformation> list=null;
		Session session=null;
		try {
			session=HibernateUtils.getSession();
			session.beginTransaction();
//			参数是  映射的类名
			Query query=session.createQuery(findAll1);
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
	

	@Override
	public boolean isLogo(String username,String password) {
		List<EmployeeInformation> list=getAllEmployeeInf();
		for (EmployeeInformation employeeInformation : list) {
			String e_id=employeeInformation.getE_id();
			String e_password=employeeInformation.getE_password();
			if (e_id.equals(username)&&e_password.equals(password)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public int getTotalPage(int rowsPerPage) {
		List<EmployeeInformation> list=null;
		Session session=null;
		try {
			session=HibernateUtils.getSession();
			session.beginTransaction();
			Query query=session.createQuery("select count(*) from EmployeeInformation");
			int totalRows=((Long)query.iterate().next()).intValue();
			return (totalRows+rowsPerPage-1)/rowsPerPage;
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return 0;
	}


	@Override
	public List<EmployeeInformation> getAllEmployeeInf(int page, int rowsPerPage) {
		List<EmployeeInformation> list=null;
		Session session=null;
		try {
			session=HibernateUtils.getSession();
			Query query=session.createQuery(findAll1);
//			query.setInteger(1, (page-1)*rowsPerPage);
//			query.setInteger(2, rowsPerPage);
			query.setFirstResult((page-1)*rowsPerPage);
			query.setMaxResults(rowsPerPage);
			list=query.getResultList();
//			session.getTransaction().commit();
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
	 * 测试的main
	 */
	public static void main(String[] args) {
		EmployeeDaoImp employeeDaoImp=new EmployeeDaoImp();
		
		List<EmployeeInformation> list=employeeDaoImp.getAllEmployeeInf(2, 10);
		JSONArray jsonArray=JSONArray.fromObject(list);
		System.out.println(jsonArray);
		System.out.println("\n\n");
		list=employeeDaoImp.getAllEmployeeInf(3, 10);
		jsonArray=JSONArray.fromObject(list);
		System.out.println(jsonArray);
		System.out.println(employeeDaoImp.isLogo("8888", "1234"));
		System.out.println(employeeDaoImp.getTotalPage(10));
	}


}
