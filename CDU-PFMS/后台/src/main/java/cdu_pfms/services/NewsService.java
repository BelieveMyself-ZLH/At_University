<<<<<<< HEAD
package cdu_pfms.services;

import cdu_pfms.database.data.News;

import java.util.List;
import java.util.Map;

/**
 * @description:  关于新闻的操作
 * @author: meng.pc
 * @date: 2018-11-12 14:49
 */
public interface NewsService {

    String queryAllNews(Integer pageNumber) throws Exception;

    //按标题模糊查询
    String queryByTitle(String title,Integer pageNumber) throws Exception;

    //插入一条新闻
    String insertNews(Map<String,String> map) throws Exception;

    String deleteNews(Integer id) throws Exception;

}
=======
package cdu_pfms.services;

import cdu_pfms.database.data.News;

import java.util.List;
import java.util.Map;

/**
 * @description:  关于新闻的操作
 * @author: meng.pc
 * @date: 2018-11-12 14:49
 */
public interface NewsService {

    String queryAllNews(Integer pageNumber) throws Exception;

    //按标题模糊查询
    String queryByTitle(String title,Integer pageNumber) throws Exception;

    //插入一条新闻
    String insertNews(Map<String,String> map) throws Exception;

    String deleteNews(Integer id) throws Exception;

}
>>>>>>> second commit
