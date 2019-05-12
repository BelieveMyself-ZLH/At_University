<<<<<<< HEAD
package cdu_pfms.database.idao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import cdu_pfms.database.data.AccountOper;

public interface AccountOperMapper {
	
	/**
	 * 增加一条操作信息
	 * @author ZhouLinHu
	 * @param accOper
	 * @throws Exception
	 */
	@Insert("insert into tab_oper_info(account_id,user_oper_amount,"
			+ "user_oper_type,user_oper_time,user_oper_account) values("
			+ "#{accId},#{userOperAmount},#{userOperType},#{userOperTime},#{user_OperAccount})")
	public void addOper(AccountOper accOper) throws Exception;
	
	@Results(id="OperResults", value= {
			@Result(property = "userOperId", column = "user_oper_id", id = true),
			@Result(property = "accId", column = "account_id"),
			@Result(property = "userOperAmount", column = "user_oper_amount"),
			@Result(property = "userOperType", column = "user_oper_type"),
			@Result(property = "userOperTime", column = "user_oper_time"),
			@Result(property = "user_OperAccount", column = "user_oper_account")
	})
	@Select("select * from tab_oper_info where account_id=#{accountId} order by user_oper_time desc")
	public List<AccountOper> queryAll(String accountId) throws Exception;
	
	@Select("select count(*) from tab_oper_info where account_id=#{accountId}")
	public Integer getRowCount(String accountId) throws Exception;
	
	@ResultMap("OperResults")
	@Select("select * from tab_oper_info where account_id=#{accountId} order by user_oper_time desc limit #{startIndex},#{maxRowCount}")
	public List<AccountOper> queryByPage(@Param("startIndex")Integer startIndex,
			@Param("maxRowCount")Integer maxRowCount, @Param("accountId") String accountId) throws Exception;
}
=======
package cdu_pfms.database.idao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import cdu_pfms.database.data.AccountOper;

public interface AccountOperMapper {
	
	/**
	 * 增加一条操作信息
	 * @author ZhouLinHu
	 * @param accOper
	 * @throws Exception
	 */
	@Insert("insert into tab_oper_info(account_id,user_oper_amount,"
			+ "user_oper_type,user_oper_time,user_oper_account) values("
			+ "#{accId},#{userOperAmount},#{userOperType},#{userOperTime},#{user_OperAccount})")
	public void addOper(AccountOper accOper) throws Exception;
	
	@Results(id="OperResults", value= {
			@Result(property = "userOperId", column = "user_oper_id", id = true),
			@Result(property = "accId", column = "account_id"),
			@Result(property = "userOperAmount", column = "user_oper_amount"),
			@Result(property = "userOperType", column = "user_oper_type"),
			@Result(property = "userOperTime", column = "user_oper_time"),
			@Result(property = "user_OperAccount", column = "user_oper_account")
	})
	@Select("select * from tab_oper_info where account_id=#{accountId} order by user_oper_time desc")
	public List<AccountOper> queryAll(String accountId) throws Exception;
	
	@Select("select count(*) from tab_oper_info where account_id=#{accountId}")
	public Integer getRowCount(String accountId) throws Exception;
	
	@ResultMap("OperResults")
	@Select("select * from tab_oper_info where account_id=#{accountId} order by user_oper_time desc limit #{startIndex},#{maxRowCount}")
	public List<AccountOper> queryByPage(@Param("startIndex")Integer startIndex,
			@Param("maxRowCount")Integer maxRowCount, @Param("accountId") String accountId) throws Exception;
}
>>>>>>> second commit
