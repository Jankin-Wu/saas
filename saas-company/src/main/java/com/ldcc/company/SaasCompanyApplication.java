package com.ldcc.company;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.ldcc.**.mapper")// 使用MapperScan批量扫描所有的Mapper接口；
public class SaasCompanyApplication {

    public static void main(String[] args) {
        SpringApplication.run(SaasCompanyApplication.class, args);
    }

}
