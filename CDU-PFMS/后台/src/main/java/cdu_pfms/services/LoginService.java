<<<<<<< HEAD
package cdu_pfms.services;

import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.support.SessionStatus;

import cdu_pfms.database.data.Account;
import cdu_pfms.database.data.User;

/**
 * 登录业务处理接口
 * @author Wh
 * @createTime 2018年11月2日上午10:03:59
 * @lastTime 2018年11月2日上午10:03:59
 * @version 1.0.0
 */
public interface LoginService {
	
	/**
	 * 用户注册
	 * @param user
	 * @param model
	 * @return
	 * @throws Exception
	 */
	public String enroll(Account account,User user, Model model) throws Exception;

	/**
	 * 用户账号密码登录
	 * @param userAccount
	 * @param userPassword
	 * @param model
	 * @return
	 * @throws Exception
	 */
	public String userLogin(String accountId, String accountPassword, Model model) throws Exception;
	
	/**
	 * 管理员登录
	 * @param adminId
	 * @param adminPassword
	 * @param model
	 * @return
	 * @throws Exception
	 */
	public String adminLogin(String accountId, String accountPassword, Model model) throws Exception;
	
	/**
	 * 退出登录
	 * @param session
	 * @param sessionStatus
	 * @return
	 * @throws Exception
	 */
	public String logout(HttpSession session, SessionStatus sessionStatus) throws Exception;
	
	/**
	 * 用户找会密码
	 * @param account
	 * @param password
	 * @param mail
	 * @return
	 * @throws Exception
	 */
	public String forgetPass(String account, String username, String mail) throws Exception;
	
	/**================================修改登陆==================================**/
	/**
	 * 请求登陆
	 * @author ZhouLinHu
	 * @param accountId
	 * @param accountPassword
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public String login(String accountId, String accountPassword, HttpSession session) throws Exception;
}
=======
package cdu_pfms.services;

import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.support.SessionStatus;

import cdu_pfms.database.data.Account;
import cdu_pfms.database.data.User;

/**
 * 登录业务处理接口
 * @author Wh
 * @createTime 2018年11月2日上午10:03:59
 * @lastTime 2018年11月2日上午10:03:59
 * @version 1.0.0
 */
public interface LoginService {
	
	/**
	 * 用户注册
	 * @param user
	 * @param model
	 * @return
	 * @throws Exception
	 */
	public String enroll(Account account,User user, Model model) throws Exception;

	/**
	 * 用户账号密码登录
	 * @param userAccount
	 * @param userPassword
	 * @param model
	 * @return
	 * @throws Exception
	 */
	public String userLogin(String accountId, String accountPassword, Model model) throws Exception;
	
	/**
	 * 管理员登录
	 * @param adminId
	 * @param adminPassword
	 * @param model
	 * @return
	 * @throws Exception
	 */
	public String adminLogin(String accountId, String accountPassword, Model model) throws Exception;
	
	/**
	 * 退出登录
	 * @param session
	 * @param sessionStatus
	 * @return
	 * @throws Exception
	 */
	public String logout(HttpSession session, SessionStatus sessionStatus) throws Exception;
	
	/**
	 * 用户找会密码
	 * @param account
	 * @param password
	 * @param mail
	 * @return
	 * @throws Exception
	 */
	public String forgetPass(String account, String username, String mail) throws Exception;
	
	/**================================修改登陆==================================**/
	/**
	 * 请求登陆
	 * @author ZhouLinHu
	 * @param accountId
	 * @param accountPassword
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public String login(String accountId, String accountPassword, HttpSession session) throws Exception;
}
>>>>>>> second commit
