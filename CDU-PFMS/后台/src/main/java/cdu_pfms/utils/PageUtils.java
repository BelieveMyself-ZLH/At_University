<<<<<<< HEAD
package cdu_pfms.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * 分页公共接口
 * @author ZhouLinHu
 * @createTime 2018年11月1日 下午3:08:14
 * @lastTime 2018年11月1日 下午3:08:14
 * @version 1.0.0
 */
public interface PageUtils {
	
	/**
	 * 分页计算，获得相关属性
	 * @param totalRowCount
	 * @param maxRowCount
	 * @param pageNumber
	 * @return
	 */
	public static Map<String, Integer> calcPageProperties(Integer totalRowCount,
			Integer maxRowCount, Integer pageNumber){
		//计算总页数
		int totalPageCount=(totalRowCount+maxRowCount-1)/maxRowCount;
		//至少一页
		if(totalPageCount<1) {
			totalPageCount=1;
		}
		//限定页码范围
		if(pageNumber==null || pageNumber<1) {
			pageNumber=1;
		}
		if(pageNumber>totalPageCount) {
			pageNumber=totalPageCount;
		}
		//计算起始行数
		int startIndex=(pageNumber-1)*maxRowCount;
		//创建图集合，用于封装数据
		Map<String, Integer> prop=new HashMap();
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
 * 分页公共接口
 * @author ZhouLinHu
 * @createTime 2018年11月1日 下午3:08:14
 * @lastTime 2018年11月1日 下午3:08:14
 * @version 1.0.0
 */
public interface PageUtils {
	
	/**
	 * 分页计算，获得相关属性
	 * @param totalRowCount
	 * @param maxRowCount
	 * @param pageNumber
	 * @return
	 */
	public static Map<String, Integer> calcPageProperties(Integer totalRowCount,
			Integer maxRowCount, Integer pageNumber){
		//计算总页数
		int totalPageCount=(totalRowCount+maxRowCount-1)/maxRowCount;
		//至少一页
		if(totalPageCount<1) {
			totalPageCount=1;
		}
		//限定页码范围
		if(pageNumber==null || pageNumber<1) {
			pageNumber=1;
		}
		if(pageNumber>totalPageCount) {
			pageNumber=totalPageCount;
		}
		//计算起始行数
		int startIndex=(pageNumber-1)*maxRowCount;
		//创建图集合，用于封装数据
		Map<String, Integer> prop=new HashMap();
		prop.put("totalRowCount", totalRowCount);
		prop.put("totalPageCount", totalPageCount);
		prop.put("maxRowCount", maxRowCount);
		prop.put("pageNumber", pageNumber);
		prop.put("startIndex", startIndex);
		return prop;
	}
}
>>>>>>> second commit
