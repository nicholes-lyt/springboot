package com.springboot.demo.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * 
 * @ClassName: WebSecurityConfig
 * @Description: 加载配置
 * @author yuting.li
 * @version 1.0
 * @date 2017年4月30日 下午5:53:06
 */
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true) // 开启security注解
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Bean
	@Override
	protected AuthenticationManager authenticationManager() throws Exception {
		return super.authenticationManager();
	}

	protected void configure(HttpSecurity http) throws Exception {
		// 允许所有用户访问"/"和"/demo"
		http.authorizeRequests().antMatchers("/", "/demo" , "/static").permitAll()
				// 其他地址的访问均需验证权限
				.anyRequest().authenticated().and().formLogin()
				// 指定登录页是"/login"
				.loginPage("/login").defaultSuccessUrl("/user")// 登录成功后默认跳转到"/index"
				.permitAll().and().logout().logoutSuccessUrl("/index")// 退出登录后的默认url是"/index"
				.permitAll();

	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(sysUserDetails()).passwordEncoder(passwordEncoder());
	}

	/**
	 * 设置用户密码的加密方式为MD5加密
	 * 
	 * @return
	 */
	@Bean
	public Md5PasswordEncoder passwordEncoder() {
		return new Md5PasswordEncoder();
	}
	
	/**
     * 自定义UserDetailsService，从数据库中读取用户信息
     * @return
     */
    @Bean
    public SysUserDetails sysUserDetails(){
        return new SysUserDetails();
    }
	
}
