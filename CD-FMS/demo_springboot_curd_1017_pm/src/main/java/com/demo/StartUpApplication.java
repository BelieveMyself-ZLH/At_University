<<<<<<< HEAD
package com.demo;

import javax.servlet.MultipartConfigElement;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;

/**
 * 启动应用程序
 * @author Teacher
 * @createTime 2018年10月11日 上午10:36:00
 * @lastTime 2018年10月11日 上午10:36:00
 * @version 1.0.0
 */
@MapperScan("com.demo.database.idao")
@SpringBootApplication
public class StartUpApplication {

	public static void main(String[] args) {
		SpringApplication.run(StartUpApplication.class, args);
	}

	/**
	 * 上传文件大小限制
	 * @return
	 */
	@Bean 
	public MultipartConfigElement multipartConfigElement(){ 
		MultipartConfigFactory config = new MultipartConfigFactory(); 
		config.setMaxFileSize("1024MB"); 
		config.setMaxRequestSize("2048MB"); 
		return config.createMultipartConfig(); 
	} 

}
=======
package com.demo;

import javax.servlet.MultipartConfigElement;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;

/**
 * 启动应用程序
 * @author Teacher
 * @createTime 2018年10月11日 上午10:36:00
 * @lastTime 2018年10月11日 上午10:36:00
 * @version 1.0.0
 */
@MapperScan("com.demo.database.idao")
@SpringBootApplication
public class StartUpApplication {

	public static void main(String[] args) {
		SpringApplication.run(StartUpApplication.class, args);
	}

	/**
	 * 上传文件大小限制
	 * @return
	 */
	@Bean 
	public MultipartConfigElement multipartConfigElement(){ 
		MultipartConfigFactory config = new MultipartConfigFactory(); 
		config.setMaxFileSize("1024MB"); 
		config.setMaxRequestSize("2048MB"); 
		return config.createMultipartConfig(); 
	} 

}
>>>>>>> second commit
