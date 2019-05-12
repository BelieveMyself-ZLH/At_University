<<<<<<< HEAD
package cdu_pfms.controllers;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cdu_pfms.services.AdminService;
import cdu_pfms.services.NewsService;

/**
 * 管理员的控制器
 * @author Wh
 * @createTime 2018年10月31日下午5:21:40
 * @lastTime 2018年10月31日下午5:21:40
 * @version 1.0.0
 */
@CrossOrigin
@Controller
public class AdminController {

	//注入管理员管理的实现接口
	@Resource
	private AdminService adminService;
	@Resource
	private NewsService newsService;

	/**
	 * 查询所有账户
	 * @return
	 */
	@RequestMapping("/getAllAccounts")
	@ResponseBody
	public String queyrAllAccounts(String accountId,Integer pageNumber){
		try {
			System.out.println("AccountID"+accountId+" pageNumber:"+pageNumber);
			String result = adminService.checkAllAccounts(accountId,pageNumber);
			return result;
		}catch (Exception e){
			e.printStackTrace();
			System.out.println("查询用户失败");
			return "{'error'：'查询失败'}";
		}
	}
//	public String queyrAllAccounts(@RequestBody Map<String,String> map){
//		try {
//			//Integer pageNumber = Integer.valueOf(map.get("pageNumber"));
//			String accountId = map.get("accountId");
//			String result = adminService.checkAllAccounts(accountId,1);
//			return result;
//		}catch (Exception e){
//			e.printStackTrace();
//			System.out.println("查询用户失败");
//			return "{'error'：'查询失败'}";
//		}
//
//	}

	/**
	 * 查询所有冻结账户
	 * @return
	 */
	@RequestMapping("/getFrozenAccounts")
	@ResponseBody
	public String queryFrozen(String accountId,Integer pageNumber){
		try {
			String result =adminService.checkFrozenAccounts(accountId,pageNumber);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return "{'error'：'查询冻结账户的操作失败'}";
		}
	}


	/**
	 * 查询所有开启账户
	 * @return
	 */
	@RequestMapping("/getOpenedAccounts")
	@ResponseBody
	public String queryOpened(String accountId,Integer pageNumber){
		try {
			String result =adminService.checkOpenedAccounts(accountId,pageNumber);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return "{'error'：'查询已开启账户的操作失败'}";
		}
	}

	//改变管理员密码
	@RequestMapping("/changedPassword")
	@ResponseBody
	public String changePassword(String current,String changed){
		try {
			String result =adminService.changePassword(current,changed);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return "{'error'：'改变密码的操作失败'}";
		}
	}

   //冻结账户(用accountId)
	@RequestMapping("/frozenAccount")
	@ResponseBody
	public String frozenAccount(String accountId){
		try {
			String result =adminService.frozenAccount(accountId);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return "{'error'：'冻结账户的操作失败'}";
		}
	}

	//恢复账户(用accountId)
	@RequestMapping("/recoverAccount")
	@ResponseBody
	public String recoverAccount(String accountId){
		try {
			String result =adminService.resumeAccount(accountId);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return "{'error'：'恢复账户的操作失败'}";
		}
	}

	//删除账户(用accountId)
	@RequestMapping("/deleteAccount")
	@ResponseBody
	public String deleteAccount(String accountId){
		try {
			String result =adminService.deleteAccount(accountId);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return "{'error'：'删除账户的操作失败'}";
		}
	}

	/***************新闻Controller****************/

	//显示所有 或者 按标题查询
	@RequestMapping("/queryNews")
	@ResponseBody
	public String queryNews(String newsTitle,Integer pageNumber){
		String result=null;
		try {
			if (newsTitle!=null&&!"".equals(newsTitle)){
				result=newsService.queryByTitle(newsTitle,pageNumber);
			}
			else {
				result=newsService.queryAllNews(pageNumber);
			}
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return "{'error'：'查询所有新闻的操作失败'}";
		}
	}

	//添加一条新闻
	@RequestMapping("/addNews")
	@ResponseBody
	public String addNews(@RequestBody Map<String,String> map){
        try {
            if(map!=null){
                String result = newsService.insertNews(map);
                return result;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "{'error'：'添加新闻的操作失败'}";
        }
        return "{'error': 'news为空值'}";
	}

	//删除一条新闻
	@RequestMapping("/deleteNews")
	@ResponseBody
	public String deleteNews(Integer newsId){
        try {
                String result = newsService.deleteNews(newsId);
                return result;
        } catch (Exception e) {
            e.printStackTrace();
            return "{'error'：'删除新闻的操作失败'}";
        }
    }
}
=======
package cdu_pfms.controllers;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cdu_pfms.services.AdminService;
import cdu_pfms.services.NewsService;

/**
 * 管理员的控制器
 * @author Wh
 * @createTime 2018年10月31日下午5:21:40
 * @lastTime 2018年10月31日下午5:21:40
 * @version 1.0.0
 */
@CrossOrigin
@Controller
public class AdminController {

	//注入管理员管理的实现接口
	@Resource
	private AdminService adminService;
	@Resource
	private NewsService newsService;

	/**
	 * 查询所有账户
	 * @return
	 */
	@RequestMapping("/getAllAccounts")
	@ResponseBody
	public String queyrAllAccounts(String accountId,Integer pageNumber){
		try {
			System.out.println("AccountID"+accountId+" pageNumber:"+pageNumber);
			String result = adminService.checkAllAccounts(accountId,pageNumber);
			return result;
		}catch (Exception e){
			e.printStackTrace();
			System.out.println("查询用户失败");
			return "{'error'：'查询失败'}";
		}
	}
//	public String queyrAllAccounts(@RequestBody Map<String,String> map){
//		try {
//			//Integer pageNumber = Integer.valueOf(map.get("pageNumber"));
//			String accountId = map.get("accountId");
//			String result = adminService.checkAllAccounts(accountId,1);
//			return result;
//		}catch (Exception e){
//			e.printStackTrace();
//			System.out.println("查询用户失败");
//			return "{'error'：'查询失败'}";
//		}
//
//	}

	/**
	 * 查询所有冻结账户
	 * @return
	 */
	@RequestMapping("/getFrozenAccounts")
	@ResponseBody
	public String queryFrozen(String accountId,Integer pageNumber){
		try {
			String result =adminService.checkFrozenAccounts(accountId,pageNumber);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return "{'error'：'查询冻结账户的操作失败'}";
		}
	}


	/**
	 * 查询所有开启账户
	 * @return
	 */
	@RequestMapping("/getOpenedAccounts")
	@ResponseBody
	public String queryOpened(String accountId,Integer pageNumber){
		try {
			String result =adminService.checkOpenedAccounts(accountId,pageNumber);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return "{'error'：'查询已开启账户的操作失败'}";
		}
	}

	//改变管理员密码
	@RequestMapping("/changedPassword")
	@ResponseBody
	public String changePassword(String current,String changed){
		try {
			String result =adminService.changePassword(current,changed);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return "{'error'：'改变密码的操作失败'}";
		}
	}

   //冻结账户(用accountId)
	@RequestMapping("/frozenAccount")
	@ResponseBody
	public String frozenAccount(String accountId){
		try {
			String result =adminService.frozenAccount(accountId);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return "{'error'：'冻结账户的操作失败'}";
		}
	}

	//恢复账户(用accountId)
	@RequestMapping("/recoverAccount")
	@ResponseBody
	public String recoverAccount(String accountId){
		try {
			String result =adminService.resumeAccount(accountId);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return "{'error'：'恢复账户的操作失败'}";
		}
	}

	//删除账户(用accountId)
	@RequestMapping("/deleteAccount")
	@ResponseBody
	public String deleteAccount(String accountId){
		try {
			String result =adminService.deleteAccount(accountId);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return "{'error'：'删除账户的操作失败'}";
		}
	}

	/***************新闻Controller****************/

	//显示所有 或者 按标题查询
	@RequestMapping("/queryNews")
	@ResponseBody
	public String queryNews(String newsTitle,Integer pageNumber){
		String result=null;
		try {
			if (newsTitle!=null&&!"".equals(newsTitle)){
				result=newsService.queryByTitle(newsTitle,pageNumber);
			}
			else {
				result=newsService.queryAllNews(pageNumber);
			}
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return "{'error'：'查询所有新闻的操作失败'}";
		}
	}

	//添加一条新闻
	@RequestMapping("/addNews")
	@ResponseBody
	public String addNews(@RequestBody Map<String,String> map){
        try {
            if(map!=null){
                String result = newsService.insertNews(map);
                return result;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "{'error'：'添加新闻的操作失败'}";
        }
        return "{'error': 'news为空值'}";
	}

	//删除一条新闻
	@RequestMapping("/deleteNews")
	@ResponseBody
	public String deleteNews(Integer newsId){
        try {
                String result = newsService.deleteNews(newsId);
                return result;
        } catch (Exception e) {
            e.printStackTrace();
            return "{'error'：'删除新闻的操作失败'}";
        }
    }
}
>>>>>>> second commit
