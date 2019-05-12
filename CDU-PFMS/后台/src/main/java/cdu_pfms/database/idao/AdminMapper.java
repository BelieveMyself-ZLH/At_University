<<<<<<< HEAD
package cdu_pfms.database.idao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import cdu_pfms.database.data.Admin;

public interface AdminMapper {
	@Results(id="AdminInfoResults",value= {
			@Result(property="adminId", column="admin_id", id=true),
			@Result(property="adminName", column="admin_name"),
			@Result(property="adminPassword", column="admin_password"),
			@Result(property="adminOperTime", column="admin_oper_time")
			})
	
	/**
	 * 查询管理员信息
	 * @return
	 * @throws Exception
	 */
	@Select("select * from tab_admin_info where admin_id=#{adminId}")
	public List<Admin> queryAll() throws Exception;
	
	/**
	 * 管理员登录
	 * @param adminName
	 * @param adminPassword
	 * @return
	 * @throws Exception
	 */
	@ResultMap("AdminInfoResults")
	@Select("select * from tab_admin_info where admin_name=#{accountId} and "
			+ "admin_password=#{accountPassword}")
	public Admin queryByLogin(@Param("accountId") String accountId,
				@Param("accountPassword") String accountPassword) throws Exception;
	
	/**
	 * 添加管理员
	 * @param admin
	 * @throws Exception
	 */
	@Insert("insert into tab_admin_info(admin_id,admin_name,"
			+ "admin_password,admin_oper_time) values(#{adminId},"
			+ "#{adminName},#{adminPassword},#{adminOperTime})")
	public String add(Admin admin) throws Exception;
	
	/**
	 *  删除管理员
	 * @param adminId
	 * @throws Exception
	 */
	@Delete("delete from tab_admin_info where admin_id=#{adminId}")
	public String delete(Integer adminId) throws Exception;
	
	/**
	 *  修改管理员信息
	 * @param admin
	 * @throws Exception
	 */
	@Update("update tab_admin_info set admin_id=#{adminId},admin_name=#{adminName},"
			+ "admin_password=#{adminPassword},admin_oper_time=#{adminOperTime}")
	public String update(Admin admin) throws Exception;
}
=======
package cdu_pfms.database.idao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import cdu_pfms.database.data.Admin;

public interface AdminMapper {
	@Results(id="AdminInfoResults",value= {
			@Result(property="adminId", column="admin_id", id=true),
			@Result(property="adminName", column="admin_name"),
			@Result(property="adminPassword", column="admin_password"),
			@Result(property="adminOperTime", column="admin_oper_time")
			})
	
	/**
	 * 查询管理员信息
	 * @return
	 * @throws Exception
	 */
	@Select("select * from tab_admin_info where admin_id=#{adminId}")
	public List<Admin> queryAll() throws Exception;
	
	/**
	 * 管理员登录
	 * @param adminName
	 * @param adminPassword
	 * @return
	 * @throws Exception
	 */
	@ResultMap("AdminInfoResults")
	@Select("select * from tab_admin_info where admin_name=#{accountId} and "
			+ "admin_password=#{accountPassword}")
	public Admin queryByLogin(@Param("accountId") String accountId,
				@Param("accountPassword") String accountPassword) throws Exception;
	
	/**
	 * 添加管理员
	 * @param admin
	 * @throws Exception
	 */
	@Insert("insert into tab_admin_info(admin_id,admin_name,"
			+ "admin_password,admin_oper_time) values(#{adminId},"
			+ "#{adminName},#{adminPassword},#{adminOperTime})")
	public String add(Admin admin) throws Exception;
	
	/**
	 *  删除管理员
	 * @param adminId
	 * @throws Exception
	 */
	@Delete("delete from tab_admin_info where admin_id=#{adminId}")
	public String delete(Integer adminId) throws Exception;
	
	/**
	 *  修改管理员信息
	 * @param admin
	 * @throws Exception
	 */
	@Update("update tab_admin_info set admin_id=#{adminId},admin_name=#{adminName},"
			+ "admin_password=#{adminPassword},admin_oper_time=#{adminOperTime}")
	public String update(Admin admin) throws Exception;
}
>>>>>>> second commit
