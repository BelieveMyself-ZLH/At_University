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
		 //使用MyBatis提供的Resources类加载mybatis的配置文件
		 Reader reader=Resources.getResourceAsReader("conf.xml");
		 //构建sqlSession的工厂
		 sessionFactory =new SqlSessionFactoryBuilder().build(reader);
	 }catch(Exception e){
		 e.printStackTrace();
	 }
 }//static
 
 public static SqlSession getSeesion(){
	 return sessionFactory.openSession();
 }//SqlSession
}
