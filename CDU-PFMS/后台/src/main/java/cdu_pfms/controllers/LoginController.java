<<<<<<< HEAD
package cdu_pfms.controllers;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.support.SessionStatus;

import cdu_pfms.database.data.AcInfo;
import cdu_pfms.database.data.Account;
import cdu_pfms.database.data.Admin;
import cdu_pfms.database.data.EnrollInfo;
import cdu_pfms.database.data.User;
import cdu_pfms.services.LoginService;
import cdu_pfms.services.UserService;


@CrossOrigin
@Controller
public class LoginController {

	//注入（依赖注入DI）登录的业务Bean
	@Resource
	private LoginService loginService;
	@Resource
	private UserService userService;
		
	@RequestMapping("/login")
	@ResponseBody
	public String login(@RequestBody AcInfo acinfo , HttpServletRequest request) throws Exception {
		System.out.println("=====>"+acinfo.getUserName()+"  ======>"+acinfo.getPassword());
		HttpSession session = request.getSession();
		String result=loginService.login(acinfo.getUserName(), acinfo.getPassword(), session);
		return result;
	}
	
	@RequestMapping("/login/getAccount")
	@ResponseBody
	public String getAccName(HttpSession session) {
		if(session.getAttribute("account")!=null) {
			Account account=(Account) session.getAttribute("account");
			System.out.println(account.getAccountId());
			return account.getAccountId().toString();
		}else if(session.getAttribute("admin")!=null) {
			Admin admin=(Admin) session.getAttribute("admin");
			System.out.println(admin.getAdminName());
			return admin.getAdminName().toString();
		}else {
			return "error";
		}
	}
	
	@RequestMapping("/logout")
	@ResponseBody
	public String logout(HttpSession session, SessionStatus sessionStatus) throws Exception {
		try {
			String result = loginService.logout(session, sessionStatus);
			return result;
		} catch(Exception e) {
			e.printStackTrace();
			return "error";
		}
	}
	/**
	 * 用户注册
	 * @param user
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/userEnroll")
	@ResponseBody
	public String enroll(@RequestBody EnrollInfo en) {
		AcInfo ac=new AcInfo();
		User user=new User();
		ac.setUserName(en.getAccount());
		ac.setPassword(en.getPassword());
		user.setUserAddress(en.getUserAddress());
		user.setUserBirthday(en.getUserBirthday());
		user.setUserGender(en.getUserGender());
		user.setUserIdcard(en.getUserIdcard());
		user.setUserMailbox(en.getUserMailbox());
		user.setUserName(en.getUserName());
		user.setUserPhone(en.getUserPhone());
		try {
			String result = userService.enroll(ac, user);
			System.out.println("===>"+ac.getUserName()+" "+ac.getPassword()+" ===>"+user.getUserName()+" "+user.getUserMailbox());
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return "error.html";
		}
	}
	/**
	 * 用户找回密码
	 * @param account
	 * @param password
	 * @param mail
	 * @return
	 */
	@RequestMapping("/forget")
	@ResponseBody
	public String forgetPass(String account, String username, String mail) {
		try {
			String result=loginService.forgetPass(account, username, mail);
			return result;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

}
=======
package cdu_pfms.controllers;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.support.SessionStatus;

import cdu_pfms.database.data.AcInfo;
import cdu_pfms.database.data.Account;
import cdu_pfms.database.data.Admin;
import cdu_pfms.database.data.EnrollInfo;
import cdu_pfms.database.data.User;
import cdu_pfms.services.LoginService;
import cdu_pfms.services.UserService;


@CrossOrigin
@Controller
public class LoginController {

	//注入（依赖注入DI）登录的业务Bean
	@Resource
	private LoginService loginService;
	@Resource
	private UserService userService;
		
	@RequestMapping("/login")
	@ResponseBody
	public String login(@RequestBody AcInfo acinfo , HttpServletRequest request) throws Exception {
		System.out.println("=====>"+acinfo.getUserName()+"  ======>"+acinfo.getPassword());
		HttpSession session = request.getSession();
		String result=loginService.login(acinfo.getUserName(), acinfo.getPassword(), session);
		return result;
	}
	
	@RequestMapping("/login/getAccount")
	@ResponseBody
	public String getAccName(HttpSession session) {
		if(session.getAttribute("account")!=null) {
			Account account=(Account) session.getAttribute("account");
			System.out.println(account.getAccountId());
			return account.getAccountId().toString();
		}else if(session.getAttribute("admin")!=null) {
			Admin admin=(Admin) session.getAttribute("admin");
			System.out.println(admin.getAdminName());
			return admin.getAdminName().toString();
		}else {
			return "error";
		}
	}
	
	@RequestMapping("/logout")
	@ResponseBody
	public String logout(HttpSession session, SessionStatus sessionStatus) throws Exception {
		try {
			String result = loginService.logout(session, sessionStatus);
			return result;
		} catch(Exception e) {
			e.printStackTrace();
			return "error";
		}
	}
	/**
	 * 用户注册
	 * @param user
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/userEnroll")
	@ResponseBody
	public String enroll(@RequestBody EnrollInfo en) {
		AcInfo ac=new AcInfo();
		User user=new User();
		ac.setUserName(en.getAccount());
		ac.setPassword(en.getPassword());
		user.setUserAddress(en.getUserAddress());
		user.setUserBirthday(en.getUserBirthday());
		user.setUserGender(en.getUserGender());
		user.setUserIdcard(en.getUserIdcard());
		user.setUserMailbox(en.getUserMailbox());
		user.setUserName(en.getUserName());
		user.setUserPhone(en.getUserPhone());
		try {
			String result = userService.enroll(ac, user);
			System.out.println("===>"+ac.getUserName()+" "+ac.getPassword()+" ===>"+user.getUserName()+" "+user.getUserMailbox());
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return "error.html";
		}
	}
	/**
	 * 用户找回密码
	 * @param account
	 * @param password
	 * @param mail
	 * @return
	 */
	@RequestMapping("/forget")
	@ResponseBody
	public String forgetPass(String account, String username, String mail) {
		try {
			String result=loginService.forgetPass(account, username, mail);
			return result;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

}
>>>>>>> second commit
