<<<<<<< HEAD
package com.demo.services.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.demo.database.data.TDemoDept;
import com.demo.database.data.TDemoUser;
import com.demo.database.idao.TDemoUserMapper;
import com.demo.database.idao.TDemodeptMapper;
import com.demo.services.IUserService;

/**
 * 用户管理业务处理具体实现类
 * @author Teacher
 * @createTime 2018年10月17日 上午9:52:48
 * @lastTime 2018年10月17日 上午9:52:48
 * @version 1.0.0
 */
@Service
public class UserServiceImpl implements IUserService {

	//注入数据库访问接口对象（代理对象）
	@Resource
	private TDemoUserMapper userMapper;
	@Resource
	private TDemodeptMapper deptMapper;
	
	@Override
	public String query(Model model) throws Exception {
		List<TDemoUser> list = userMapper.queryAll();
		model.addAttribute("list", list);
		
		//测试one-to-many
		List<TDemoDept> deptList = deptMapper.queryDeptAndUser();
		for(TDemoDept dept: deptList) {
			System.out.println(dept.getDeptName());
			for(TDemoUser user: dept.getTDemoUsers()) {
				System.out.println("    "+user.getUserName()+"  "
			        +user.getUserGender()+"  "+user.getUserInTime());
			}
		}
		
		return "system/user/userlist.html";
	}

}
=======
package com.demo.services.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.demo.database.data.TDemoDept;
import com.demo.database.data.TDemoUser;
import com.demo.database.idao.TDemoUserMapper;
import com.demo.database.idao.TDemodeptMapper;
import com.demo.services.IUserService;

/**
 * 用户管理业务处理具体实现类
 * @author Teacher
 * @createTime 2018年10月17日 上午9:52:48
 * @lastTime 2018年10月17日 上午9:52:48
 * @version 1.0.0
 */
@Service
public class UserServiceImpl implements IUserService {

	//注入数据库访问接口对象（代理对象）
	@Resource
	private TDemoUserMapper userMapper;
	@Resource
	private TDemodeptMapper deptMapper;
	
	@Override
	public String query(Model model) throws Exception {
		List<TDemoUser> list = userMapper.queryAll();
		model.addAttribute("list", list);
		
		//测试one-to-many
		List<TDemoDept> deptList = deptMapper.queryDeptAndUser();
		for(TDemoDept dept: deptList) {
			System.out.println(dept.getDeptName());
			for(TDemoUser user: dept.getTDemoUsers()) {
				System.out.println("    "+user.getUserName()+"  "
			        +user.getUserGender()+"  "+user.getUserInTime());
			}
		}
		
		return "system/user/userlist.html";
	}

}
>>>>>>> second commit
