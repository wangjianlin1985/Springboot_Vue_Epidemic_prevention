package com.design.covid9server;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.design.covid9server.mapper")
public class Covid9ServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(Covid9ServerApplication.class, args);
    }

}
