package com.bz.jdk8.Test;

import com.bz.jdk8.model.Student;

import java.util.Optional;

public class OptionalTest {
    public static void main(String[] args) {
        Optional optional = Optional.of("hello");
        Optional<String> optional2 = Optional.empty();
        Optional<Student> optional3 = Optional.empty();

        //1、判断对象如果不为空，输出对象
        optional.ifPresent(item -> System.out.println(item));
        System.out.println("==========");

        //2、如果对象为空输出指定值
        System.out.println(optional2.orElse("如果没有值才出现"));
        System.out.println("============");

        //3、如果对象为空做指定操作 —— 其中orElseGet(Supplier<? extends T> other)
        //Supplier（T t）不传入参数返回一个类型
        Student student1 = optional3.orElseGet(() -> {
            System.out.println("新建一個學生對象");
            Student student = new Student();
            student.setName("歪");
            student.setAge(26);
            return student;
        });
        System.out.println(student1.getName() + "\t" + student1.getAge());
    }
}
