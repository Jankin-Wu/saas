package com.ldcc.api;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

//@EnableSwagger2
@MapperScan(basePackages = "com.ldcc.**.mapper")// 使用MapperScan批量扫描所有的Mapper接口；
@ComponentScan("com.ldcc.**")
@SpringBootApplication
public class SaasApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(SaasApiApplication.class, args);
        System.err.println("启动成功");
    }

}
