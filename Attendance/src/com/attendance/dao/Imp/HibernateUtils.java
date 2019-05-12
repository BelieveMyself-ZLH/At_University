package com.attendance.dao.Imp;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * hibernate ���ӹ�����
 * @author Administrator
 * @1.����sessionFactory
 * @2.��sessionFactory.openSession()
 * @3.�ر�session
 *
 */

public class HibernateUtils {
	// @�������ݿ�
		// ��һ��:��ȡHibernate�������ļ� hibernamte.cfg.xml�ļ�
		// �ڶ���:��������ע�ṹ��������ͨ�����ö����м������е�������Ϣ
		// SessionFactory�ӿڸ����ʼ��Hibernate�����䵱���ݴ洢Դ�Ĵ��������𴴽�Session���������õ��˹���ģʽ��
	private static SessionFactory sessionFactory;
	static{
//		 1��ʵ����Configuration����Ĭ�϶�ȡsrcĿ¼�µ�hibernate.cfg.xml�������ļ�
		sessionFactory=new Configuration().configure().buildSessionFactory();
		System.out.println("��ʼ���ɹ�");
	}
	public static SessionFactory getSessionFactory(){
		return sessionFactory;
	}
	public static Session getSession(){
		return sessionFactory.openSession();
	}
	/**
	 * �ر�Session
	 */
	public static void close(Session session){
		if (session!=null) {
			if (session.isOpen()) {
				session.close();
			}
		}
	}
}
