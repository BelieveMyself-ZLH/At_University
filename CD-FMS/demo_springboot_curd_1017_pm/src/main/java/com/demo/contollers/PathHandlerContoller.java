<<<<<<< HEAD
package com.demo.contollers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 请求路径转映射控制器
 * @author Teacher
 * @createTime 2018年10月11日 下午4:46:32
 * @lastTime 2018年10月11日 下午4:46:32
 * @version 1.0.0
 */
@Controller
public class PathHandlerContoller {

	@RequestMapping("/")
	public String loginMapper() throws Exception {
		//return "redirect:login.html";
		return "login.html";
	}
	
	@RequestMapping("/userlist.html")
	public String userMapper() throws Exception {
		return "system/user/userlist";
	}
	
}
=======
package com.demo.contollers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 请求路径转映射控制器
 * @author Teacher
 * @createTime 2018年10月11日 下午4:46:32
 * @lastTime 2018年10月11日 下午4:46:32
 * @version 1.0.0
 */
@Controller
public class PathHandlerContoller {

	@RequestMapping("/")
	public String loginMapper() throws Exception {
		//return "redirect:login.html";
		return "login.html";
	}
	
	@RequestMapping("/userlist.html")
	public String userMapper() throws Exception {
		return "system/user/userlist";
	}
	
}
>>>>>>> second commit
