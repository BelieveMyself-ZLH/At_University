<<<<<<< HEAD
package com.demo.services;

import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;
import org.springframework.web.bind.support.SessionStatus;

/**
 * 登录业务处理的接口
 * @author Teacher
 * @createTime 2018年10月12日 上午8:58:00
 * @lastTime 2018年10月12日 上午8:58:00
 * @version 1.0.0
 */
public interface ILoginService {

	/**
	 * 帐号密码登录
	 * @param userName
	 * @param password
	 * @param model
	 * @return
	 * @throws Exception
	 */
	public String login(String userName, String password, Model model) throws Exception;
	
	/**
	 * 注销
	 * @param session
	 * @return
	 * @throws Exception
	 */
	public String logout(HttpSession session, SessionStatus sessionStatus) throws Exception;
	
}
=======
package com.demo.services;

import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;
import org.springframework.web.bind.support.SessionStatus;

/**
 * 登录业务处理的接口
 * @author Teacher
 * @createTime 2018年10月12日 上午8:58:00
 * @lastTime 2018年10月12日 上午8:58:00
 * @version 1.0.0
 */
public interface ILoginService {

	/**
	 * 帐号密码登录
	 * @param userName
	 * @param password
	 * @param model
	 * @return
	 * @throws Exception
	 */
	public String login(String userName, String password, Model model) throws Exception;
	
	/**
	 * 注销
	 * @param session
	 * @return
	 * @throws Exception
	 */
	public String logout(HttpSession session, SessionStatus sessionStatus) throws Exception;
	
}
>>>>>>> second commit
