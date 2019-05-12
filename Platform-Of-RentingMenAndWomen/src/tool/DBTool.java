package tool;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class DBTool {
 public static SqlSessionFactory sessionFactory;
 
 static{
	 
	 try{
		 //ʹ��MyBatis�ṩ��Resources�����mybatis�������ļ�
		 Reader reader=Resources.getResourceAsReader("conf.xml");
		 //����sqlSession�Ĺ���
		 sessionFactory =new SqlSessionFactoryBuilder().build(reader);
	 }catch(Exception e){
		 e.printStackTrace();
	 }
 }//static
 
 public static SqlSession getSeesion(){
	 return sessionFactory.openSession();
 }//SqlSession
}
