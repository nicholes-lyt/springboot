package com.springboot.demo.entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.springboot.demo.jpa.entity.Role;
import com.springboot.demo.jpa.entity.User;

/**
 * 
 * @ClassName: SecurityUser   
 * @Description: 用户
 * @author yuting.li
 * @version 1.0 
 * @date 2017年4月30日 下午6:52:54
 */
public class SecurityUser extends User implements UserDetails{

	/**
	 * @Description: TODO(描述funcion功能)
	 * author yuting.li
	 * @date 2017年4月30日 下午6:37:16 
	 * @version 1.0   
	 */
	private static final long serialVersionUID = 4251021612802097557L;
	
	public SecurityUser (User user){
		if(user != null){
			this.setId(user.getId());
			this.setUsername(user.getUsername());
			this.setRealname(user.getRealname());
			this.setPassword(user.getPassword());
			this.setEmail(user.getEmail());
			this.setRoles(user.getRoles());
		}
	}

	@Override
	public Collection<GrantedAuthority> getAuthorities() {
		Collection<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		Set<Role> userRoles = this.getRoles();
		if(userRoles != null && userRoles.size() > 0){
			// lamda表达式
			userRoles.forEach((Role role) -> {
				SimpleGrantedAuthority authority = new SimpleGrantedAuthority(role.getName());
				authorities.add(authority);
			});
		}
		return authorities;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
