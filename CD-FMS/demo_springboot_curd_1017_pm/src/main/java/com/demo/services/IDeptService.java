<<<<<<< HEAD
package com.demo.services;

import org.springframework.ui.Model;

import com.demo.database.data.TDemoDept;

/**
 * 部门管理的业务处理接口
 * @author Teacher
 * @createTime 2018年10月15日 上午10:32:38
 * @lastTime 2018年10月15日 上午10:32:38
 * @version 1.0.0
 */
public interface IDeptService {

    /**
     * 查询所有或条件查询部门数据
     * @param deptName
     * @return
     * @throws Exception
     */
	public String query(String deptName, Integer pagerNumber,  Model model) throws Exception;
	
	/**
	 * 添加部门数据
	 * @param dept
	 * @return
	 * @throws Exception
	 */
	public String add(TDemoDept dept, Model model) throws Exception;
	
	/**
	 * 展示修改视图页面
	 * @param id
	 * @param model
	 * @return
	 * @throws Exception
	 */
	public String updateView(Integer id, Model model) throws Exception;
	
	/**
	 * 修改部门数据
	 * @param dept
	 * @param model
	 * @return
	 * @throws Exception
	 */
	public String update(TDemoDept dept, Model model) throws Exception;
	
	/**
	 * 删除部门数据
	 * @param id
	 * @param model
	 * @return
	 * @throws Exception
	 */
	public String delete(Integer[] id, Model model) throws Exception;
	
}
=======
package com.demo.services;

import org.springframework.ui.Model;

import com.demo.database.data.TDemoDept;

/**
 * 部门管理的业务处理接口
 * @author Teacher
 * @createTime 2018年10月15日 上午10:32:38
 * @lastTime 2018年10月15日 上午10:32:38
 * @version 1.0.0
 */
public interface IDeptService {

    /**
     * 查询所有或条件查询部门数据
     * @param deptName
     * @return
     * @throws Exception
     */
	public String query(String deptName, Integer pagerNumber,  Model model) throws Exception;
	
	/**
	 * 添加部门数据
	 * @param dept
	 * @return
	 * @throws Exception
	 */
	public String add(TDemoDept dept, Model model) throws Exception;
	
	/**
	 * 展示修改视图页面
	 * @param id
	 * @param model
	 * @return
	 * @throws Exception
	 */
	public String updateView(Integer id, Model model) throws Exception;
	
	/**
	 * 修改部门数据
	 * @param dept
	 * @param model
	 * @return
	 * @throws Exception
	 */
	public String update(TDemoDept dept, Model model) throws Exception;
	
	/**
	 * 删除部门数据
	 * @param id
	 * @param model
	 * @return
	 * @throws Exception
	 */
	public String delete(Integer[] id, Model model) throws Exception;
	
}
>>>>>>> second commit
