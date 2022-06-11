package com.kevintam.utils;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.kevintam.entity.Student;
import com.kevintam.mapper.StudentMapper;
import com.kevintam.service.StudentService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author kevintam
 * @version 1.0
 * @title
 * @description
 * @createDate 2022/6/11
 */

public class EasyExcelListener extends AnalysisEventListener<Student>{

    public StudentService service;

    public EasyExcelListener(){}

    public EasyExcelListener(StudentService service){
            this.service = service;
    }

    //一行接着一行去读取
    @Override
    public void invoke(Student student, AnalysisContext analysisContext) {
         if(student==null){
             throw new NullPointerException("数据为空");
         }
         service.insertStudent(student);
    }
    //读取所有的数据后执行的回调函数
    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
        System.out.println("读取完毕");
    }
}
