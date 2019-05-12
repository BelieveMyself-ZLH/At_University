package com.attendance.dao.Imp;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * hibernate 连接工具类
 * @author Administrator
 * @1.创建sessionFactory
 * @2.打开sessionFactory.openSession()
 * @3.关闭session
 *
 */

public class HibernateUtils {
	// @连接数据库
		// 第一步:读取Hibernate的配置文件 hibernamte.cfg.xml文件
		// 第二步:创建服务注册构建器对象，通过配置对象中加载所有的配置信息
		// SessionFactory接口负责初始化Hibernate。它充当数据存储源的代理，并负责创建Session对象。这里用到了工厂模式。
	private static SessionFactory sessionFactory;
	static{
//		 1》实例化Configuration对象，默认读取src目录下的hibernate.cfg.xml，配置文件
		sessionFactory=new Configuration().configure().buildSessionFactory();
		System.out.println("初始化成功");
	}
	public static SessionFactory getSessionFactory(){
		return sessionFactory;
	}
	public static Session getSession(){
		return sessionFactory.openSession();
	}
	/**
	 * 关闭Session
	 */
	public static void close(Session session){
		if (session!=null) {
			if (session.isOpen()) {
				session.close();
			}
		}
	}
}
