<<<<<<< HEAD
package cdu_pfms.services.impl;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.json.JSONArray;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import cdu_pfms.database.data.Account1;
import cdu_pfms.database.data.News;
import cdu_pfms.database.idao.AccountMapper;
import cdu_pfms.database.idao.NewsMapper;
import cdu_pfms.services.AdminService;
import cdu_pfms.services.NewsService;
import cdu_pfms.utils.IPageUtils;

/**
 * @description:  修改账户的函数
 * @author: meng.pc
 * @date: 2018-11-12 10:56
 */
@Service
public class AdminServiceImpl implements AdminService,NewsService {
    @Resource
    private AccountMapper accountMapper;
    public static int maxRowCount = 5;
    //总行数
    public static int totalRowCount = 0;
    public static List<Account1> list=null;
    public static Map<String,Integer> prop = null;
    public static JSONArray jsonArray =null;
    //查看所有账户信息(按用户名字查看账户信息)
    @Override
    public String checkAllAccounts(String accountId,Integer pageNumber) throws Exception {
    	List<Account1> list=new ArrayList<>();
    	System.out.println(accountId);
        totalRowCount = accountMapper.getRowCount(accountId);
        prop = IPageUtils.calPageProperties(totalRowCount,maxRowCount,pageNumber);
            if(accountId!=null&&!"".equals(accountId)){
                Account1 account = accountMapper.queryByIdPage(accountId,prop.get("startIndex"),maxRowCount);
                list.add(account);
            }else {
                list = accountMapper.queryByPage(prop.get("startIndex"),maxRowCount);
            }
            System.out.println(list);
            jsonArray = new JSONArray(list);
            jsonArray.put(prop);
            return jsonArray.toString();
    }

    //accountState为0时 冻结 (查询被冻结用户)
    @Override
    public String checkFrozenAccounts(String accountId,Integer pageNumber) throws Exception {
    	List<Account1> list=null;
    	totalRowCount = accountMapper.getRowCountByState(accountId,0);
        prop = IPageUtils.calPageProperties(totalRowCount,maxRowCount,pageNumber);
        if(accountId!=null&&!"".equals(accountId)){
            list = accountMapper.queryFrozenById(accountId,0,prop.get("startIndex"),maxRowCount);

        }else {
            list = accountMapper.queryFrozenByPage(prop.get("startIndex"),maxRowCount);
        }
        jsonArray = new JSONArray(list);
        jsonArray.put(prop);
        return jsonArray.toString();
    }

    //查看未冻结账户
    @Override
    public String checkOpenedAccounts(String accountId,Integer pageNumber) throws Exception {
    	List<Account1> list=null;
    	totalRowCount = accountMapper.getRowCountByState(accountId,1);
        prop = IPageUtils.calPageProperties(totalRowCount,maxRowCount,pageNumber);
        if(accountId!=null&&!"".equals(accountId)){
            list = accountMapper.queryFrozenById(accountId,1,prop.get("startIndex"),maxRowCount);

        }else {
            list = accountMapper.queryOpendByPage(prop.get("startIndex"),maxRowCount);
        }
        jsonArray = new JSONArray(list);
        jsonArray.put(prop);
        return jsonArray.toString();
    }


//    //开户
//    @Override
//    public String openAnAccount(Account account) throws Exception {
//        if (account!=null){
//          //  accountMapper.add(account);
//            System.out.println("开户成功"+account);
//            return checkAllAccounts(null,1);
//        }
//        return "未输入用户";
//    }

    //修改管理员密码
    @Override
    public String changePassword(String currentPassword, String newPassword) {


        return currentPassword;
    }


    //冻结用户
    @Override
    public String frozenAccount(String accountId) throws Exception {
        if(accountId!=null&&!"".equals(accountId)){
//            Account account =accountMapper.queryById(accountId);
//            account.setAccountState(0);
            accountMapper.updateState(accountId,0);
            //返回查看未冻结
            return checkOpenedAccounts(null,1);

        }else {
            return "要冻结的用户名为空";
        }

    }

    //恢复用户
    @Override
    public String resumeAccount(String accountId) throws Exception {
        if(accountId!=null&&!"".equals(accountId)){
            System.out.println("恢复的accountID："+accountId);
//          Account account =accountMapper.queryById(accountId);
//           account.setAccountState(1);
            accountMapper.updateState(accountId,1);
            //返回查看冻结
            return checkFrozenAccounts(null,1);
        }
        else {
            return "要恢复的用户名为空";
        }

    }


    /****************************新闻操作***************************************/

    @Resource
    private NewsMapper newsMapper;

    @Override
    public String queryAllNews(Integer pageNumber) throws Exception {
        totalRowCount = newsMapper.countAll();
        prop = IPageUtils.calPageProperties(totalRowCount,maxRowCount,pageNumber);
        List<News> list = newsMapper.queryAllNews(prop.get("startIndex"),maxRowCount);
        for (News news : list) {
            System.out.println(news);
        }
        JSONArray jsonArray = new JSONArray(list);
        jsonArray.put(prop);
        return jsonArray.toString();
    }

    @Override
    public String queryByTitle(String title,Integer pageNumber) throws Exception {
        totalRowCount=newsMapper.countAllByTitle(title);
        List<News> list = newsMapper.queryByTitle(title,prop.get("startIndex"),maxRowCount);
        for (News news : list) {
            System.out.println(news);
        }
        JSONArray jsonArray = new JSONArray(list);
        jsonArray.put(prop);
        return jsonArray.toString();
    }

    //请求体 requestBody
    @Override
    public String insertNews(@RequestBody Map<String,String> map) throws Exception {
        News news = new News();
        news.setNewsTitle(map.get("newsTitle"));
        news.setNewsSum(map.get("newsSum"));
        news.setNewsContent(map.get("newsContent"));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
         java.util.Date date = sdf.parse(map.get("newsTime"));
            Date transDate = new Date(date.getTime());
            news.setNewsTime(transDate);
        //没有添加操作人的ID
        newsMapper.addNews(news);
        return queryAllNews(1);
    }

    @Override
    public String deleteNews(Integer id) throws Exception {

        newsMapper.deleteNews(id);
       return queryAllNews(1);
    }

	@Override
	public String deleteAccount(String accountId) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
=======
package cdu_pfms.services.impl;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.json.JSONArray;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import cdu_pfms.database.data.Account1;
import cdu_pfms.database.data.News;
import cdu_pfms.database.idao.AccountMapper;
import cdu_pfms.database.idao.NewsMapper;
import cdu_pfms.services.AdminService;
import cdu_pfms.services.NewsService;
import cdu_pfms.utils.IPageUtils;

/**
 * @description:  修改账户的函数
 * @author: meng.pc
 * @date: 2018-11-12 10:56
 */
@Service
public class AdminServiceImpl implements AdminService,NewsService {
    @Resource
    private AccountMapper accountMapper;
    public static int maxRowCount = 5;
    //总行数
    public static int totalRowCount = 0;
    public static List<Account1> list=null;
    public static Map<String,Integer> prop = null;
    public static JSONArray jsonArray =null;
    //查看所有账户信息(按用户名字查看账户信息)
    @Override
    public String checkAllAccounts(String accountId,Integer pageNumber) throws Exception {
    	List<Account1> list=new ArrayList<>();
    	System.out.println(accountId);
        totalRowCount = accountMapper.getRowCount(accountId);
        prop = IPageUtils.calPageProperties(totalRowCount,maxRowCount,pageNumber);
            if(accountId!=null&&!"".equals(accountId)){
                Account1 account = accountMapper.queryByIdPage(accountId,prop.get("startIndex"),maxRowCount);
                list.add(account);
            }else {
                list = accountMapper.queryByPage(prop.get("startIndex"),maxRowCount);
            }
            System.out.println(list);
            jsonArray = new JSONArray(list);
            jsonArray.put(prop);
            return jsonArray.toString();
    }

    //accountState为0时 冻结 (查询被冻结用户)
    @Override
    public String checkFrozenAccounts(String accountId,Integer pageNumber) throws Exception {
    	List<Account1> list=null;
    	totalRowCount = accountMapper.getRowCountByState(accountId,0);
        prop = IPageUtils.calPageProperties(totalRowCount,maxRowCount,pageNumber);
        if(accountId!=null&&!"".equals(accountId)){
            list = accountMapper.queryFrozenById(accountId,0,prop.get("startIndex"),maxRowCount);

        }else {
            list = accountMapper.queryFrozenByPage(prop.get("startIndex"),maxRowCount);
        }
        jsonArray = new JSONArray(list);
        jsonArray.put(prop);
        return jsonArray.toString();
    }

    //查看未冻结账户
    @Override
    public String checkOpenedAccounts(String accountId,Integer pageNumber) throws Exception {
    	List<Account1> list=null;
    	totalRowCount = accountMapper.getRowCountByState(accountId,1);
        prop = IPageUtils.calPageProperties(totalRowCount,maxRowCount,pageNumber);
        if(accountId!=null&&!"".equals(accountId)){
            list = accountMapper.queryFrozenById(accountId,1,prop.get("startIndex"),maxRowCount);

        }else {
            list = accountMapper.queryOpendByPage(prop.get("startIndex"),maxRowCount);
        }
        jsonArray = new JSONArray(list);
        jsonArray.put(prop);
        return jsonArray.toString();
    }


//    //开户
//    @Override
//    public String openAnAccount(Account account) throws Exception {
//        if (account!=null){
//          //  accountMapper.add(account);
//            System.out.println("开户成功"+account);
//            return checkAllAccounts(null,1);
//        }
//        return "未输入用户";
//    }

    //修改管理员密码
    @Override
    public String changePassword(String currentPassword, String newPassword) {


        return currentPassword;
    }


    //冻结用户
    @Override
    public String frozenAccount(String accountId) throws Exception {
        if(accountId!=null&&!"".equals(accountId)){
//            Account account =accountMapper.queryById(accountId);
//            account.setAccountState(0);
            accountMapper.updateState(accountId,0);
            //返回查看未冻结
            return checkOpenedAccounts(null,1);

        }else {
            return "要冻结的用户名为空";
        }

    }

    //恢复用户
    @Override
    public String resumeAccount(String accountId) throws Exception {
        if(accountId!=null&&!"".equals(accountId)){
            System.out.println("恢复的accountID："+accountId);
//          Account account =accountMapper.queryById(accountId);
//           account.setAccountState(1);
            accountMapper.updateState(accountId,1);
            //返回查看冻结
            return checkFrozenAccounts(null,1);
        }
        else {
            return "要恢复的用户名为空";
        }

    }


    /****************************新闻操作***************************************/

    @Resource
    private NewsMapper newsMapper;

    @Override
    public String queryAllNews(Integer pageNumber) throws Exception {
        totalRowCount = newsMapper.countAll();
        prop = IPageUtils.calPageProperties(totalRowCount,maxRowCount,pageNumber);
        List<News> list = newsMapper.queryAllNews(prop.get("startIndex"),maxRowCount);
        for (News news : list) {
            System.out.println(news);
        }
        JSONArray jsonArray = new JSONArray(list);
        jsonArray.put(prop);
        return jsonArray.toString();
    }

    @Override
    public String queryByTitle(String title,Integer pageNumber) throws Exception {
        totalRowCount=newsMapper.countAllByTitle(title);
        List<News> list = newsMapper.queryByTitle(title,prop.get("startIndex"),maxRowCount);
        for (News news : list) {
            System.out.println(news);
        }
        JSONArray jsonArray = new JSONArray(list);
        jsonArray.put(prop);
        return jsonArray.toString();
    }

    //请求体 requestBody
    @Override
    public String insertNews(@RequestBody Map<String,String> map) throws Exception {
        News news = new News();
        news.setNewsTitle(map.get("newsTitle"));
        news.setNewsSum(map.get("newsSum"));
        news.setNewsContent(map.get("newsContent"));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
         java.util.Date date = sdf.parse(map.get("newsTime"));
            Date transDate = new Date(date.getTime());
            news.setNewsTime(transDate);
        //没有添加操作人的ID
        newsMapper.addNews(news);
        return queryAllNews(1);
    }

    @Override
    public String deleteNews(Integer id) throws Exception {

        newsMapper.deleteNews(id);
       return queryAllNews(1);
    }

	@Override
	public String deleteAccount(String accountId) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
>>>>>>> second commit
