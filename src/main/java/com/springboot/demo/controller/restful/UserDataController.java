package com.springboot.demo.controller.restful;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.springboot.demo.jdbc.service.impl.UserJdbcSevice;

import net.sf.json.JSONArray;

/**
 * 
 * @ClassName: UserDataController   
 * @Description: 用户数据，post请求
 * @author yuting.li
 * @version 1.0 
 * @date 2017年5月1日 下午8:11:02
 */
@Controller()
public class UserDataController {
	
	@Autowired
	private UserJdbcSevice userJdbcSevice;
	
	
	@RequestMapping(value = "/findUser", method = RequestMethod.GET)
	@ResponseBody
	public String findUser(){
		Map<String, Object> map = new HashMap<>();
		map.put("rows", userJdbcSevice.findAllUser());
		return new JSONArray().fromObject(map).toString();
	}

}
