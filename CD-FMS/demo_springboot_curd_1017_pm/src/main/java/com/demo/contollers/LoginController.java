<<<<<<< HEAD
package com.demo.contollers;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.demo.services.ILoginService;
import com.demo.services.impl.LoginServiceImpl;

/**
 * 登录控制器
 * @author Teacher
 * @createTime 2018年10月11日 下午4:56:36
 * @lastTime 2018年10月11日 下午4:56:36
 * @version 1.0.0
 */
@Controller
@SessionAttributes({"userInfo"})
public class LoginController {

	//注入（依赖注入DI）登录的业务Bean
	@Resource
	private ILoginService iloginService;
	
	@RequestMapping("/login")
	public String login(String userName, String password, Model model) throws Exception {
		try {
			//访问登录业务方法
			String result = iloginService.login(userName, password, model);
			//返回下一个视图路径
			return result;
		} catch(Exception e) {
			e.printStackTrace();
			return "error.html";
		}
	}
	
	@RequestMapping("/logout")
	public String logout(HttpSession session, SessionStatus sessionStatus) throws Exception {
		try {
			String result = iloginService.logout(session, sessionStatus);
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
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.demo.services.ILoginService;
import com.demo.services.impl.LoginServiceImpl;

/**
 * 登录控制器
 * @author Teacher
 * @createTime 2018年10月11日 下午4:56:36
 * @lastTime 2018年10月11日 下午4:56:36
 * @version 1.0.0
 */
@Controller
@SessionAttributes({"userInfo"})
public class LoginController {

	//注入（依赖注入DI）登录的业务Bean
	@Resource
	private ILoginService iloginService;
	
	@RequestMapping("/login")
	public String login(String userName, String password, Model model) throws Exception {
		try {
			//访问登录业务方法
			String result = iloginService.login(userName, password, model);
			//返回下一个视图路径
			return result;
		} catch(Exception e) {
			e.printStackTrace();
			return "error.html";
		}
	}
	
	@RequestMapping("/logout")
	public String logout(HttpSession session, SessionStatus sessionStatus) throws Exception {
		try {
			String result = iloginService.logout(session, sessionStatus);
			return result;
		} catch(Exception e) {
			e.printStackTrace();
			return "error.html";
		}
	}

}
>>>>>>> second commit
