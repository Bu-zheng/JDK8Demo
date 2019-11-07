package com.bz.jdk8.stream;

import com.bz.jdk8.model.Student;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamTest9 {
    public static void main(String[] args) {
        Student stu1 = new Student("张三", 100, 20);
        Student stu2 = new Student("李四", 90, 22);
        Student stu3 = new Student("王武", 80, 21);
        Student stu4 = new Student("张三", 100, 23);


        List<Student> studentList = Arrays.asList(stu1, stu2, stu3, stu4);

        //将这些学生进行名称分组
        Map<String, List<Student>> collect = studentList.stream().collect(Collectors.groupingBy(Student::getName));
        Map<Integer, List<Student>> collect1 = studentList.stream().collect(Collectors.groupingBy(Student::getScore));
        System.out.println(collect);

        //将学生进行姓名分组且求出每组的个数
        Map<String, Long> collect2 = studentList.stream().
                collect(Collectors.groupingBy(Student::getName, Collectors.counting()));

        System.out.println(collect2);//张三=2，李四=1，王武=1

        //分区
        Map<Boolean, List<Student>> collect3 = studentList.stream().collect(Collectors.partitioningBy(item -> item.getScore() > 90));
        System.out.println(collect3);
    }
}
