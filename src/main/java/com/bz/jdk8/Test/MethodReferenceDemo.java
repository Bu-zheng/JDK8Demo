package com.bz.jdk8.Test;

import java.util.Arrays;
import java.util.List;

public class MethodReferenceDemo {

    public static void main(String[] args) {
        List<String>  list = Arrays.asList("张三","李四", "王武");

        //lambda表达式模式
        list.forEach(item -> System.out.println(item));

        //方法引用模式
        list.forEach(System.out :: print);
    }
}
