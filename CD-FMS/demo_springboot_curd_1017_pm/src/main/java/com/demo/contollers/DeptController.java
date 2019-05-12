<<<<<<< HEAD
package com.demo.contollers;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.demo.database.data.TDemoDept;
import com.demo.services.IDeptService;

/**
 * 部门管理的控制器
 * @author Teacher
 * @createTime 2018年10月15日 上午10:30:01
 * @lastTime 2018年10月15日 上午10:30:01
 * @version 1.0.0
 */
@Controller
public class DeptController {

	//注入部门管理的业务实现接口
	@Resource
	private IDeptService ideptService;
	
	/**
	 * 查询所有部门或条件查询
	 * @param deptName
	 * @return
	 */
	@RequestMapping("/deptlist")
	public String query(String sdeptName, Integer pageNumber, Model model) {
		try {
			//访问查询业务方法
			String result = ideptService.query(sdeptName, pageNumber, model);
			//返回下一个视图路径
			return result;
		} catch(Exception e) {
			e.printStackTrace();
			return "error.html";
		}
	}
	
	/**
	 * 展示添加视图页面
	 * @return
	 */
	@RequestMapping("/deptaddview")
	public String addView() {
		return "system/dept/deptadd.html";
	}
	
	/**
	 * 添加部门数据
	 * @param dept
	 * @param model
	 * @return
	 */
	@RequestMapping("/deptadd")
	public String add(TDemoDept dept, Model model) {
		try {
			String result = ideptService.add(dept, model);
			return result;
		} catch(Exception e) {
			e.printStackTrace();
			return "error.html";
		}
	}
	
	/**
	 * 展示修改视图页面
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping("/deptupdateview")
	public String updateView(Integer id, Model model) {
		try {
			String result = ideptService.updateView(id, model);
			return result;
		} catch(Exception e) {
			e.printStackTrace();
			return "error.html";
		}
	}
	
	/**
	 * 修改部门数据
	 * @param dept
	 * @param model
	 * @return
	 */
	@RequestMapping("/deptupdate")
	public String update(TDemoDept dept, Model model) {
		try {
			String result = ideptService.update(dept, model);
			return result;
		} catch(Exception e) {
			e.printStackTrace();
			return "error.html";
		}
	}
	
	/**
	 * 删除部门数据
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping("/deptdelete")
	public String delete(Integer[] id, Model model) {
		try {
			String result = ideptService.delete(id, model);
			return result;
		} catch(Exception e) {
			e.printStackTrace();
			return "error.html";
		}
	}
	
}
=======
package com.demo.contollers;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.demo.database.data.TDemoDept;
import com.demo.services.IDeptService;

/**
 * 部门管理的控制器
 * @author Teacher
 * @createTime 2018年10月15日 上午10:30:01
 * @lastTime 2018年10月15日 上午10:30:01
 * @version 1.0.0
 */
@Controller
public class DeptController {

	//注入部门管理的业务实现接口
	@Resource
	private IDeptService ideptService;
	
	/**
	 * 查询所有部门或条件查询
	 * @param deptName
	 * @return
	 */
	@RequestMapping("/deptlist")
	public String query(String sdeptName, Integer pageNumber, Model model) {
		try {
			//访问查询业务方法
			String result = ideptService.query(sdeptName, pageNumber, model);
			//返回下一个视图路径
			return result;
		} catch(Exception e) {
			e.printStackTrace();
			return "error.html";
		}
	}
	
	/**
	 * 展示添加视图页面
	 * @return
	 */
	@RequestMapping("/deptaddview")
	public String addView() {
		return "system/dept/deptadd.html";
	}
	
	/**
	 * 添加部门数据
	 * @param dept
	 * @param model
	 * @return
	 */
	@RequestMapping("/deptadd")
	public String add(TDemoDept dept, Model model) {
		try {
			String result = ideptService.add(dept, model);
			return result;
		} catch(Exception e) {
			e.printStackTrace();
			return "error.html";
		}
	}
	
	/**
	 * 展示修改视图页面
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping("/deptupdateview")
	public String updateView(Integer id, Model model) {
		try {
			String result = ideptService.updateView(id, model);
			return result;
		} catch(Exception e) {
			e.printStackTrace();
			return "error.html";
		}
	}
	
	/**
	 * 修改部门数据
	 * @param dept
	 * @param model
	 * @return
	 */
	@RequestMapping("/deptupdate")
	public String update(TDemoDept dept, Model model) {
		try {
			String result = ideptService.update(dept, model);
			return result;
		} catch(Exception e) {
			e.printStackTrace();
			return "error.html";
		}
	}
	
	/**
	 * 删除部门数据
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping("/deptdelete")
	public String delete(Integer[] id, Model model) {
		try {
			String result = ideptService.delete(id, model);
			return result;
		} catch(Exception e) {
			e.printStackTrace();
			return "error.html";
		}
	}
	
}
>>>>>>> second commit
