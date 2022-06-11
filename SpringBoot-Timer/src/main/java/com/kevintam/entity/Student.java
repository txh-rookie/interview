package com.kevintam.entity;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author kevintam
 * @version 1.0
 * @title
 * @description
 * @createDate 2022/6/11
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    @ExcelProperty(value = "学生id",index = 0)
    private Long id;
    @ExcelProperty(value = "学生姓名",index = 1)
    private String name;
    @ExcelProperty(value = "学生性别",index = 2)
    private String gender;
    @ExcelProperty(value = "学生年龄",index = 3)
    private String age;
    @ExcelProperty(value = "学生邮箱",index = 4)
    private String email;
}
