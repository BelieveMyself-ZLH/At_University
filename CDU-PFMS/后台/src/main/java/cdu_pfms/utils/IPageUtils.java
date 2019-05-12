<<<<<<< HEAD
package cdu_pfms.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @author: meng.pc
 * @date: 2018-10-16 16:31
 */
public class IPageUtils {
    public static Map<String,Integer> calPageProperties(Integer totalRowCount,Integer maxRowCount,Integer pageNumber){
        //计算总页数
        int totalPageCount = (totalRowCount+maxRowCount-1)/maxRowCount;
        if(totalPageCount<1) {
            totalPageCount = 1;
        }
        //限定页码范围
        if(pageNumber==null||pageNumber<1) {
            pageNumber = 1;
        }
        if(pageNumber>totalPageCount) {
            pageNumber = totalPageCount;
        }
        //计算起始行数
        int startIndex = (pageNumber-1)*maxRowCount;
        //创建图集合，用于封装数据
        Map<String, Integer> prop = new HashMap<>();
        prop.put("totalRowCount", totalRowCount);
        prop.put("totalPageCount", totalPageCount);
        prop.put("maxRowCount", maxRowCount);
        prop.put("pageNumber", pageNumber);
        prop.put("startIndex", startIndex);
        return prop;
    }
}
=======
package cdu_pfms.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @author: meng.pc
 * @date: 2018-10-16 16:31
 */
public class IPageUtils {
    public static Map<String,Integer> calPageProperties(Integer totalRowCount,Integer maxRowCount,Integer pageNumber){
        //计算总页数
        int totalPageCount = (totalRowCount+maxRowCount-1)/maxRowCount;
        if(totalPageCount<1) {
            totalPageCount = 1;
        }
        //限定页码范围
        if(pageNumber==null||pageNumber<1) {
            pageNumber = 1;
        }
        if(pageNumber>totalPageCount) {
            pageNumber = totalPageCount;
        }
        //计算起始行数
        int startIndex = (pageNumber-1)*maxRowCount;
        //创建图集合，用于封装数据
        Map<String, Integer> prop = new HashMap<>();
        prop.put("totalRowCount", totalRowCount);
        prop.put("totalPageCount", totalPageCount);
        prop.put("maxRowCount", maxRowCount);
        prop.put("pageNumber", pageNumber);
        prop.put("startIndex", startIndex);
        return prop;
    }
}
>>>>>>> second commit
