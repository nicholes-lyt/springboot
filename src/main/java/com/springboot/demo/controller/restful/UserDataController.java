package com.springboot.demo.controller.restful;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.demo.jdbc.service.impl.UserJdbcSevice;
import com.springboot.demo.jpa.entity.User;


/**
 * 
 * @ClassName: UserDataController   
 * @Description: 用户数据，post请求
 * @author yuting.li
 * @version 1.0 
 * @date 2017年5月1日 下午8:11:02
 */
@RestController
public class UserDataController {
	
	@Autowired
	private UserJdbcSevice userJdbcSevice;
	
	
	@RequestMapping(value = "/findUser", method = RequestMethod.POST)
	@ResponseBody
	public Object findUser(){
		Map<String, Object> map = new HashMap<>();
		List<User> user = userJdbcSevice.findAllUser();
		map.put("total", user.size());
		map.put("rows", user);
		return map;
	}

}
