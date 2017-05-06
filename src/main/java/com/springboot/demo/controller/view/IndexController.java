package com.springboot.demo.controller.view;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
	
	@RequestMapping("/")
    public String goindex(){
        return "index";
    }
	
	@RequestMapping("/index")
    public String index(){
        return "index";
    }
	
	@PreAuthorize("hasRole('user')")
    @RequestMapping(value = "/admin")
    public String toAdmin(){
        return "user/admin";
    }
	
	@PreAuthorize("hasRole('user')")
	@RequestMapping("/user")
    public String user(){
        return "user/user";
    }
	
	@RequestMapping("/403")
    public String error(){
        return "403";
    }
	
	
}
