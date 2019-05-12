<<<<<<< HEAD
package cdu_pfms.database.idao;

import cdu_pfms.database.data.News;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @description:
 * @author: meng.pc
 * @date: 2018-11-12 10:32
 */
public interface NewsMapper {
    /*
    查询所有新闻
     */
    @Results(id = "newsResults",value = {
            @Result(column = "news_id",property ="newsId" ),
            @Result(column = "news_title",property = "newsTitle"),
            @Result(column = "news_sum",property = "newsSum"),
            @Result(column = "news_content",property = "newsContent"),
            @Result(column = "news_time",property = "newsTime")
//           @Result(column = "admin_id",property = "adminOperation",
//           one = @One(select = "com.pfms.database.idao.AdminMapper.queryById"))
    })
    @Select("select * from tab_news_info limit #{startIndex},#{maxRowCount}")
    List<News>  queryAllNews(@Param("startIndex") Integer startIndex,
                             @Param("maxRowCount") Integer maxRowCount);

    /**
     * 按标题模糊查询
     * @param title
     * @return
     */
    @ResultMap("newsResults")
    @Select("select * from tab_news_info where news_title like '%${title}%' limit #{startIndex},#{maxRowCount} ")
    List<News> queryByTitle(@Param("title") String title,@Param("startIndex") Integer startIndex,
                            @Param("maxRowCount") Integer maxRowCount);

    /**
     * 输入标题，摘要，内容插入新闻，其他不为空的属性 服务中处理
     */
    @Insert("insert into tab_news_info(news_title,news_sum,news_content,news_time)" +
            " values(#{newsTitle},#{newsSum},#{newsContent},#{newsTime})")
    void addNews(News news);

    /**
     * 按照新闻ID来删除新闻
     * @param newsId
     */
    @Delete("delete from tab_news_info where news_id=#{newsId}")
    void deleteNews(Integer newsId);

    @Select("select count(*) from tab_news_info")
    int countAll();

    @Select("select count(*) from tab_news_info where news_title like '%${title}%' ")
    int countAllByTitle(@Param("title") String newsTitle);


}
=======
package cdu_pfms.database.idao;

import cdu_pfms.database.data.News;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @description:
 * @author: meng.pc
 * @date: 2018-11-12 10:32
 */
public interface NewsMapper {
    /*
    查询所有新闻
     */
    @Results(id = "newsResults",value = {
            @Result(column = "news_id",property ="newsId" ),
            @Result(column = "news_title",property = "newsTitle"),
            @Result(column = "news_sum",property = "newsSum"),
            @Result(column = "news_content",property = "newsContent"),
            @Result(column = "news_time",property = "newsTime")
//           @Result(column = "admin_id",property = "adminOperation",
//           one = @One(select = "com.pfms.database.idao.AdminMapper.queryById"))
    })
    @Select("select * from tab_news_info limit #{startIndex},#{maxRowCount}")
    List<News>  queryAllNews(@Param("startIndex") Integer startIndex,
                             @Param("maxRowCount") Integer maxRowCount);

    /**
     * 按标题模糊查询
     * @param title
     * @return
     */
    @ResultMap("newsResults")
    @Select("select * from tab_news_info where news_title like '%${title}%' limit #{startIndex},#{maxRowCount} ")
    List<News> queryByTitle(@Param("title") String title,@Param("startIndex") Integer startIndex,
                            @Param("maxRowCount") Integer maxRowCount);

    /**
     * 输入标题，摘要，内容插入新闻，其他不为空的属性 服务中处理
     */
    @Insert("insert into tab_news_info(news_title,news_sum,news_content,news_time)" +
            " values(#{newsTitle},#{newsSum},#{newsContent},#{newsTime})")
    void addNews(News news);

    /**
     * 按照新闻ID来删除新闻
     * @param newsId
     */
    @Delete("delete from tab_news_info where news_id=#{newsId}")
    void deleteNews(Integer newsId);

    @Select("select count(*) from tab_news_info")
    int countAll();

    @Select("select count(*) from tab_news_info where news_title like '%${title}%' ")
    int countAllByTitle(@Param("title") String newsTitle);


}
>>>>>>> second commit
