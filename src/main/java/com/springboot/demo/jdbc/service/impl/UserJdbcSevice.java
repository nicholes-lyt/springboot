package com.springboot.demo.jdbc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.springboot.demo.jpa.entity.Role;
import com.springboot.demo.jpa.entity.User;
import com.springboot.demo.mybatis.mapper.UserMapper;

@Service
public class UserJdbcSevice {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public List<UserMapper> findUser(){
		List<UserMapper> list = jdbcTemplate.query(" SELECT * FROM t_user ", new BeanPropertyRowMapper<UserMapper>(UserMapper.class));
		return list;
	}
	
	public List<User> findAllUser(){
		List<User> list = jdbcTemplate.query(" SELECT * FROM t_user ", new BeanPropertyRowMapper<User>(User.class));
		return list;
	}
	
	public User findByUsername(String username){
		String sql = " select * from t_user where username =? ";
		return jdbcTemplate.queryForObject(sql, new Object[]{username} , new BeanPropertyRowMapper<User>(User.class));
	}
	
	public List<Role> findBtRoles(Integer id){
		String sql = " select * from t_role where uid =? ";
		return jdbcTemplate.query(sql,new Object[]{id},new BeanPropertyRowMapper<Role>(Role.class));
	}
	
}
