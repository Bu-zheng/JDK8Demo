package com.bz.jdk8.Test;

import com.bz.jdk8.model.Student;

import java.util.function.Supplier;

/**
 * 常用于工厂模式
 */
public class SupplierTest {
    public static void main(String[] args) {
        Supplier<Student> supplier = () -> new Student();
        System.out.println(supplier.get().getName());
        System.out.println("=============");

        Supplier<Student> supplier12 = Student::new;
    }
}
