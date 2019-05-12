<<<<<<< HEAD
package cdu_pfms.database.idao;

import java.util.List;

import org.apache.ibatis.annotations.*;

import cdu_pfms.database.data.Account;
import cdu_pfms.database.data.Account1;

/**
 * 数据库账号信息表访问接口
 * @author Wh
 * @createTime 2018年11月12日上午10:41:17
 * @lastTime 2018年11月12日上午10:41:17
 * @version 1.0.0
 */
public interface AccountMapper {

	/*@Result(property="userId", column="user_id",
					one=@One(select="com.demo.database.idao.UserMapper.queryById"))*/
	@Results(id="AccountInfoResult",value= {
			@Result(property="accountId", column="account_id", id=true),
			@Result(property="accountPassword", column="account_password"),
			@Result(property="accountBalance", column="account_balance"),
			@Result(property="accountState", column="account_state"),
			@Result(property="accountCreateTime", column="account_createtime"),
			@Result(property="userId", column="user_id")
	})
	@Select("select * from tab_account_info oder by account_id")
	public List<Account> queryall() throws Exception;
	
	@Select("select * from tab_account_info where account_id=#{accountId}")
	public Account queryByAccount(String accountId) throws Exception;
	
	/**
	 * 用户注册账号
	 * @param account
	 * @return
	 * @throws Exception
	 */
	@Insert("insert into tab_account_info(account_id,user_id,account_password,account_state,"
			+ "account_balance,account_createtime) values(#{accountId},#{userId},#{accountPassword},"
			+ "#{accountState},#{accountBalance},#{accountCreateTime})")
	public void enroll(Account account) throws Exception;
	
	/**
	 * 用户登录
	 * @param accountId
	 * @param accountPassword
	 * @return
	 * @throws Exception
	 */
	@ResultMap("AccountInfoResult")
	@Select("select * from tab_account_info where account_id=#{accountId} and account_password=#{accountPassword}")
	public Account queryByLogin(@Param("accountId") String accountId,
			@Param("accountPassword") String accountPassword) throws Exception;

	/**
	 * 查看所有账号信息
	 * @return
	 * @throws Exception
	 */
	public String queryAll() throws Exception;
	
	/**
	 * 用户修改密码
	 * @param accountPassword
	 * @return
	 * @throws Exception
	 */
	@Update("update tab_account_info set account_password=#{accountPassword} "
			+ "where account_id=#{accountId}")
	public void updatePassword(@Param("accountId")String accountId,@Param("accountPassword")String accountPassword) throws Exception;
	

//	@Select("select ")
//	public double getBalance(String accountId) throws Exception;
	@Results(id="AccInfoResult",value= {
			@Result(property="accountId", column="account_id", id=true),
			@Result(property="accountPassword", column="account_password"),
			@Result(property="accountBalance", column="account_balance"),
			@Result(property="accountState", column="account_state"),
			@Result(property="accountCreateTime", column="account_createtime"),
			@Result(property="userId", column="user_id")
	})
	/**
	 * 通过用户账号名查找账号信息
	 * @author ZhouLinHu
	 * @param accountId
	 * @return
	 * @throws Exception
	 */
	@Select("select * from tab_account_info where account_id=#{accountId}")
	public Account queryAccById(@Param("accountId")String accountId) throws Exception;
	/**
	 * 对账户中的金额进行修改
	 * @author ZhouLinHu
	 * @param accountId
	 * @param balance
	 * @throws Exception
	 */
	@Update("update tab_account_info set account_balance=#{balance} where account_id=#{accountId}")
	public void updateBalance(@Param("accountId")String accountId, @Param("balance")double balance) throws Exception;
	 
	
	@Results(id="AccountInfoResults",value= {
			@Result(property="accountId", column="account_id", id=true),
			@Result(property="accountPassword", column="account_password"),
			@Result(property="accountBalance", column="account_balance"),
			@Result(property="accountState", column="account_state"),
			@Result(property="accountCreateTime", column="account_createtime"),
			@Result(property="user", column="user_id",
					one=@One(select="cdu_pfms.database.idao.UserMapper.queryById"))
			
	})
	//查询所有分页
//		@ResultMap("AccountInfoResults")
		@Select("select * from tab_account_info order by account_id limit #{startIndex},#{maxRowCount}")
		List<Account1> queryByPage(@Param("startIndex") Integer startIndex,
								  @Param("maxRowCount") Integer maxRowCount) throws Exception;
	   //id查询所有分页
		@ResultMap("AccountInfoResults")
	    @Select("select * from tab_account_info where account_id=#{accountId} order by account_id limit #{startIndex},#{maxRowCount}")
	    Account1 queryByIdPage( @Param("accountId") String accountId, @Param("startIndex") Integer startIndex,
                @Param("maxRowCount") Integer maxRowCount) throws Exception;
	   //得到查询的行数  byState
		@Select("select count(*) from tab_account_info where " +
				" account_state=#{accountState} and account_id like '%${accountId}%' ")
		int getRowCountByState(@Param("accountId") String accountId,
						@Param("accountState") Integer accountState);

		//得到查询的行数 byId
		@Select("select count(*) from tab_account_info where account_id like '%${accountId}%' ")
		int getRowCount(@Param("accountId") String accountId);

		//查询冻结和开启 byID
		@ResultMap("AccountInfoResults")
		@Select("select * from tab_account_info where account_state=#{accountState} and " +
				" account_id=#{accountId} order by account_id limit #{startIndex},#{maxRowCount}")
		List<Account1> queryFrozenById(@Param("accountId") String accountId,
									  @Param("accountState") Integer state,
									  @Param("startIndex") Integer startIndex,
								  @Param("maxRowCount") Integer maxRowCount) throws Exception;

		@ResultMap("AccountInfoResults")
		@Select("select * from tab_account_info where account_state=0" +
				" order by account_id limit #{startIndex},#{maxRowCount}")
		List<Account1> queryFrozenByPage(@Param("startIndex") Integer startIndex,
											  @Param("maxRowCount") Integer maxRowCount) throws Exception;
		@ResultMap("AccountInfoResults")
		@Select("select * from tab_account_info where account_state=1" +
				" order by account_id limit #{startIndex},#{maxRowCount}")
		List<Account1> queryOpendByPage(@Param("startIndex") Integer startIndex,
										@Param("maxRowCount") Integer maxRowCount) throws Exception;

		@ResultMap("AccountInfoResults")
		@Select("select * from tab_account_info where account_state=1 order by account_id limit #{startIndex},#{maxRowCount}")
		List<Account1> queryOpenedByPagenumber(@Param("startIndex") Integer startIndex,
											  @Param("maxRowCount") Integer maxRowCount) throws Exception;
	
		
		/**
		 * 查看某一用户的账号信息
		 * @param accountId
		 * @return
		 * @throws Exception
		 */
		@ResultMap("AccountInfoResults")
		@Select("select * from tab_account_info where account_id=#{accountId}")
		 Account1 queryById(String accountId) throws Exception;
		
		
		/**
		 * 冻结或解冻账号
		 * @param accountId
		 * @return
		 * @throws Exception
		 */
		@Update("update tab_account_info set account_state=#{accountState} "
				+ "where account_id=#{accountId}")
		void updateState(@Param("accountId") String accountId,@Param("accountState") Integer accountState) throws Exception;

}
=======
package cdu_pfms.database.idao;

import java.util.List;

import org.apache.ibatis.annotations.*;

import cdu_pfms.database.data.Account;
import cdu_pfms.database.data.Account1;

/**
 * 数据库账号信息表访问接口
 * @author Wh
 * @createTime 2018年11月12日上午10:41:17
 * @lastTime 2018年11月12日上午10:41:17
 * @version 1.0.0
 */
public interface AccountMapper {

	/*@Result(property="userId", column="user_id",
					one=@One(select="com.demo.database.idao.UserMapper.queryById"))*/
	@Results(id="AccountInfoResult",value= {
			@Result(property="accountId", column="account_id", id=true),
			@Result(property="accountPassword", column="account_password"),
			@Result(property="accountBalance", column="account_balance"),
			@Result(property="accountState", column="account_state"),
			@Result(property="accountCreateTime", column="account_createtime"),
			@Result(property="userId", column="user_id")
	})
	@Select("select * from tab_account_info oder by account_id")
	public List<Account> queryall() throws Exception;
	
	@Select("select * from tab_account_info where account_id=#{accountId}")
	public Account queryByAccount(String accountId) throws Exception;
	
	/**
	 * 用户注册账号
	 * @param account
	 * @return
	 * @throws Exception
	 */
	@Insert("insert into tab_account_info(account_id,user_id,account_password,account_state,"
			+ "account_balance,account_createtime) values(#{accountId},#{userId},#{accountPassword},"
			+ "#{accountState},#{accountBalance},#{accountCreateTime})")
	public void enroll(Account account) throws Exception;
	
	/**
	 * 用户登录
	 * @param accountId
	 * @param accountPassword
	 * @return
	 * @throws Exception
	 */
	@ResultMap("AccountInfoResult")
	@Select("select * from tab_account_info where account_id=#{accountId} and account_password=#{accountPassword}")
	public Account queryByLogin(@Param("accountId") String accountId,
			@Param("accountPassword") String accountPassword) throws Exception;

	/**
	 * 查看所有账号信息
	 * @return
	 * @throws Exception
	 */
	public String queryAll() throws Exception;
	
	/**
	 * 用户修改密码
	 * @param accountPassword
	 * @return
	 * @throws Exception
	 */
	@Update("update tab_account_info set account_password=#{accountPassword} "
			+ "where account_id=#{accountId}")
	public void updatePassword(@Param("accountId")String accountId,@Param("accountPassword")String accountPassword) throws Exception;
	

//	@Select("select ")
//	public double getBalance(String accountId) throws Exception;
	@Results(id="AccInfoResult",value= {
			@Result(property="accountId", column="account_id", id=true),
			@Result(property="accountPassword", column="account_password"),
			@Result(property="accountBalance", column="account_balance"),
			@Result(property="accountState", column="account_state"),
			@Result(property="accountCreateTime", column="account_createtime"),
			@Result(property="userId", column="user_id")
	})
	/**
	 * 通过用户账号名查找账号信息
	 * @author ZhouLinHu
	 * @param accountId
	 * @return
	 * @throws Exception
	 */
	@Select("select * from tab_account_info where account_id=#{accountId}")
	public Account queryAccById(@Param("accountId")String accountId) throws Exception;
	/**
	 * 对账户中的金额进行修改
	 * @author ZhouLinHu
	 * @param accountId
	 * @param balance
	 * @throws Exception
	 */
	@Update("update tab_account_info set account_balance=#{balance} where account_id=#{accountId}")
	public void updateBalance(@Param("accountId")String accountId, @Param("balance")double balance) throws Exception;
	 
	
	@Results(id="AccountInfoResults",value= {
			@Result(property="accountId", column="account_id", id=true),
			@Result(property="accountPassword", column="account_password"),
			@Result(property="accountBalance", column="account_balance"),
			@Result(property="accountState", column="account_state"),
			@Result(property="accountCreateTime", column="account_createtime"),
			@Result(property="user", column="user_id",
					one=@One(select="cdu_pfms.database.idao.UserMapper.queryById"))
			
	})
	//查询所有分页
//		@ResultMap("AccountInfoResults")
		@Select("select * from tab_account_info order by account_id limit #{startIndex},#{maxRowCount}")
		List<Account1> queryByPage(@Param("startIndex") Integer startIndex,
								  @Param("maxRowCount") Integer maxRowCount) throws Exception;
	   //id查询所有分页
		@ResultMap("AccountInfoResults")
	    @Select("select * from tab_account_info where account_id=#{accountId} order by account_id limit #{startIndex},#{maxRowCount}")
	    Account1 queryByIdPage( @Param("accountId") String accountId, @Param("startIndex") Integer startIndex,
                @Param("maxRowCount") Integer maxRowCount) throws Exception;
	   //得到查询的行数  byState
		@Select("select count(*) from tab_account_info where " +
				" account_state=#{accountState} and account_id like '%${accountId}%' ")
		int getRowCountByState(@Param("accountId") String accountId,
						@Param("accountState") Integer accountState);

		//得到查询的行数 byId
		@Select("select count(*) from tab_account_info where account_id like '%${accountId}%' ")
		int getRowCount(@Param("accountId") String accountId);

		//查询冻结和开启 byID
		@ResultMap("AccountInfoResults")
		@Select("select * from tab_account_info where account_state=#{accountState} and " +
				" account_id=#{accountId} order by account_id limit #{startIndex},#{maxRowCount}")
		List<Account1> queryFrozenById(@Param("accountId") String accountId,
									  @Param("accountState") Integer state,
									  @Param("startIndex") Integer startIndex,
								  @Param("maxRowCount") Integer maxRowCount) throws Exception;

		@ResultMap("AccountInfoResults")
		@Select("select * from tab_account_info where account_state=0" +
				" order by account_id limit #{startIndex},#{maxRowCount}")
		List<Account1> queryFrozenByPage(@Param("startIndex") Integer startIndex,
											  @Param("maxRowCount") Integer maxRowCount) throws Exception;
		@ResultMap("AccountInfoResults")
		@Select("select * from tab_account_info where account_state=1" +
				" order by account_id limit #{startIndex},#{maxRowCount}")
		List<Account1> queryOpendByPage(@Param("startIndex") Integer startIndex,
										@Param("maxRowCount") Integer maxRowCount) throws Exception;

		@ResultMap("AccountInfoResults")
		@Select("select * from tab_account_info where account_state=1 order by account_id limit #{startIndex},#{maxRowCount}")
		List<Account1> queryOpenedByPagenumber(@Param("startIndex") Integer startIndex,
											  @Param("maxRowCount") Integer maxRowCount) throws Exception;
	
		
		/**
		 * 查看某一用户的账号信息
		 * @param accountId
		 * @return
		 * @throws Exception
		 */
		@ResultMap("AccountInfoResults")
		@Select("select * from tab_account_info where account_id=#{accountId}")
		 Account1 queryById(String accountId) throws Exception;
		
		
		/**
		 * 冻结或解冻账号
		 * @param accountId
		 * @return
		 * @throws Exception
		 */
		@Update("update tab_account_info set account_state=#{accountState} "
				+ "where account_id=#{accountId}")
		void updateState(@Param("accountId") String accountId,@Param("accountState") Integer accountState) throws Exception;

}
>>>>>>> second commit
