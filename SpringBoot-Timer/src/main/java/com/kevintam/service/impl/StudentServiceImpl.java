package com.kevintam.service.impl;

import com.alibaba.excel.EasyExcel;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kevintam.entity.Student;
import com.kevintam.mapper.StudentMapper;
import com.kevintam.service.StudentService;
import com.kevintam.utils.EasyExcelListener;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author kevintam
 * @version 1.0
 * @title
 * @description
 * @createDate 2022/6/11
 */
@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student> implements StudentService {

    @Resource
    private StudentMapper studentMapper;

    //查询所有的数据
    public List<Student> selectAll() {
        return studentMapper.selectList(null);
    }

    @Override
    public boolean insertStudent(Student student) {
        return studentMapper.insert(student) > 0;
    }

    @Override
    public void addStudent(MultipartFile file, StudentService studentService) {
        try {
            InputStream in = file.getInputStream();
            //进行读取操作
            EasyExcel.read(in,Student.class,new EasyExcelListener(studentService)).sheet("学生信息").doRead();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
