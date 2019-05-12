<<<<<<< HEAD
package com.demo.services;

import javax.servlet.http.HttpServletResponse;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 * 文件管理业务处理接口
 * @author Teacher
 * @createTime 2018年10月17日 下午2:30:25
 * @lastTime 2018年10月17日 下午2:30:25
 * @version 1.0.0
 */
public interface IFileService {

	/**
	 * 查询所有文件数据
	 * @param Model
	 * @return
	 * @throws Exception
	 */
	public String query(Model model) throws Exception; 
	
	/**
	 * 文件上传
	 * @param file
	 * @param model
	 * @return
	 * @throws Exception
	 */
	public String upload(MultipartFile file, Model model) throws Exception;
	
	/**
	 * 单文件下载
	 * @param fileName
	 * @param response
	 */
	public void download(String fileName, HttpServletResponse response) throws Exception;
	
}
=======
package com.demo.services;

import javax.servlet.http.HttpServletResponse;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 * 文件管理业务处理接口
 * @author Teacher
 * @createTime 2018年10月17日 下午2:30:25
 * @lastTime 2018年10月17日 下午2:30:25
 * @version 1.0.0
 */
public interface IFileService {

	/**
	 * 查询所有文件数据
	 * @param Model
	 * @return
	 * @throws Exception
	 */
	public String query(Model model) throws Exception; 
	
	/**
	 * 文件上传
	 * @param file
	 * @param model
	 * @return
	 * @throws Exception
	 */
	public String upload(MultipartFile file, Model model) throws Exception;
	
	/**
	 * 单文件下载
	 * @param fileName
	 * @param response
	 */
	public void download(String fileName, HttpServletResponse response) throws Exception;
	
}
>>>>>>> second commit
