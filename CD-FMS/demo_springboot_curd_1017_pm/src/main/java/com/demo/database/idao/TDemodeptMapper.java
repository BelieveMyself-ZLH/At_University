<<<<<<< HEAD
package com.demo.database.idao;

import java.util.List;

import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.demo.database.data.TDemoDept;

/**
 * 部门表数据访问接口
 * @author Teacher
 * @createTime 2018年10月15日 上午9:06:44
 * @lastTime 2018年10月15日 上午9:06:44
 * @version 1.0.0
 */
public interface TDemodeptMapper {

	@Results(id="TDemoDeptResults", value={
			@Result(property="deptId", column="dept_id", id=true),
			@Result(property="deptName", column="dept_name"),
			@Result(property="deptCreateTime", column="dept_create_time"),
			@Result(property="operTime", column="oper_time")
	})
	@Select("select * from t_demo_dept order by oper_time desc")
	public List<TDemoDept> queryAll() throws Exception;
	
	@ResultMap("TDemoDeptResults")
	@Select("select * from t_demo_dept where dept_name like '%${deptName}%' order by oper_time desc")
	public List<TDemoDept> queryByName(@Param("deptName") String deptName) throws Exception;
	
	@ResultMap("TDemoDeptResults")
	@Select("select * from t_demo_dept where dept_id=#{id}")
	public TDemoDept getById(Integer id) throws Exception;
	
	@Select("select count(*) from t_demo_dept")
	public Integer getRowCount() throws Exception;
	
	@Select("select count(*) from t_demo_dept where dept_name like '%${deptName}%'")
	public Integer getByNameRowCount(@Param("deptName") String deptName) throws Exception;
	
	@ResultMap("TDemoDeptResults")
	@Select("select * from t_demo_dept order by oper_time desc limit #{startIndex},#{maxRowCount}")
	public List<TDemoDept> queryPageAll(@Param("startIndex") Integer startIndex, 
			@Param("maxRowCount") Integer maxRowCount) throws Exception;
	
	@ResultMap("TDemoDeptResults")
	@Select("select * from t_demo_dept where dept_name like '%${deptName}%' order by oper_time desc limit #{startIndex},#{maxRowCount}")
	public List<TDemoDept> queryByNamePageAll(@Param("deptName") String deptName, 
			@Param("startIndex") Integer startIndex, 
			@Param("maxRowCount") Integer maxRowCount) throws Exception;
	
	@Insert("insert into t_demo_dept(dept_name,dept_create_time,oper_time) "
			+ "values(#{deptName},#{deptCreateTime},#{operTime})")
	public void add(TDemoDept dept) throws Exception;
	
	@Update("update t_demo_dept set dept_name=#{deptName},dept_create_time=#{deptCreateTime},"
			+ "oper_time=#{operTime} where dept_id=#{deptId}")
	public void update(TDemoDept dept) throws Exception;
	
	@DeleteProvider(type=TDemoDeptMapperProvider.class, method="deleteBatch")
	public void delete(@Param("id") Integer...id) throws Exception;

	//one-to-many
	@Results({@Result(property="deptId", column="dept_id", id=true),
			  @Result(property="deptName", column="dept_name"),
			  @Result(property="deptCreateTime", column="dept_create_time"),
			  @Result(property="operTime", column="oper_time"),
			  @Result(property="TDemoUsers", column="dept_id", 
			      many=@Many(select="com.demo.database.idao.TDemoUserMapper.queryByDeptId"))
	})
	@Select("select * from t_demo_dept order by oper_time desc")
	public List<TDemoDept> queryDeptAndUser() throws Exception;
	
}











=======
package com.demo.database.idao;

import java.util.List;

import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.demo.database.data.TDemoDept;

/**
 * 部门表数据访问接口
 * @author Teacher
 * @createTime 2018年10月15日 上午9:06:44
 * @lastTime 2018年10月15日 上午9:06:44
 * @version 1.0.0
 */
public interface TDemodeptMapper {

	@Results(id="TDemoDeptResults", value={
			@Result(property="deptId", column="dept_id", id=true),
			@Result(property="deptName", column="dept_name"),
			@Result(property="deptCreateTime", column="dept_create_time"),
			@Result(property="operTime", column="oper_time")
	})
	@Select("select * from t_demo_dept order by oper_time desc")
	public List<TDemoDept> queryAll() throws Exception;
	
	@ResultMap("TDemoDeptResults")
	@Select("select * from t_demo_dept where dept_name like '%${deptName}%' order by oper_time desc")
	public List<TDemoDept> queryByName(@Param("deptName") String deptName) throws Exception;
	
	@ResultMap("TDemoDeptResults")
	@Select("select * from t_demo_dept where dept_id=#{id}")
	public TDemoDept getById(Integer id) throws Exception;
	
	@Select("select count(*) from t_demo_dept")
	public Integer getRowCount() throws Exception;
	
	@Select("select count(*) from t_demo_dept where dept_name like '%${deptName}%'")
	public Integer getByNameRowCount(@Param("deptName") String deptName) throws Exception;
	
	@ResultMap("TDemoDeptResults")
	@Select("select * from t_demo_dept order by oper_time desc limit #{startIndex},#{maxRowCount}")
	public List<TDemoDept> queryPageAll(@Param("startIndex") Integer startIndex, 
			@Param("maxRowCount") Integer maxRowCount) throws Exception;
	
	@ResultMap("TDemoDeptResults")
	@Select("select * from t_demo_dept where dept_name like '%${deptName}%' order by oper_time desc limit #{startIndex},#{maxRowCount}")
	public List<TDemoDept> queryByNamePageAll(@Param("deptName") String deptName, 
			@Param("startIndex") Integer startIndex, 
			@Param("maxRowCount") Integer maxRowCount) throws Exception;
	
	@Insert("insert into t_demo_dept(dept_name,dept_create_time,oper_time) "
			+ "values(#{deptName},#{deptCreateTime},#{operTime})")
	public void add(TDemoDept dept) throws Exception;
	
	@Update("update t_demo_dept set dept_name=#{deptName},dept_create_time=#{deptCreateTime},"
			+ "oper_time=#{operTime} where dept_id=#{deptId}")
	public void update(TDemoDept dept) throws Exception;
	
	@DeleteProvider(type=TDemoDeptMapperProvider.class, method="deleteBatch")
	public void delete(@Param("id") Integer...id) throws Exception;

	//one-to-many
	@Results({@Result(property="deptId", column="dept_id", id=true),
			  @Result(property="deptName", column="dept_name"),
			  @Result(property="deptCreateTime", column="dept_create_time"),
			  @Result(property="operTime", column="oper_time"),
			  @Result(property="TDemoUsers", column="dept_id", 
			      many=@Many(select="com.demo.database.idao.TDemoUserMapper.queryByDeptId"))
	})
	@Select("select * from t_demo_dept order by oper_time desc")
	public List<TDemoDept> queryDeptAndUser() throws Exception;
	
}











>>>>>>> second commit
