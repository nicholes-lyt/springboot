package com.springboot.demo.controller.restful;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Controller
public class DemoSwaggerController {
	
	@ApiOperation(value = "测试swagger",notes = "测试API",httpMethod = "GET")
    @ApiParam(name = "content",value = "参数：content")
	@RequestMapping(value = "/demo/swagger",method = RequestMethod.GET)
    @ResponseBody
    public String demo(String content) {
        Map<String, String> map = new HashMap<>();
        map.put("result", "sucess");
        map.put("data", "{数据}");
        return new Gson().toJson(map);
    }
	
}
