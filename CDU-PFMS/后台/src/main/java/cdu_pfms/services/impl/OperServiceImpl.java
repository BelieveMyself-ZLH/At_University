<<<<<<< HEAD
package cdu_pfms.services.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.json.JSONArray;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import cdu_pfms.database.data.Account;
import cdu_pfms.database.data.AccountOper;
import cdu_pfms.database.data.Password;
import cdu_pfms.database.data.User;
import cdu_pfms.database.idao.AccountMapper;
import cdu_pfms.database.idao.AccountOperMapper;
import cdu_pfms.database.idao.UserMapper;
import cdu_pfms.services.OperService;

@Service
public class OperServiceImpl implements OperService {

	//注入账户表数据访问接口
	@Resource
	private AccountMapper accMapper;
	//注入账户操作数据表访问接口
	@Resource
	private AccountOperMapper accOperMapper;
	//注入用户信息数据访问接口
	@Resource
	private UserMapper userMapper;
	
	@Override
	public String Depoist(Account account, double balance) throws Exception {
		//得到账户的id
		String accId=account.getAccountId();
		//之前的balance
		double old=balance;
		//对金额进行重新设定
		balance=balance+account.getAccountBalance();
		//存钱操作
		accMapper.updateBalance(accId, balance);
		//封装一个操作信息对象
		AccountOper accOper=new AccountOper();
		accOper.setAccId(accId);
		accOper.setUserOperAmount(old);
		accOper.setUserOperType(0);
		accOper.setUser_OperAccount("当前账户");
		accOper.setUserOperTime(new Timestamp(System.currentTimeMillis()));
		accOperMapper.addOper(accOper);
		return "success";
	}

	@Override
	public String DrawMoney(Account account, double balance) throws Exception {
		//得到账户id
		String accId=account.getAccountId();
		//保留之前的balance
		double old=balance;
		//对金额重新设定
		balance=account.getAccountBalance()-balance;
		//取钱操作
		accMapper.updateBalance(accId, balance);
		//封装一个操作信息对象
		AccountOper accOper=new AccountOper();
		accOper.setAccId(accId);
		accOper.setUserOperAmount(old);
		accOper.setUserOperType(1);
		accOper.setUser_OperAccount("当前账户");
		accOper.setUserOperTime(new Timestamp(System.currentTimeMillis()));
		accOperMapper.addOper(accOper);
		return "success";
	}

	@Override
	public String Transfer(Account account, double balance, String sideAccount) throws Exception {
		//得到账户id
		String accId=account.getAccountId();
		//对方账户获得金额
		double addBalance=balance;
		//封装一个操作信息对象
		AccountOper accOper=new AccountOper();
		accOper.setAccId(accId);
		accOper.setUserOperAmount(balance);
		accOper.setUserOperType(2);
		accOper.setUser_OperAccount(sideAccount);
		accOper.setUserOperTime(new Timestamp(System.currentTimeMillis()));
		//对金额重新设定
		balance=account.getAccountBalance()-balance;
		//取钱操作
		accMapper.updateBalance(accId, balance);
		accOperMapper.addOper(accOper);
		
//		//得到对方账户信息
		Account accountSide=accMapper.queryAccById(sideAccount);
		//封装一个操作信息对象
		AccountOper accOper1=new AccountOper();
		accOper1.setAccId(sideAccount);
		accOper1.setUserOperAmount(addBalance);
		accOper1.setUserOperType(3);
		accOper1.setUser_OperAccount(accId);
		accOper1.setUserOperTime(new Timestamp(System.currentTimeMillis()));
		//修改对方账户金额
		addBalance=accountSide.getAccountBalance()+addBalance;
		accMapper.updateBalance(sideAccount, addBalance);
		accOperMapper.addOper(accOper1);
		return "success";
	}

	@Override
	public String updateInfo(User user, String account) throws Exception {
		//得到账户信息
		Account acc=accMapper.queryAccById(account);
		user.setUserId(acc.getUserId());
		//修改该信息
		userMapper.update(user);
		return "success";
	}

	@Override
	public String updateUserPassword(String oldPassword, String newPassword, String accountId) throws Exception {
		if(accMapper.queryAccById(accountId).getAccountPassword().equals(oldPassword)) {
			accMapper.updatePassword(accountId, newPassword);
			return "success";
		}else {
			return "密码错误";
		}
	}
	
	@Override
	public String queryUser(HttpSession session) throws Exception {
		Account account=(Account) session.getAttribute("account");
		User user=userMapper.queryById(account.getUserId());
		System.out.println("用户信息======>"+user.getUserName()+" "+user.getUserPhone());
		List<Map<String, Object>> list=new ArrayList();
		Map<String, Object> temp=new HashMap();
		temp.put("userName", user.getUserName());
		temp.put("userBirthday", user.getUserBirthday());
		temp.put("userGender", user.getUserGender());
		temp.put("userAddress", user.getUserAddress());
		temp.put("userPhone", user.getUserPhone());
		temp.put("userIdcard", user.getUserIdcard());
		temp.put("userMailbox", user.getUserMailbox());
		list.add(temp);
		JSONArray json=new JSONArray(list);
		return json.toString();
	}
	
	/**===========================修改操作方法，添加Session参数======================**/
	@Override
	public String Depoist(HttpSession session, double balance) throws Exception {
		Account account=(Account) session.getAttribute("account");
		account=accMapper.queryAccById(account.getAccountId());
		return Depoist(account, balance);
	}

	@Override
	public String DrawMoney(HttpSession session, double balance) throws Exception {
		Account account=(Account) session.getAttribute("account");
		account=accMapper.queryAccById(account.getAccountId());
		return DrawMoney(account, balance);
	}

	@Override
	public String Transfer(HttpSession session, double balance, String sideAccount) throws Exception {
		Account account=(Account) session.getAttribute("account");
		account=accMapper.queryAccById(account.getAccountId());
		return Transfer(account, balance, sideAccount);
	}

	@Override
	public String updateUserPassword(Password pass, HttpSession session) throws Exception {
		Account account=(Account) session.getAttribute("account");
		return updateUserPassword(pass.getOldPassword(), pass.getNewPassword(), account.getAccountId());
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
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.json.JSONArray;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import cdu_pfms.database.data.Account;
import cdu_pfms.database.data.AccountOper;
import cdu_pfms.database.data.Password;
import cdu_pfms.database.data.User;
import cdu_pfms.database.idao.AccountMapper;
import cdu_pfms.database.idao.AccountOperMapper;
import cdu_pfms.database.idao.UserMapper;
import cdu_pfms.services.OperService;

@Service
public class OperServiceImpl implements OperService {

	//注入账户表数据访问接口
	@Resource
	private AccountMapper accMapper;
	//注入账户操作数据表访问接口
	@Resource
	private AccountOperMapper accOperMapper;
	//注入用户信息数据访问接口
	@Resource
	private UserMapper userMapper;
	
	@Override
	public String Depoist(Account account, double balance) throws Exception {
		//得到账户的id
		String accId=account.getAccountId();
		//之前的balance
		double old=balance;
		//对金额进行重新设定
		balance=balance+account.getAccountBalance();
		//存钱操作
		accMapper.updateBalance(accId, balance);
		//封装一个操作信息对象
		AccountOper accOper=new AccountOper();
		accOper.setAccId(accId);
		accOper.setUserOperAmount(old);
		accOper.setUserOperType(0);
		accOper.setUser_OperAccount("当前账户");
		accOper.setUserOperTime(new Timestamp(System.currentTimeMillis()));
		accOperMapper.addOper(accOper);
		return "success";
	}

	@Override
	public String DrawMoney(Account account, double balance) throws Exception {
		//得到账户id
		String accId=account.getAccountId();
		//保留之前的balance
		double old=balance;
		//对金额重新设定
		balance=account.getAccountBalance()-balance;
		//取钱操作
		accMapper.updateBalance(accId, balance);
		//封装一个操作信息对象
		AccountOper accOper=new AccountOper();
		accOper.setAccId(accId);
		accOper.setUserOperAmount(old);
		accOper.setUserOperType(1);
		accOper.setUser_OperAccount("当前账户");
		accOper.setUserOperTime(new Timestamp(System.currentTimeMillis()));
		accOperMapper.addOper(accOper);
		return "success";
	}

	@Override
	public String Transfer(Account account, double balance, String sideAccount) throws Exception {
		//得到账户id
		String accId=account.getAccountId();
		//对方账户获得金额
		double addBalance=balance;
		//封装一个操作信息对象
		AccountOper accOper=new AccountOper();
		accOper.setAccId(accId);
		accOper.setUserOperAmount(balance);
		accOper.setUserOperType(2);
		accOper.setUser_OperAccount(sideAccount);
		accOper.setUserOperTime(new Timestamp(System.currentTimeMillis()));
		//对金额重新设定
		balance=account.getAccountBalance()-balance;
		//取钱操作
		accMapper.updateBalance(accId, balance);
		accOperMapper.addOper(accOper);
		
//		//得到对方账户信息
		Account accountSide=accMapper.queryAccById(sideAccount);
		//封装一个操作信息对象
		AccountOper accOper1=new AccountOper();
		accOper1.setAccId(sideAccount);
		accOper1.setUserOperAmount(addBalance);
		accOper1.setUserOperType(3);
		accOper1.setUser_OperAccount(accId);
		accOper1.setUserOperTime(new Timestamp(System.currentTimeMillis()));
		//修改对方账户金额
		addBalance=accountSide.getAccountBalance()+addBalance;
		accMapper.updateBalance(sideAccount, addBalance);
		accOperMapper.addOper(accOper1);
		return "success";
	}

	@Override
	public String updateInfo(User user, String account) throws Exception {
		//得到账户信息
		Account acc=accMapper.queryAccById(account);
		user.setUserId(acc.getUserId());
		//修改该信息
		userMapper.update(user);
		return "success";
	}

	@Override
	public String updateUserPassword(String oldPassword, String newPassword, String accountId) throws Exception {
		if(accMapper.queryAccById(accountId).getAccountPassword().equals(oldPassword)) {
			accMapper.updatePassword(accountId, newPassword);
			return "success";
		}else {
			return "密码错误";
		}
	}
	
	@Override
	public String queryUser(HttpSession session) throws Exception {
		Account account=(Account) session.getAttribute("account");
		User user=userMapper.queryById(account.getUserId());
		System.out.println("用户信息======>"+user.getUserName()+" "+user.getUserPhone());
		List<Map<String, Object>> list=new ArrayList();
		Map<String, Object> temp=new HashMap();
		temp.put("userName", user.getUserName());
		temp.put("userBirthday", user.getUserBirthday());
		temp.put("userGender", user.getUserGender());
		temp.put("userAddress", user.getUserAddress());
		temp.put("userPhone", user.getUserPhone());
		temp.put("userIdcard", user.getUserIdcard());
		temp.put("userMailbox", user.getUserMailbox());
		list.add(temp);
		JSONArray json=new JSONArray(list);
		return json.toString();
	}
	
	/**===========================修改操作方法，添加Session参数======================**/
	@Override
	public String Depoist(HttpSession session, double balance) throws Exception {
		Account account=(Account) session.getAttribute("account");
		account=accMapper.queryAccById(account.getAccountId());
		return Depoist(account, balance);
	}

	@Override
	public String DrawMoney(HttpSession session, double balance) throws Exception {
		Account account=(Account) session.getAttribute("account");
		account=accMapper.queryAccById(account.getAccountId());
		return DrawMoney(account, balance);
	}

	@Override
	public String Transfer(HttpSession session, double balance, String sideAccount) throws Exception {
		Account account=(Account) session.getAttribute("account");
		account=accMapper.queryAccById(account.getAccountId());
		return Transfer(account, balance, sideAccount);
	}

	@Override
	public String updateUserPassword(Password pass, HttpSession session) throws Exception {
		Account account=(Account) session.getAttribute("account");
		return updateUserPassword(pass.getOldPassword(), pass.getNewPassword(), account.getAccountId());
	}
	
}
>>>>>>> second commit
