package com.kevintam.controller;

import com.kevintam.entity.Student;
import com.kevintam.service.StudentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author kevintam
 * @version 1.0
 * @title
 * @description
 * @createDate 2022/6/11
 */
@RestController
public class StudentController {

    @Resource
    private StudentService studentService;

    @GetMapping("/student/all")
    public List<Student> selectAll() {
        return studentService.selectAll();
    }

    @PostMapping("/student/add")
    public void add(MultipartFile file) {
        studentService.addStudent(file,studentService);
    }
}
