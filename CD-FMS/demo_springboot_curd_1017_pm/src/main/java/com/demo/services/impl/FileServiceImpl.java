<<<<<<< HEAD
package com.demo.services.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;

import com.demo.services.IFileService;

/**
 * 文件管理业务处理具体实现类
 * @author Teacher
 * @createTime 2018年10月17日 下午2:35:07
 * @lastTime 2018年10月17日 下午2:35:07
 * @version 1.0.0
 */
@Service
public class FileServiceImpl implements IFileService {

	private String rootDir = "D:/myfile";
	
	@Override
	public String query(Model model) throws Exception {
		//创建目录文件对象
		File dir = new File(rootDir);
		//判断文件夹是否未创建
		if(!dir.exists()) {
			//新建文件夹
			dir.mkdirs();
		}
		//获得目录下所有文件
		File[] files = dir.listFiles();
		//创建封装数据的集合
		List<Map<String, Object>> list = new ArrayList<>();
		//遍历数组
		for(File file: files) {
			//创建封装文件信息图集合
			Map<String, Object> temp = new HashMap<>();
			//封装文件数据
			temp.put("fileName", file.getName());
			temp.put("fileType", file.getName().substring(file.getName().lastIndexOf(".")));
			temp.put("fileLength", file.length());
			list.add(temp);
		}
		//添加给模型对象
		model.addAttribute("list", list);
		return "system/file/filelist.html";
	}

	@Override
	public String upload(MultipartFile file, Model model) throws Exception {
		//打印输出文件相关信息
		System.out.println(file.getOriginalFilename());
		System.out.println(file.getContentType());
		System.out.println(file.getSize());
		//写入文件到指定目录下
		file.transferTo(new File(rootDir+"/"+file.getOriginalFilename()));
		//保存文件信息数据到数据库表中
		
		//查询文件数据, 更新文件列表
		return query(model);
	}

	@Override
	public void download(String fileName, HttpServletResponse response) throws Exception {
		//创建下载的文件对象
		File file = new File(rootDir+"/"+fileName);
		//创建读取文件数据的输入流
		InputStream in = new FileInputStream(file);
		//设置响应头部内容
		response.setContentType("application/octet-stream");
		response.addHeader("Content-Disposition", "attachment;filename="+fileName);
        response.addHeader("Content-Length", "" + file.length());
        //获得输出流
        OutputStream out = response.getOutputStream();
        //定义缓存数组
        byte[] buff = new byte[1024*1024];
        //声明记录读取字节数变量
        int len;
        //循环输出数据
        while((len=in.read(buff))!=-1) {
        	out.write(buff, 0, len);
        }
        //关闭流
        out.flush();
        out.close();
        in.close();
	}

}
=======
package com.demo.services.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;

import com.demo.services.IFileService;

/**
 * 文件管理业务处理具体实现类
 * @author Teacher
 * @createTime 2018年10月17日 下午2:35:07
 * @lastTime 2018年10月17日 下午2:35:07
 * @version 1.0.0
 */
@Service
public class FileServiceImpl implements IFileService {

	private String rootDir = "D:/myfile";
	
	@Override
	public String query(Model model) throws Exception {
		//创建目录文件对象
		File dir = new File(rootDir);
		//判断文件夹是否未创建
		if(!dir.exists()) {
			//新建文件夹
			dir.mkdirs();
		}
		//获得目录下所有文件
		File[] files = dir.listFiles();
		//创建封装数据的集合
		List<Map<String, Object>> list = new ArrayList<>();
		//遍历数组
		for(File file: files) {
			//创建封装文件信息图集合
			Map<String, Object> temp = new HashMap<>();
			//封装文件数据
			temp.put("fileName", file.getName());
			temp.put("fileType", file.getName().substring(file.getName().lastIndexOf(".")));
			temp.put("fileLength", file.length());
			list.add(temp);
		}
		//添加给模型对象
		model.addAttribute("list", list);
		return "system/file/filelist.html";
	}

	@Override
	public String upload(MultipartFile file, Model model) throws Exception {
		//打印输出文件相关信息
		System.out.println(file.getOriginalFilename());
		System.out.println(file.getContentType());
		System.out.println(file.getSize());
		//写入文件到指定目录下
		file.transferTo(new File(rootDir+"/"+file.getOriginalFilename()));
		//保存文件信息数据到数据库表中
		
		//查询文件数据, 更新文件列表
		return query(model);
	}

	@Override
	public void download(String fileName, HttpServletResponse response) throws Exception {
		//创建下载的文件对象
		File file = new File(rootDir+"/"+fileName);
		//创建读取文件数据的输入流
		InputStream in = new FileInputStream(file);
		//设置响应头部内容
		response.setContentType("application/octet-stream");
		response.addHeader("Content-Disposition", "attachment;filename="+fileName);
        response.addHeader("Content-Length", "" + file.length());
        //获得输出流
        OutputStream out = response.getOutputStream();
        //定义缓存数组
        byte[] buff = new byte[1024*1024];
        //声明记录读取字节数变量
        int len;
        //循环输出数据
        while((len=in.read(buff))!=-1) {
        	out.write(buff, 0, len);
        }
        //关闭流
        out.flush();
        out.close();
        in.close();
	}

}
>>>>>>> second commit
