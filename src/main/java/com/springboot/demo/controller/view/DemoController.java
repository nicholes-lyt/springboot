package com.springboot.demo.controller.view;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 
 * @ClassName: DemoController   
 * @Description: 测试
 * @author yuting.li
 * @version 1.0 
 * @date 2017年4月9日 下午7:53:05
 */
@Controller
public class DemoController {
	
	private Logger logger = LoggerFactory.getLogger(DemoController.class);
	
	/**
     * 测试hello
     * @return
     */
    @RequestMapping(value = "/demo",method = RequestMethod.GET)
    public String demo(Model model) {
    	logger.debug("测试跟踪……");
        model.addAttribute("name", "test");
        Date now = new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd ss:HH:mm");
        model.addAttribute("now", df.format(now));
        return "demo";
    }
	
}
