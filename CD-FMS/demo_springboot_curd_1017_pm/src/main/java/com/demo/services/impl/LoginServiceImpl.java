<<<<<<< HEAD
package com.demo.services.impl;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.support.SessionStatus;

import com.demo.database.data.TDemoUser;
import com.demo.database.idao.TDemoUserMapper;
import com.demo.services.ILoginService;

/**
 * 登录业务处理具体实现类
 * @author Teacher
 * @createTime 2018年10月12日 上午9:06:24
 * @lastTime 2018年10月12日 上午9:06:24
 * @version 1.0.0
 */
@Service
public class LoginServiceImpl implements ILoginService {

	//注入用户表数据访问接口
	@Resource
	private TDemoUserMapper mapper;
	
	@Override
	public String login(String userName, String password, Model model) throws Exception {
		//条件查询数据库用户表
		TDemoUser user = mapper.queryByLogin(userName, password);
		//验证登录
		if(user!=null) {
			//封装用户信息
			model.addAttribute("userInfo", user);
			//返回下个视图路径
			return "index.html";
		} else {
			//返回错误信息
			model.addAttribute("error", "用户名或密码错误!");
			return "login.html";
		} 
	}

	@Override
	public String logout(HttpSession session, SessionStatus sessionStatus) throws Exception {
		//销毁Session, 清除与用户相关的所有数据
		session.invalidate();
		//同步Session状态的改变，与SessionAttributes同步
		sessionStatus.setComplete();
		//返回登录页面
		return "login.html";
	}

}
=======
package com.demo.services.impl;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.support.SessionStatus;

import com.demo.database.data.TDemoUser;
import com.demo.database.idao.TDemoUserMapper;
import com.demo.services.ILoginService;

/**
 * 登录业务处理具体实现类
 * @author Teacher
 * @createTime 2018年10月12日 上午9:06:24
 * @lastTime 2018年10月12日 上午9:06:24
 * @version 1.0.0
 */
@Service
public class LoginServiceImpl implements ILoginService {

	//注入用户表数据访问接口
	@Resource
	private TDemoUserMapper mapper;
	
	@Override
	public String login(String userName, String password, Model model) throws Exception {
		//条件查询数据库用户表
		TDemoUser user = mapper.queryByLogin(userName, password);
		//验证登录
		if(user!=null) {
			//封装用户信息
			model.addAttribute("userInfo", user);
			//返回下个视图路径
			return "index.html";
		} else {
			//返回错误信息
			model.addAttribute("error", "用户名或密码错误!");
			return "login.html";
		} 
	}

	@Override
	public String logout(HttpSession session, SessionStatus sessionStatus) throws Exception {
		//销毁Session, 清除与用户相关的所有数据
		session.invalidate();
		//同步Session状态的改变，与SessionAttributes同步
		sessionStatus.setComplete();
		//返回登录页面
		return "login.html";
	}

}
>>>>>>> second commit
