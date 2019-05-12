<<<<<<< HEAD
package cdu_pfms.services.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.json.JSONArray;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.support.SessionStatus;

import cdu_pfms.database.data.Account;
import cdu_pfms.database.data.Admin;
import cdu_pfms.database.data.User;
import cdu_pfms.database.idao.AccountMapper;
import cdu_pfms.database.idao.AdminMapper;
import cdu_pfms.database.idao.UserMapper;
import cdu_pfms.services.LoginService;
import cdu_pfms.utils.SendMail;

@Service
public class LoginServiceImpl implements LoginService {
	
	@Resource
	private AccountMapper accountmapper;
	
	@Resource
	private UserMapper usermapper;
	
	@Resource
	private AdminMapper adminmapper;
	
	@Override
	public String enroll(Account account,User user, Model model) throws Exception {
		try {
			account.setAccountBalance(0.00);
			account.setAccountState(1);
			account.setAccountCreateTime(new Timestamp(System.currentTimeMillis()));
			accountmapper.enroll(account);
			//usermapper.enroll(user);
			return "login.html";
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	
	}
	
	
	@Override
	public String userLogin(String accountId, String accountPassword, Model model) throws Exception {
		Account account = accountmapper.queryByLogin(accountId, accountPassword);
		if (account!=null) {
			model.addAttribute("accountInfo", account);
			Map<String, String> map = new HashMap();
			map.put("index", "userIndex");
			map.put("userName", account.getAccountId());
			System.out.println(account.getAccountId());
			List<Map<String, String>> list = new ArrayList();
			list.add(map);
			JSONArray json = new JSONArray(list);
			return json.toString();
		}else {
			model.addAttribute("error","用户名或密码错误");
			System.out.println("查找失败");
			return "login.html";
		}
	}

	@Override
	public String adminLogin(String accountId, String accountPassword, Model model) throws Exception {
		Admin admin = adminmapper.queryByLogin(accountId, accountPassword);
		if (admin!=null) {
			model.addAttribute("adminInfo", admin);
			return "adminIndex.html";
		}else {
			model.addAttribute("error","用户名或密码错误");
			return "login.html";
		}
	}
	
	@Override
	public String logout(HttpSession session, SessionStatus sessionStatus) throws Exception {
		//销毁Session，清除与用户相关的所有数据
		session.invalidate();
		//同步Session状态的改变，与SessionA
		sessionStatus.setComplete();
		//返回登录页面
		return "success";
	}

	/**============================修改之后的登陆服务===============================**/
	/**======================================================By ZhouLinHu======**/
	
	@Override
	public String login(String accountId, String accountPassword, HttpSession session) throws Exception {
		Admin admin=adminmapper.queryByLogin(accountId, accountPassword);
		System.out.println(session.getId());
		if(admin!=null) {
			session.setAttribute("admin", admin);
			Map<String, String> map = new HashMap();
			map.put("index", "adminIndex");
			map.put("userName", admin.getAdminId());
			System.out.println(admin.getAdminId());
			List<Map<String, String>> list = new ArrayList();
			list.add(map);
			JSONArray json = new JSONArray(list);
			return json.toString();
		}else {
			Account account = accountmapper.queryByLogin(accountId, accountPassword);
			if (account!=null) {
				session.setAttribute("account", account);
				Map<String, String> map = new HashMap();
				map.put("index", "userIndex");
				map.put("userName", account.getAccountId());
				map.put("jsessionid", session.getId());
				System.out.println(account.getAccountId());
				List<Map<String, String>> list = new ArrayList();
				list.add(map);
				JSONArray json = new JSONArray(list);
				return json.toString();
			}else {
				System.out.println("查找失败");
				return "error";
			}
		}
	}


	@Override
	public String forgetPass(String account, String username, String mail) throws Exception {
		Account acc=accountmapper.queryAccById(account);
		User user=usermapper.queryById(acc.getUserId());
		SendMail sendMail=new SendMail();
		String subject="用户找回密码";
		String content="  尊敬的用户："+username+",您于"+new Date()+"向系统发送请求找回密码，您的账户密码为："+acc.getAccountPassword()+",为了防止你的密码被盗用请您阅读该邮件后将之删除。为了您的账号安全请您用该密码登陆后重新设定密码";
		if(user.getUserName().equals(username)&&user.getUserMailbox().equals(mail)) {
			sendMail.sendEmail(mail, subject, content, username);
			return "success";
		}else {
			return "输入信息有误!";
		}
	}

}
=======
package cdu_pfms.services.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.json.JSONArray;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.support.SessionStatus;

import cdu_pfms.database.data.Account;
import cdu_pfms.database.data.Admin;
import cdu_pfms.database.data.User;
import cdu_pfms.database.idao.AccountMapper;
import cdu_pfms.database.idao.AdminMapper;
import cdu_pfms.database.idao.UserMapper;
import cdu_pfms.services.LoginService;
import cdu_pfms.utils.SendMail;

@Service
public class LoginServiceImpl implements LoginService {
	
	@Resource
	private AccountMapper accountmapper;
	
	@Resource
	private UserMapper usermapper;
	
	@Resource
	private AdminMapper adminmapper;
	
	@Override
	public String enroll(Account account,User user, Model model) throws Exception {
		try {
			account.setAccountBalance(0.00);
			account.setAccountState(1);
			account.setAccountCreateTime(new Timestamp(System.currentTimeMillis()));
			accountmapper.enroll(account);
			//usermapper.enroll(user);
			return "login.html";
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	
	}
	
	
	@Override
	public String userLogin(String accountId, String accountPassword, Model model) throws Exception {
		Account account = accountmapper.queryByLogin(accountId, accountPassword);
		if (account!=null) {
			model.addAttribute("accountInfo", account);
			Map<String, String> map = new HashMap();
			map.put("index", "userIndex");
			map.put("userName", account.getAccountId());
			System.out.println(account.getAccountId());
			List<Map<String, String>> list = new ArrayList();
			list.add(map);
			JSONArray json = new JSONArray(list);
			return json.toString();
		}else {
			model.addAttribute("error","用户名或密码错误");
			System.out.println("查找失败");
			return "login.html";
		}
	}

	@Override
	public String adminLogin(String accountId, String accountPassword, Model model) throws Exception {
		Admin admin = adminmapper.queryByLogin(accountId, accountPassword);
		if (admin!=null) {
			model.addAttribute("adminInfo", admin);
			return "adminIndex.html";
		}else {
			model.addAttribute("error","用户名或密码错误");
			return "login.html";
		}
	}
	
	@Override
	public String logout(HttpSession session, SessionStatus sessionStatus) throws Exception {
		//销毁Session，清除与用户相关的所有数据
		session.invalidate();
		//同步Session状态的改变，与SessionA
		sessionStatus.setComplete();
		//返回登录页面
		return "success";
	}

	/**============================修改之后的登陆服务===============================**/
	/**======================================================By ZhouLinHu======**/
	
	@Override
	public String login(String accountId, String accountPassword, HttpSession session) throws Exception {
		Admin admin=adminmapper.queryByLogin(accountId, accountPassword);
		System.out.println(session.getId());
		if(admin!=null) {
			session.setAttribute("admin", admin);
			Map<String, String> map = new HashMap();
			map.put("index", "adminIndex");
			map.put("userName", admin.getAdminId());
			System.out.println(admin.getAdminId());
			List<Map<String, String>> list = new ArrayList();
			list.add(map);
			JSONArray json = new JSONArray(list);
			return json.toString();
		}else {
			Account account = accountmapper.queryByLogin(accountId, accountPassword);
			if (account!=null) {
				session.setAttribute("account", account);
				Map<String, String> map = new HashMap();
				map.put("index", "userIndex");
				map.put("userName", account.getAccountId());
				map.put("jsessionid", session.getId());
				System.out.println(account.getAccountId());
				List<Map<String, String>> list = new ArrayList();
				list.add(map);
				JSONArray json = new JSONArray(list);
				return json.toString();
			}else {
				System.out.println("查找失败");
				return "error";
			}
		}
	}


	@Override
	public String forgetPass(String account, String username, String mail) throws Exception {
		Account acc=accountmapper.queryAccById(account);
		User user=usermapper.queryById(acc.getUserId());
		SendMail sendMail=new SendMail();
		String subject="用户找回密码";
		String content="  尊敬的用户："+username+",您于"+new Date()+"向系统发送请求找回密码，您的账户密码为："+acc.getAccountPassword()+",为了防止你的密码被盗用请您阅读该邮件后将之删除。为了您的账号安全请您用该密码登陆后重新设定密码";
		if(user.getUserName().equals(username)&&user.getUserMailbox().equals(mail)) {
			sendMail.sendEmail(mail, subject, content, username);
			return "success";
		}else {
			return "输入信息有误!";
		}
	}

}
>>>>>>> second commit
