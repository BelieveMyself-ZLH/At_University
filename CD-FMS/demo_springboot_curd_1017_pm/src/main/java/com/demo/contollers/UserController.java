<<<<<<< HEAD
package com.demo.contollers;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.demo.services.IUserService;

/**
 * 用户管理的控制器
 * @author Teacher
 * @createTime 2018年10月17日 上午9:48:35
 * @lastTime 2018年10月17日 上午9:48:35
 * @version 1.0.0
 */
@Controller
public class UserController {

	//注入业务处理接口对象
	@Resource
	private IUserService iuserService;
	
	/**
	 * 查询用户数据
	 * @param Model
	 * @return
	 */
	@RequestMapping("/userlist")
	public String query(Model model) {
		try {
			String result = iuserService.query(model);
			return result;
		} catch (Exception e) {
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

import com.demo.services.IUserService;

/**
 * 用户管理的控制器
 * @author Teacher
 * @createTime 2018年10月17日 上午9:48:35
 * @lastTime 2018年10月17日 上午9:48:35
 * @version 1.0.0
 */
@Controller
public class UserController {

	//注入业务处理接口对象
	@Resource
	private IUserService iuserService;
	
	/**
	 * 查询用户数据
	 * @param Model
	 * @return
	 */
	@RequestMapping("/userlist")
	public String query(Model model) {
		try {
			String result = iuserService.query(model);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return "error.html";
		}
	}
	
}
>>>>>>> second commit
