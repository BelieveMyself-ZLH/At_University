<<<<<<< HEAD
package cdu_pfms.services.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.json.JSONArray;
import org.springframework.stereotype.Service;

import cdu_pfms.database.data.AcInfo;
import cdu_pfms.database.data.Account;
import cdu_pfms.database.data.AccountOper;
import cdu_pfms.database.data.User;
import cdu_pfms.database.idao.AccountMapper;
import cdu_pfms.database.idao.AccountOperMapper;
import cdu_pfms.database.idao.UserMapper;
import cdu_pfms.services.UserService;
import cdu_pfms.utils.PageUtils;

/**
 * 用户操作的业务处理具体实现类
 * @author Wh
 * @createTime 2018年11月1日上午11:06:11
 * @lastTime 2018年11月1日上午11:06:11
 * @version 1.0.0
 */
@Service
public class UserServiceImpl implements UserService {

	@Resource
	private AccountOperMapper mapper;
	@Resource
	private UserMapper userMapper;
	@Resource
	private AccountMapper accMapper;
	
	@Override
	public String queryall(HttpSession session) throws Exception {
		Account account=(Account) session.getAttribute("account");
		System.out.println("=====>"+account.getAccountId());
		List<AccountOper> list=mapper.queryAll(account.getAccountId());
		List<Map<String, Object>> listInfo=new ArrayList<>();
		String str="";
		for(AccountOper ac : list) {
			int type=ac.getUserOperType();
			if(type==0) {
				str="存钱";
			}else if(type==1) {
				str="取钱";
			}else if(type==2) {
				str="转账";
			}else if(type==3) {
				str="收帐";
			}
			Map<String, Object> temp=new HashMap<>();
			temp.put("type", str);
			temp.put("amount", ac.getUserOperAmount());
			temp.put("obj", ac.getUser_OperAccount());
			temp.put("opertime", ac.getUserOperTime());
			listInfo.add(temp);
		}
		JSONArray json=new JSONArray(listInfo);
		return json.toString();
	}
	@Override
	public String queryall(Integer pageNumber, HttpSession session) throws Exception {
		Account account=(Account) session.getAttribute("account");
		//每页最大行数
		int maxRowCount = 5;
		//总行数
		int totalRowCount = mapper.getRowCount(account.getAccountId());
		System.out.println(totalRowCount);
		//声明封装分页相关属性的图的集合变量并赋值
		Map<String, Integer> prop=PageUtils.calcPageProperties(totalRowCount, maxRowCount, pageNumber);
		//声明封装数据的集合变量
		List<AccountOper> list=mapper.queryByPage(prop.get("startIndex"), maxRowCount,account.getAccountId());
		JSONArray json=new JSONArray(list);
		json.put(prop);
		return json.toString();
	}
	@Override
	public String enroll(AcInfo ac, User user) throws Exception {
		//注册增加用户信息
		userMapper.enroll(user);
		//得到userId
		int userId=userMapper.getId(user);
		//封装Account
		Account account=new Account();
		account.setAccountId(ac.getUserName());
		account.setAccountPassword(ac.getPassword());
		account.setAccountState(1);
		account.setUserId(userId);
		account.setAccountBalance(0);
		account.setAccountCreateTime(new Timestamp(System.currentTimeMillis()));
		//注册增加账户信息
		accMapper.enroll(account);
		return "success";
	}
}
=======
package cdu_pfms.services.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.json.JSONArray;
import org.springframework.stereotype.Service;

import cdu_pfms.database.data.AcInfo;
import cdu_pfms.database.data.Account;
import cdu_pfms.database.data.AccountOper;
import cdu_pfms.database.data.User;
import cdu_pfms.database.idao.AccountMapper;
import cdu_pfms.database.idao.AccountOperMapper;
import cdu_pfms.database.idao.UserMapper;
import cdu_pfms.services.UserService;
import cdu_pfms.utils.PageUtils;

/**
 * 用户操作的业务处理具体实现类
 * @author Wh
 * @createTime 2018年11月1日上午11:06:11
 * @lastTime 2018年11月1日上午11:06:11
 * @version 1.0.0
 */
@Service
public class UserServiceImpl implements UserService {

	@Resource
	private AccountOperMapper mapper;
	@Resource
	private UserMapper userMapper;
	@Resource
	private AccountMapper accMapper;
	
	@Override
	public String queryall(HttpSession session) throws Exception {
		Account account=(Account) session.getAttribute("account");
		System.out.println("=====>"+account.getAccountId());
		List<AccountOper> list=mapper.queryAll(account.getAccountId());
		List<Map<String, Object>> listInfo=new ArrayList<>();
		String str="";
		for(AccountOper ac : list) {
			int type=ac.getUserOperType();
			if(type==0) {
				str="存钱";
			}else if(type==1) {
				str="取钱";
			}else if(type==2) {
				str="转账";
			}else if(type==3) {
				str="收帐";
			}
			Map<String, Object> temp=new HashMap<>();
			temp.put("type", str);
			temp.put("amount", ac.getUserOperAmount());
			temp.put("obj", ac.getUser_OperAccount());
			temp.put("opertime", ac.getUserOperTime());
			listInfo.add(temp);
		}
		JSONArray json=new JSONArray(listInfo);
		return json.toString();
	}
	@Override
	public String queryall(Integer pageNumber, HttpSession session) throws Exception {
		Account account=(Account) session.getAttribute("account");
		//每页最大行数
		int maxRowCount = 5;
		//总行数
		int totalRowCount = mapper.getRowCount(account.getAccountId());
		System.out.println(totalRowCount);
		//声明封装分页相关属性的图的集合变量并赋值
		Map<String, Integer> prop=PageUtils.calcPageProperties(totalRowCount, maxRowCount, pageNumber);
		//声明封装数据的集合变量
		List<AccountOper> list=mapper.queryByPage(prop.get("startIndex"), maxRowCount,account.getAccountId());
		JSONArray json=new JSONArray(list);
		json.put(prop);
		return json.toString();
	}
	@Override
	public String enroll(AcInfo ac, User user) throws Exception {
		//注册增加用户信息
		userMapper.enroll(user);
		//得到userId
		int userId=userMapper.getId(user);
		//封装Account
		Account account=new Account();
		account.setAccountId(ac.getUserName());
		account.setAccountPassword(ac.getPassword());
		account.setAccountState(1);
		account.setUserId(userId);
		account.setAccountBalance(0);
		account.setAccountCreateTime(new Timestamp(System.currentTimeMillis()));
		//注册增加账户信息
		accMapper.enroll(account);
		return "success";
	}
}
>>>>>>> second commit
