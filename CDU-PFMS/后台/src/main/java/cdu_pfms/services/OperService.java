<<<<<<< HEAD
package cdu_pfms.services;

import javax.servlet.http.HttpSession;

import cdu_pfms.database.data.Account;
import cdu_pfms.database.data.Password;
import cdu_pfms.database.data.User;

/**
 * 存钱业务接口
 * @author ZhouLinHu
 * @createTime 2018年11月12日 下午2:15:36
 * @lastTime 2018年11月12日 下午2:15:36
 * @version 1.0.0
 */
public interface OperService {
	
	/**
	 * 存钱操作
	 * @author ZhouLinHu
	 * @param account
	 * @param balance
	 * @return
	 * @throws Exception
	 */
	public String Depoist(Account account, double balance) throws Exception;
	public String Depoist(HttpSession session, double balance) throws Exception;

	/**
	 * 取款操作
	 * @author ZhouLinHu
	 * @param account
	 * @param balance
	 * @return
	 * @throws Exception
	 */
	public String DrawMoney(Account account, double balance) throws Exception;
	public String DrawMoney(HttpSession session, double balance) throws Exception;
	
	/**
	 * 转账操作
	 * @author ZhouLinHu
	 * @param account
	 * @param balance
	 * @param sideAccount
	 * @return
	 * @throws Exception
	 */
	public String Transfer(Account account, double balance, String sideAccount) throws Exception;
	public String Transfer(HttpSession session, double balance, String sideAccount) throws Exception;
	
	/**
	 * 修改账户的用户信息
	 * @author ZhouLinHu
	 * @param user
	 * @param account
	 * @return
	 * @throws Exception
	 */
	public String updateInfo(User user, String account) throws Exception;
	
	/**
	 * 修改账户密码
	 * @author ZhouLinHu
	 * @param oldPassword
	 * @param newPassword
	 * @return
	 * @throws Exception
	 */
	public String updateUserPassword(String oldPassword, String newPassword, String accountId) throws Exception;
	public String updateUserPassword(Password pass, HttpSession session) throws Exception;
	
	/**
	 * 得到账户中用户的信息
	 * @param session
	 * @return
	 * @throws Exception
	 */
	public String queryUser(HttpSession session) throws Exception;
}
=======
package cdu_pfms.services;

import javax.servlet.http.HttpSession;

import cdu_pfms.database.data.Account;
import cdu_pfms.database.data.Password;
import cdu_pfms.database.data.User;

/**
 * 存钱业务接口
 * @author ZhouLinHu
 * @createTime 2018年11月12日 下午2:15:36
 * @lastTime 2018年11月12日 下午2:15:36
 * @version 1.0.0
 */
public interface OperService {
	
	/**
	 * 存钱操作
	 * @author ZhouLinHu
	 * @param account
	 * @param balance
	 * @return
	 * @throws Exception
	 */
	public String Depoist(Account account, double balance) throws Exception;
	public String Depoist(HttpSession session, double balance) throws Exception;

	/**
	 * 取款操作
	 * @author ZhouLinHu
	 * @param account
	 * @param balance
	 * @return
	 * @throws Exception
	 */
	public String DrawMoney(Account account, double balance) throws Exception;
	public String DrawMoney(HttpSession session, double balance) throws Exception;
	
	/**
	 * 转账操作
	 * @author ZhouLinHu
	 * @param account
	 * @param balance
	 * @param sideAccount
	 * @return
	 * @throws Exception
	 */
	public String Transfer(Account account, double balance, String sideAccount) throws Exception;
	public String Transfer(HttpSession session, double balance, String sideAccount) throws Exception;
	
	/**
	 * 修改账户的用户信息
	 * @author ZhouLinHu
	 * @param user
	 * @param account
	 * @return
	 * @throws Exception
	 */
	public String updateInfo(User user, String account) throws Exception;
	
	/**
	 * 修改账户密码
	 * @author ZhouLinHu
	 * @param oldPassword
	 * @param newPassword
	 * @return
	 * @throws Exception
	 */
	public String updateUserPassword(String oldPassword, String newPassword, String accountId) throws Exception;
	public String updateUserPassword(Password pass, HttpSession session) throws Exception;
	
	/**
	 * 得到账户中用户的信息
	 * @param session
	 * @return
	 * @throws Exception
	 */
	public String queryUser(HttpSession session) throws Exception;
}
>>>>>>> second commit
