<<<<<<< HEAD
package com.demo.database.idao;

import java.util.List;

import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.demo.database.data.TDemoUser;

/**
 * 用户表数据访问接口
 * @author Teacher
 * @createTime 2018年10月12日 下午3:10:57
 * @lastTime 2018年10月12日 下午3:10:57
 * @version 1.0.0
 */
public interface TDemoUserMapper {

	/**
	 * 登录验证查询
	 * @param userName
	 * @param password
	 * @return
	 * @throws Exception
	 */
	@Results(id="TDemoUserResults", value={
			@Result(property="userId", column="user_id", id=true),
			@Result(property="userName", column="user_name"),
			@Result(property="userPassword", column="user_password"),
			@Result(property="userGender", column="user_gender"),
			@Result(property="userInTime", column="user_in_time"),
			@Result(property="operTime", column="oper_time"),
			@Result(property="TDemoDept", column="dept_id", 
			    one=@One(select="com.demo.database.idao.TDemodeptMapper.getById"))
	})
	@Select("select * from t_demo_user where user_name=#{userName} and user_password=#{password}")
	public TDemoUser queryByLogin(@Param("userName") String userName,
			@Param("password") String password) throws Exception;
	
	@ResultMap("TDemoUserResults")
	@Select("select * from t_demo_user order by oper_time desc")
	public List<TDemoUser> queryAll() throws Exception;
	
	@ResultMap("TDemoUserResults")
	@Select("select * from t_demo_user where dept_id=#{deptId} order by oper_time desc")
	public List<TDemoUser> queryByDeptId(Integer deptId) throws Exception;
	
}













=======
package com.demo.database.idao;

import java.util.List;

import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.demo.database.data.TDemoUser;

/**
 * 用户表数据访问接口
 * @author Teacher
 * @createTime 2018年10月12日 下午3:10:57
 * @lastTime 2018年10月12日 下午3:10:57
 * @version 1.0.0
 */
public interface TDemoUserMapper {

	/**
	 * 登录验证查询
	 * @param userName
	 * @param password
	 * @return
	 * @throws Exception
	 */
	@Results(id="TDemoUserResults", value={
			@Result(property="userId", column="user_id", id=true),
			@Result(property="userName", column="user_name"),
			@Result(property="userPassword", column="user_password"),
			@Result(property="userGender", column="user_gender"),
			@Result(property="userInTime", column="user_in_time"),
			@Result(property="operTime", column="oper_time"),
			@Result(property="TDemoDept", column="dept_id", 
			    one=@One(select="com.demo.database.idao.TDemodeptMapper.getById"))
	})
	@Select("select * from t_demo_user where user_name=#{userName} and user_password=#{password}")
	public TDemoUser queryByLogin(@Param("userName") String userName,
			@Param("password") String password) throws Exception;
	
	@ResultMap("TDemoUserResults")
	@Select("select * from t_demo_user order by oper_time desc")
	public List<TDemoUser> queryAll() throws Exception;
	
	@ResultMap("TDemoUserResults")
	@Select("select * from t_demo_user where dept_id=#{deptId} order by oper_time desc")
	public List<TDemoUser> queryByDeptId(Integer deptId) throws Exception;
	
}













>>>>>>> second commit
