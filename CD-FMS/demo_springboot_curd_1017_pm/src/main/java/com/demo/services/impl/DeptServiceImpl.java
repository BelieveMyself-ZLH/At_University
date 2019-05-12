<<<<<<< HEAD
package com.demo.services.impl;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.demo.database.data.TDemoDept;
import com.demo.database.idao.TDemodeptMapper;
import com.demo.services.IDeptService;
import com.demo.utils.IPageUtils;

/**
 * 部门管理的业务处理具体实现类
 * @author Teacher
 * @createTime 2018年10月15日 上午10:37:43
 * @lastTime 2018年10月15日 上午10:37:43
 * @version 1.0.0
 */
@Service
public class DeptServiceImpl implements IDeptService {

	//注入部门表数据访问接口
	@Resource
	private TDemodeptMapper mapper;
	
	@Override
	public String query(String deptName, Integer pageNumber, Model model) throws Exception {
		//每页最大行数
		int maxRowCount = 5;
		//总行数
		int totalRowCount = 0;
		//总页数
		//int totalPageCount = 1;
		//起始行位置
		//int startIndex = 0;
		//声明封装数据的集合变量
		List<TDemoDept> list;
		//声明封装分页相关属性的图集合变量
		Map<String, Integer> prop;
		//判断条件是否不为空
		if(deptName!=null&&!"".equals(deptName)) {
			//获得总行数
			totalRowCount = mapper.getByNameRowCount(deptName);
			//计算获得分页相关属性
			prop = IPageUtils.calPageProperties(totalRowCount, maxRowCount, pageNumber);
			//条件查询数据
			list = mapper.queryByNamePageAll(deptName, prop.get("startIndex"), maxRowCount);
		} else {
			totalRowCount = mapper.getRowCount();
			prop = IPageUtils.calPageProperties(totalRowCount, maxRowCount, pageNumber);
			list = mapper.queryPageAll(prop.get("startIndex"), maxRowCount);
		}
		//封装模型数据
		model.addAttribute("list", list);
		/*model.addAttribute("totalRowCount", totalRowCount);
		model.addAttribute("totalPageCount", prop.get("totalPageCount"));
		model.addAttribute("maxRowCount", maxRowCount);
		model.addAttribute("pageNumber", prop.get("pageNumber"));
		model.addAttribute("startIndex", prop.get("startIndex"));*/
		model.addAllAttributes(prop);
		//返回下一个视图路径
		return "system/dept/deptlist.html";
	}

	@Override
	public String add(TDemoDept dept, Model model) throws Exception {
		//封装数据(操作时间)
		dept.setOperTime(new Timestamp(System.currentTimeMillis()));
		//添加数据
		mapper.add(dept);
		//查询数据，并返回下一个视图路径
		return query(null, 1, model);
	}
	
	@Override
	public String updateView(Integer id, Model model) throws Exception {
		//根据ID查询部门数据
		TDemoDept dept = mapper.getById(id);
		//封装模型数据
		model.addAttribute("dept", dept);
		//返回修改页面的路径
		return "system/dept/deptupdate.html";
	}
	
	@Override
	public String update(TDemoDept dept, Model model) throws Exception {
		//封装数据
		dept.setOperTime(new Timestamp(System.currentTimeMillis()));
		//修改数据
		mapper.update(dept);
		//查询数据，并返回到列表界面
		return query(null, 1, model);
	}

	@Override
	public String delete(Integer[] id, Model model) throws Exception {
		//删除数据
		mapper.delete(id);
		return query(null, 1, model);
	}

}
=======
package com.demo.services.impl;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.demo.database.data.TDemoDept;
import com.demo.database.idao.TDemodeptMapper;
import com.demo.services.IDeptService;
import com.demo.utils.IPageUtils;

/**
 * 部门管理的业务处理具体实现类
 * @author Teacher
 * @createTime 2018年10月15日 上午10:37:43
 * @lastTime 2018年10月15日 上午10:37:43
 * @version 1.0.0
 */
@Service
public class DeptServiceImpl implements IDeptService {

	//注入部门表数据访问接口
	@Resource
	private TDemodeptMapper mapper;
	
	@Override
	public String query(String deptName, Integer pageNumber, Model model) throws Exception {
		//每页最大行数
		int maxRowCount = 5;
		//总行数
		int totalRowCount = 0;
		//总页数
		//int totalPageCount = 1;
		//起始行位置
		//int startIndex = 0;
		//声明封装数据的集合变量
		List<TDemoDept> list;
		//声明封装分页相关属性的图集合变量
		Map<String, Integer> prop;
		//判断条件是否不为空
		if(deptName!=null&&!"".equals(deptName)) {
			//获得总行数
			totalRowCount = mapper.getByNameRowCount(deptName);
			//计算获得分页相关属性
			prop = IPageUtils.calPageProperties(totalRowCount, maxRowCount, pageNumber);
			//条件查询数据
			list = mapper.queryByNamePageAll(deptName, prop.get("startIndex"), maxRowCount);
		} else {
			totalRowCount = mapper.getRowCount();
			prop = IPageUtils.calPageProperties(totalRowCount, maxRowCount, pageNumber);
			list = mapper.queryPageAll(prop.get("startIndex"), maxRowCount);
		}
		//封装模型数据
		model.addAttribute("list", list);
		/*model.addAttribute("totalRowCount", totalRowCount);
		model.addAttribute("totalPageCount", prop.get("totalPageCount"));
		model.addAttribute("maxRowCount", maxRowCount);
		model.addAttribute("pageNumber", prop.get("pageNumber"));
		model.addAttribute("startIndex", prop.get("startIndex"));*/
		model.addAllAttributes(prop);
		//返回下一个视图路径
		return "system/dept/deptlist.html";
	}

	@Override
	public String add(TDemoDept dept, Model model) throws Exception {
		//封装数据(操作时间)
		dept.setOperTime(new Timestamp(System.currentTimeMillis()));
		//添加数据
		mapper.add(dept);
		//查询数据，并返回下一个视图路径
		return query(null, 1, model);
	}
	
	@Override
	public String updateView(Integer id, Model model) throws Exception {
		//根据ID查询部门数据
		TDemoDept dept = mapper.getById(id);
		//封装模型数据
		model.addAttribute("dept", dept);
		//返回修改页面的路径
		return "system/dept/deptupdate.html";
	}
	
	@Override
	public String update(TDemoDept dept, Model model) throws Exception {
		//封装数据
		dept.setOperTime(new Timestamp(System.currentTimeMillis()));
		//修改数据
		mapper.update(dept);
		//查询数据，并返回到列表界面
		return query(null, 1, model);
	}

	@Override
	public String delete(Integer[] id, Model model) throws Exception {
		//删除数据
		mapper.delete(id);
		return query(null, 1, model);
	}

}
>>>>>>> second commit
