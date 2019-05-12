<<<<<<< HEAD
package cdu_pfms.services;

import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;

import cdu_pfms.database.data.AcInfo;
import cdu_pfms.database.data.User;

/**
 * 用户的业务处理接口
 * @author Wh
 * @createTime 2018年11月1日上午9:01:37
 * @lastTime 2018年11月1日上午9:01:37
 * @version 1.0.0
 */
public interface UserService {

	/**
	 * 查询用户的信息
	 * @param userAccount
	 * @param model
	 * @return
	 * @throws Exception
	 */
	public String queryall(HttpSession session) throws Exception;
	/**
	 * 实现了分页的查询用户信息
	 * @param pageNumber
	 * @param session
	 * @return
	 * @throws Exception
	 */
	public String queryall(Integer pageNumber, HttpSession session) throws Exception;
	
	/**
	 * 用户注册
	 * @return
	 * @throws Exception
	 */
	public String enroll(AcInfo ac, User user) throws Exception;
	
}
=======
package cdu_pfms.services;

import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;

import cdu_pfms.database.data.AcInfo;
import cdu_pfms.database.data.User;

/**
 * 用户的业务处理接口
 * @author Wh
 * @createTime 2018年11月1日上午9:01:37
 * @lastTime 2018年11月1日上午9:01:37
 * @version 1.0.0
 */
public interface UserService {

	/**
	 * 查询用户的信息
	 * @param userAccount
	 * @param model
	 * @return
	 * @throws Exception
	 */
	public String queryall(HttpSession session) throws Exception;
	/**
	 * 实现了分页的查询用户信息
	 * @param pageNumber
	 * @param session
	 * @return
	 * @throws Exception
	 */
	public String queryall(Integer pageNumber, HttpSession session) throws Exception;
	
	/**
	 * 用户注册
	 * @return
	 * @throws Exception
	 */
	public String enroll(AcInfo ac, User user) throws Exception;
	
}
>>>>>>> second commit
