package com.springboot.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * 
 * @ClassName: Swagger2   
 * @Description: swagger2配置文件类 
 * @访问路径： 如 http://localhost:8088/swagger-ui.html 
 * @author yuting.li
 * @version 1.0 
 * @date 2017年8月7日 上午11:12:36
 */
@Configuration
@EnableSwagger2 // 启用Swagger2
public class Swagger2 {

    @Bean
    public Docket createRestApi() {// 创建API基本信息
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.springboot.demo.controller"))// 扫描该包下的所有需要在Swagger中展示的API，@ApiIgnore注解标注的除外
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {// 创建API的基本信息，这些信息会在Swagger UI中进行显示
        return new ApiInfoBuilder()
                .title("测试服务")// API 标题
                .description("测试服务提供的APIs")// API描述
                .contact("demo")// 联系人
                .version("1.0")// 版本号
                .build();
    }

}
