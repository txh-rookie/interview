package com.kevintam.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.kevintam.entity.Student;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface StudentService extends IService<Student> {
    //查询所有的学生信息
     public List<Student> selectAll();
     public boolean insertStudent(Student student);

    void addStudent(MultipartFile file, StudentService studentService);
}
