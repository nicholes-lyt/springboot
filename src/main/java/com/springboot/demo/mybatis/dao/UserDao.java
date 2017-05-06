package com.springboot.demo.mybatis.dao;

import java.util.List;
import java.util.Map;



public interface UserDao {
	
	List<Map<String,String>> findUser();
	
}
