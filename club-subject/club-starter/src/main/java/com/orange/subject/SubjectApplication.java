package com.orange.subject;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

//刷题微服务启动类

@SpringBootApplication  //springboot启动类
@ComponentScan("com.orange")    //类扫描路径
@MapperScan("com.orange.**.mapper")     //mapper扫描路径
public class SubjectApplication {
    public static void main(String[] args) {
        SpringApplication.run(SubjectApplication.class);
    }
}
