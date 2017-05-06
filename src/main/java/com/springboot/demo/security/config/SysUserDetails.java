package com.springboot.demo.security.config;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.springboot.demo.entity.SecurityUser;
import com.springboot.demo.jdbc.service.impl.UserJdbcSevice;
import com.springboot.demo.jpa.dao.UserRepository;
import com.springboot.demo.jpa.entity.User;

public class SysUserDetails implements UserDetailsService{
	
	@Autowired
	private UserJdbcSevice userJdbcSevice;
	
	@Autowired
	private UserRepository userDao;

	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		User user = userDao.findUserByUsername(username);
		if(user == null){
			throw new UsernameNotFoundException("username " + username + " not found");
		}
		SecurityUser securityUser = new SecurityUser(user);
		Collection<SimpleGrantedAuthority> authorities = new ArrayList<SimpleGrantedAuthority>();
		authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
        return securityUser; //code9
	}

}
