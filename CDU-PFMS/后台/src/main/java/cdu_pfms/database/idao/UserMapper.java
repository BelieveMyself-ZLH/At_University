<<<<<<< HEAD
package cdu_pfms.database.idao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import cdu_pfms.database.data.User;

/**
 * 数据库用户表访问接口
 * 
 * @author Wh
 * @createTime 2018年10月29日下午2:08:47
 * @lastTime 2018年10月29日下午2:08:47
 * @version 1.0.0
 */
@Mapper
public interface UserMapper {

	@Results(id = "UserInfoResults", value = { 
			@Result(property = "userId", column = "user_id", id = true),
			@Result(property = "userName", column = "user_name"),
			@Result(property = "userGender", column = "user_gender"),
			@Result(property = "userBirthday", column = "user_birthday"),
			@Result(property = "userAddress", column = "user_address"),
			@Result(property = "userPhone", column = "user_phone"),
			@Result(property = "userIdcard", column = "user_idcard"),
			@Result(property = "userMailbox", column = "user_mailbox") 
	})


	/**
	 * 管理员查询所有用户
	 * 
	 * @return
	 * @throws Exception
	 */
	@Select("select * from tab_user_info order by user_id")
	public List<User> queryAllUser() throws Exception;

	/**
	 * 查询用户信息
	 * 
	 * @param userId
	 * @throws Exception
	 */
	@ResultMap("UserInfoResults")
	@Select("select * from tab_user_info where user_id=#{userId}")
	public User queryById(Integer userId) throws Exception;

	/**
	 * 用户注册
	 * 
	 * @param user
	 * @throws Exception
	 */
	@Insert("insert into tab_user_info(user_name,user_gender,"
			+ "user_birthday,user_address,user_phone,user_idcard,user_mailbox) values(#{userName},"
			+ "#{userGender},#{userBirthday},#{userAddress},#{userPhone},#{userIdcard},#{userMailbox})")
	public void enroll(User user) throws Exception;

	/**
	 * 通过姓名取得uerId
	 */
	@Select("select user_id from tab_user_info where user_name=#{userName} and user_mailbox=#{userMailbox}")
	public int getId(User user) throws Exception;
	/**
	 * 用户修改个人信息
	 * 
	 * @param user
	 * @throws Exception
	 */
	@Update("update tab_user_info set user_name=#{userName},user_gender=#{userGender},"
			+ "user_birthday=#{userBirthday},user_address=#{userAddress},"
			+ "user_phone=#{userPhone},user_idcard=#{userIdcard},"
			+ "user_mailbox=#{userMailbox} "
			+ "where user_id=#{userId}")
	public void update(User user) throws Exception;

}
=======
package cdu_pfms.database.idao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import cdu_pfms.database.data.User;

/**
 * 数据库用户表访问接口
 * 
 * @author Wh
 * @createTime 2018年10月29日下午2:08:47
 * @lastTime 2018年10月29日下午2:08:47
 * @version 1.0.0
 */
@Mapper
public interface UserMapper {

	@Results(id = "UserInfoResults", value = { 
			@Result(property = "userId", column = "user_id", id = true),
			@Result(property = "userName", column = "user_name"),
			@Result(property = "userGender", column = "user_gender"),
			@Result(property = "userBirthday", column = "user_birthday"),
			@Result(property = "userAddress", column = "user_address"),
			@Result(property = "userPhone", column = "user_phone"),
			@Result(property = "userIdcard", column = "user_idcard"),
			@Result(property = "userMailbox", column = "user_mailbox") 
	})


	/**
	 * 管理员查询所有用户
	 * 
	 * @return
	 * @throws Exception
	 */
	@Select("select * from tab_user_info order by user_id")
	public List<User> queryAllUser() throws Exception;

	/**
	 * 查询用户信息
	 * 
	 * @param userId
	 * @throws Exception
	 */
	@ResultMap("UserInfoResults")
	@Select("select * from tab_user_info where user_id=#{userId}")
	public User queryById(Integer userId) throws Exception;

	/**
	 * 用户注册
	 * 
	 * @param user
	 * @throws Exception
	 */
	@Insert("insert into tab_user_info(user_name,user_gender,"
			+ "user_birthday,user_address,user_phone,user_idcard,user_mailbox) values(#{userName},"
			+ "#{userGender},#{userBirthday},#{userAddress},#{userPhone},#{userIdcard},#{userMailbox})")
	public void enroll(User user) throws Exception;

	/**
	 * 通过姓名取得uerId
	 */
	@Select("select user_id from tab_user_info where user_name=#{userName} and user_mailbox=#{userMailbox}")
	public int getId(User user) throws Exception;
	/**
	 * 用户修改个人信息
	 * 
	 * @param user
	 * @throws Exception
	 */
	@Update("update tab_user_info set user_name=#{userName},user_gender=#{userGender},"
			+ "user_birthday=#{userBirthday},user_address=#{userAddress},"
			+ "user_phone=#{userPhone},user_idcard=#{userIdcard},"
			+ "user_mailbox=#{userMailbox} "
			+ "where user_id=#{userId}")
	public void update(User user) throws Exception;

}
>>>>>>> second commit
