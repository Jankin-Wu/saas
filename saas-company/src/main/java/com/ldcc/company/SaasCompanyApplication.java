package com.ldcc.company;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@MapperScan(basePackages = "com.ldcc.**.mapper")// 使用MapperScan批量扫描所有的Mapper接口；
public class SaasCompanyApplication {

    public static void main(String[] args) {
        try {
            SpringApplication.run(SaasCompanyApplication.class, args);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.err.println("启动成功");
    }

}
