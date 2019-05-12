<<<<<<< HEAD
package cdu_pfms.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.json.JSONArray;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cdu_pfms.database.data.Account;
import cdu_pfms.database.data.Balance;
import cdu_pfms.database.data.Password;
import cdu_pfms.database.data.SideAc;
import cdu_pfms.database.data.User;
import cdu_pfms.services.OperService;
import cdu_pfms.services.UserService;

/**
 * 用户管理的控制器
 * @author Wh
 * @createTime 2018年10月31日下午5:18:51
 * @lastTime 2018年10月31日下午5:18:51
 * @version 1.0.0
 */
@CrossOrigin
@Controller
public class UserController {

	//注入用户管理的实现接口
	@Resource
	private UserService userService;
	@Resource
	private OperService operService;
	
	@RequestMapping("/account/depoist")
	@ResponseBody
	public String deposit(HttpServletRequest request, @RequestBody Balance b) {
//		System.out.println(b.getBalance());
		System.out.println(request.getSession().getId());
		try {
			String result = operService.Depoist(request.getSession(), b.getBalance());
			return result;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	@RequestMapping("/account/drawmoney")
	@ResponseBody
	public String drawMoney(HttpSession session, @RequestBody Balance b) {
		System.out.println("取款=====>"+b.getBalance());
		try {
			String result=operService.DrawMoney(session, b.getBalance());
			return result;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	@RequestMapping("/getAmount")
	@ResponseBody
	public String getAmount(HttpSession session) {
		Account account=(Account) session.getAttribute("account");
		System.out.println(String.valueOf(account.getAccountBalance()));
		Map<String, Object> temp=new HashMap<>();
		temp.put("balance", account.getAccountBalance());
		List<Map<String, Object>> list=new ArrayList();
		list.add(temp);
		JSONArray json=new JSONArray(list);
		return json.toString();
 	}
	@RequestMapping("/account/transfer")
	@ResponseBody
	public String transfer(HttpSession session, @RequestBody SideAc sideAc) {
		System.out.println("转账======>"+sideAc.getAccount()+"  "+sideAc.getBalance()+"元");
		try {
			String result=operService.Transfer(session, sideAc.getBalance(), sideAc.getAccount());
			return result;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	@RequestMapping("/account/updatepwd")
	@ResponseBody
	public String updatePwd(HttpSession session, @RequestBody Password pass) {
		System.out.println("修改密码====》"+pass.getOldPassword()+"  "+pass.getNewPassword());
		try {
			String result=operService.updateUserPassword(pass, session);
			return result;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	@RequestMapping("/account/updateInfo")
	@ResponseBody
	public String updateInfo(HttpSession session, @RequestBody User user) {
		System.out.println("输出修改后的信息====》"+user.getUserName()+" "+user.getUserMailbox());
		Account account=(Account) session.getAttribute("account");
		try {
			String result=operService.updateInfo(user, account.getAccountId());
			System.out.println(result);
			return result;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	@RequestMapping("/account/queryUser")
	@ResponseBody
	public String queryUser(HttpSession session) {
		try {
			String result=operService.queryUser(session);
			return result;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	@RequestMapping("/account/queryOperInfo")
	@ResponseBody
	public String queryAllOperInfo(@RequestBody Balance b, HttpSession session) {
		System.out.println("页数=====>"+b.getBalance());
		try {
			String result=userService.queryall((int) b.getBalance(), session);
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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.json.JSONArray;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cdu_pfms.database.data.Account;
import cdu_pfms.database.data.Balance;
import cdu_pfms.database.data.Password;
import cdu_pfms.database.data.SideAc;
import cdu_pfms.database.data.User;
import cdu_pfms.services.OperService;
import cdu_pfms.services.UserService;

/**
 * 用户管理的控制器
 * @author Wh
 * @createTime 2018年10月31日下午5:18:51
 * @lastTime 2018年10月31日下午5:18:51
 * @version 1.0.0
 */
@CrossOrigin
@Controller
public class UserController {

	//注入用户管理的实现接口
	@Resource
	private UserService userService;
	@Resource
	private OperService operService;
	
	@RequestMapping("/account/depoist")
	@ResponseBody
	public String deposit(HttpServletRequest request, @RequestBody Balance b) {
//		System.out.println(b.getBalance());
		System.out.println(request.getSession().getId());
		try {
			String result = operService.Depoist(request.getSession(), b.getBalance());
			return result;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	@RequestMapping("/account/drawmoney")
	@ResponseBody
	public String drawMoney(HttpSession session, @RequestBody Balance b) {
		System.out.println("取款=====>"+b.getBalance());
		try {
			String result=operService.DrawMoney(session, b.getBalance());
			return result;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	@RequestMapping("/getAmount")
	@ResponseBody
	public String getAmount(HttpSession session) {
		Account account=(Account) session.getAttribute("account");
		System.out.println(String.valueOf(account.getAccountBalance()));
		Map<String, Object> temp=new HashMap<>();
		temp.put("balance", account.getAccountBalance());
		List<Map<String, Object>> list=new ArrayList();
		list.add(temp);
		JSONArray json=new JSONArray(list);
		return json.toString();
 	}
	@RequestMapping("/account/transfer")
	@ResponseBody
	public String transfer(HttpSession session, @RequestBody SideAc sideAc) {
		System.out.println("转账======>"+sideAc.getAccount()+"  "+sideAc.getBalance()+"元");
		try {
			String result=operService.Transfer(session, sideAc.getBalance(), sideAc.getAccount());
			return result;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	@RequestMapping("/account/updatepwd")
	@ResponseBody
	public String updatePwd(HttpSession session, @RequestBody Password pass) {
		System.out.println("修改密码====》"+pass.getOldPassword()+"  "+pass.getNewPassword());
		try {
			String result=operService.updateUserPassword(pass, session);
			return result;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	@RequestMapping("/account/updateInfo")
	@ResponseBody
	public String updateInfo(HttpSession session, @RequestBody User user) {
		System.out.println("输出修改后的信息====》"+user.getUserName()+" "+user.getUserMailbox());
		Account account=(Account) session.getAttribute("account");
		try {
			String result=operService.updateInfo(user, account.getAccountId());
			System.out.println(result);
			return result;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	@RequestMapping("/account/queryUser")
	@ResponseBody
	public String queryUser(HttpSession session) {
		try {
			String result=operService.queryUser(session);
			return result;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	@RequestMapping("/account/queryOperInfo")
	@ResponseBody
	public String queryAllOperInfo(@RequestBody Balance b, HttpSession session) {
		System.out.println("页数=====>"+b.getBalance());
		try {
			String result=userService.queryall((int) b.getBalance(), session);
			return result;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
}
>>>>>>> second commit
