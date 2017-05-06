/**
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.springboot.demo;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * 
 * @ClassName: Application
 * @Description: 启动
 * @author yuting.li
 * @version 1.0
 * @date 2017年3月28日 下午1:05:22
 */
@SpringBootApplication
@ImportResource("classpath:/applicationContext.xml")
@MapperScan("com.springboot.demo")
public class Application extends WebMvcConfigurerAdapter{

	private static final Logger logger = LoggerFactory.getLogger(Application.class);

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	@Override
	public void addResourceHandlers(final ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/static/**").addResourceLocations("/static/", "classpath:/static/");
	}

	@Primary
	@Bean(name = "dataSource")
	@Qualifier("dataSource")
	@ConfigurationProperties(prefix = "spring.datasource")
	public DataSource dataSource() {
		return DataSourceBuilder.create().build();
	}


	
	@Bean(name = "jdbcTemplate")
	public JdbcTemplate jdbcTemplate() {
		return new JdbcTemplate(dataSource());
	}
	

	// 提供sqlsession
	@Bean(name = "sqlSessionFactory")
	public SqlSessionFactory sqlSessionFactory() throws Exception {
		try {
			logger.info("springboot 加载数据源：" + dataSource());
			SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
			sqlSessionFactoryBean.setDataSource(dataSource());
			PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
			sqlSessionFactoryBean
					.setMapperLocations(resolver.getResources("classpath:/mybatis/mapping/*.xml"));
			return sqlSessionFactoryBean.getObject();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Bean
	public PlatformTransactionManager transactionManager() throws Exception {
		return new DataSourceTransactionManager(dataSource());
	}
}
