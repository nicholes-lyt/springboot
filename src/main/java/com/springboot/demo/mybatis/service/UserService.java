package com.springboot.demo.mybatis.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.demo.mybatis.dao.UserDao;

@Service
public class UserService {
	
	@Autowired
	private UserDao userDao;
	
	public List<Map<String, String>> findUser(){
		return userDao.findUser();
	}
}
