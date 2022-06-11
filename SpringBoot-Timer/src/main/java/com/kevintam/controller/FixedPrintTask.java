package com.kevintam.controller;

import com.kevintam.config.ScheduleConfig;
import com.kevintam.entity.Student;
import com.kevintam.service.StudentService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author kevintam
 * @version 1.0
 * @title
 * @description
 * @createDate 2022/4/23
 */
@Component
@Log
public class FixedPrintTask {

    @Autowired
    private StudentService service;

    @Resource
    private JavaMailSender mailSender;

    @Async(ScheduleConfig.EXECUTOR_SERVICE)
    @Scheduled(cron = "0 0 15 ? * WED")
    public void execute() throws InterruptedException {
//       场景：定时任务从数据库查询用户信息，对每个用户发送消息）
        log.info("-----------开始查询任务-----------");
        List<Student> students = service.selectAll();
        students.forEach(val->{
            SimpleMailMessage message = new SimpleMailMessage();
            message.setSubject("测试");
            message.setText(val.getName()+"的"+"用户信息");
            message.setFrom("843808107@qq.com");
            message.setTo(val.getEmail());
            try{
                mailSender.send(message);
            }catch(Exception e){
                e.printStackTrace();
            }
        });
        log.info("-----------结束查询任务-----------");
    }
//    @Async(ScheduleConfig.EXECUTOR_SERVICE)
//    @Scheduled(cron = "*/15 * * * * ?")
//    public void execute2(){
//        log.info("thread id:{"+Thread.currentThread().getId()+"}");
//    }
}
