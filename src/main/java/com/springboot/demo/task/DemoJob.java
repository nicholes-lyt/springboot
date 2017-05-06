package com.springboot.demo.task;

import java.util.List;
import java.util.Map;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.quartz.QuartzJobBean;

import com.springboot.demo.jdbc.service.impl.UserJdbcSevice;
import com.springboot.demo.mybatis.mapper.UserMapper;
import com.springboot.demo.mybatis.service.UserService;
import com.springboot.demo.spring.SpringContextHolder;

import net.sf.json.JSONArray;

/**
 * 
 * @ClassName: TestTask   
 * @Description: 定时任务测试
 * @author yuting.li
 * @version 1.0 
 * @date 2017年3月28日 下午2:56:26
 */
public class DemoJob extends QuartzJobBean{
	
	private static final Logger logger = LoggerFactory.getLogger(DemoJob.class);
	
	
	@Override
	protected void executeInternal(JobExecutionContext arg0)
			throws JobExecutionException {
		logger.info("测试任务线程开始执行");
		runTask();
	}
	
	public void runTask(){
		UserService userService =  SpringContextHolder.getBean("userService");
		List<Map<String, String>> list = userService.findUser();
    	JSONArray json = JSONArray.fromObject(list);
		logger.info("获取User"+json.toString());
		
		/*JdbcTemplate jdbcTemplate = SpringContextHolder.getBean("jdbcTemplate");
		String sql = "SELECT su_name,su_content FROM sa_sys_user LIMIT 20";
		RowMapper<UserMapper> user = new BeanPropertyRowMapper<UserMapper>(UserMapper.class);
		List<UserMapper> list2 = jdbcTemplate.query(sql, user);
		JSONArray json2 = JSONArray.fromObject(list2);
		logger.info("jdbc获取User"+json2.toString());*/
		
		UserJdbcSevice userJdbcSevice = SpringContextHolder.getBean("userJdbcSevice");
		List<UserMapper> list3 = userJdbcSevice.findUser();
		JSONArray json3 = JSONArray.fromObject(list3);
		logger.info("jdbc获取User"+json3.toString());
		
	}
}
