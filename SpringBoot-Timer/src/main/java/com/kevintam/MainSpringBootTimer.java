package com.kevintam;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author kevintam
 * @version 1.0
 * @title
 * @description
 * @createDate 2022/4/23
 */
@SpringBootApplication
@EnableScheduling
@MapperScan("com.kevintam.mapper")
public class MainSpringBootTimer {
    public static void main(String[] args) {
        SpringApplication.run(MainSpringBootTimer.class,args);
    }
}
