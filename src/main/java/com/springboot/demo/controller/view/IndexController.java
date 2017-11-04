package com.springboot.demo.controller.view;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class IndexController {
	
	@RequestMapping(value="/",method = RequestMethod.GET)
    public String goindex(){
        return "index";
    }
	
	@RequestMapping(value="/index",method = RequestMethod.GET)
    public String index(){
        return "index";
    }
	
	@PreAuthorize("hasRole('user')")
    @RequestMapping(value = "/admin",method = RequestMethod.GET)
    public String toAdmin(){
        return "user/admin";
    }
	
	@PreAuthorize("hasRole('user')")
	@RequestMapping(value="/user",method = RequestMethod.GET)
    public String user(){
        return "user/user";
    }
	
	@RequestMapping(value="/403",method = RequestMethod.GET)
    public String error(){
        return "403";
    }
	
	
}
