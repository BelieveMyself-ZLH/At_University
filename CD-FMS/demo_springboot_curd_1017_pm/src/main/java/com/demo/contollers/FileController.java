<<<<<<< HEAD
package com.demo.contollers;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.demo.services.IFileService;

/**
 * 文件管理的控制器
 * @author Teacher
 * @createTime 2018年10月17日 下午2:28:40
 * @lastTime 2018年10月17日 下午2:28:40
 * @version 1.0.0
 */
@Controller
public class FileController {

	@Resource
	private IFileService ifileService;
	
	/**
	 * 查询文件数据
	 * @param model
	 * @return
	 */
	@RequestMapping("/filelist")
	public String query(Model model) {
		try {
			String result = ifileService.query(model);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return "error.html";
		}
	}
	
	/**
	 * 文件上传
	 * @param file
	 * @param model
	 * @return
	 */
	@RequestMapping("/fileupload")
	public String upload(MultipartFile file, Model model) {
		try {
			String result = ifileService.upload(file, model);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return "error.html";
		}
	}
	
	/**
	 * 文件下载
	 * @param fileName
	 * @param response
	 */
	@RequestMapping("/filedownload")
	public void download(String id, HttpServletResponse response) {
		//System.out.println("--------->"+id);
		try {
			ifileService.download(id, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}









=======
package com.demo.contollers;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.demo.services.IFileService;

/**
 * 文件管理的控制器
 * @author Teacher
 * @createTime 2018年10月17日 下午2:28:40
 * @lastTime 2018年10月17日 下午2:28:40
 * @version 1.0.0
 */
@Controller
public class FileController {

	@Resource
	private IFileService ifileService;
	
	/**
	 * 查询文件数据
	 * @param model
	 * @return
	 */
	@RequestMapping("/filelist")
	public String query(Model model) {
		try {
			String result = ifileService.query(model);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return "error.html";
		}
	}
	
	/**
	 * 文件上传
	 * @param file
	 * @param model
	 * @return
	 */
	@RequestMapping("/fileupload")
	public String upload(MultipartFile file, Model model) {
		try {
			String result = ifileService.upload(file, model);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return "error.html";
		}
	}
	
	/**
	 * 文件下载
	 * @param fileName
	 * @param response
	 */
	@RequestMapping("/filedownload")
	public void download(String id, HttpServletResponse response) {
		//System.out.println("--------->"+id);
		try {
			ifileService.download(id, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}









>>>>>>> second commit
