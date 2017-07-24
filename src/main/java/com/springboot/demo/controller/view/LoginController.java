package com.springboot.demo.controller.view;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 * 
 * @ClassName: LoginController   
 * @Description: 登录
 * @author yuting.li
 * @version 1.0 
 * @date 2017年4月30日 下午7:37:43
 */
@Controller
public class LoginController {
	
	//private Logger logger = LoggerFactory.getLogger(LoginController.class);
	@RequestMapping("/login")
    public String login(){
        return "login/login";
    }
	
}
