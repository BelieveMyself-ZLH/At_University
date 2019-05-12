<<<<<<< HEAD
package com.demo.database.idao;

import java.util.Map;

/**
 * 部门数据访问的动态SQL
 * @author Teacher
 * @createTime 2018年10月15日 上午9:50:33
 * @lastTime 2018年10月15日 上午9:50:33
 * @version 1.0.0
 */
public class TDemoDeptMapperProvider {

	/**
	 * 批量删除
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public String deleteBatch(Map<String, Object> param) throws Exception {
		//定义SQL语句
		String sql = "delete from t_demo_dept where dept_id in(";
		//获得ID数组
		Integer[] id = (Integer[])param.get("id");
		//遍历id数组
		for(int i=0; i<id.length; i++) {
			sql += id[i];
			//判断是否不是最后一个元素
			if(i<id.length-1) {
				sql += ",";
			}
		}
	    sql += ")";
		return  sql;
	}
	
}
=======
package com.demo.database.idao;

import java.util.Map;

/**
 * 部门数据访问的动态SQL
 * @author Teacher
 * @createTime 2018年10月15日 上午9:50:33
 * @lastTime 2018年10月15日 上午9:50:33
 * @version 1.0.0
 */
public class TDemoDeptMapperProvider {

	/**
	 * 批量删除
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public String deleteBatch(Map<String, Object> param) throws Exception {
		//定义SQL语句
		String sql = "delete from t_demo_dept where dept_id in(";
		//获得ID数组
		Integer[] id = (Integer[])param.get("id");
		//遍历id数组
		for(int i=0; i<id.length; i++) {
			sql += id[i];
			//判断是否不是最后一个元素
			if(i<id.length-1) {
				sql += ",";
			}
		}
	    sql += ")";
		return  sql;
	}
	
}
>>>>>>> second commit
