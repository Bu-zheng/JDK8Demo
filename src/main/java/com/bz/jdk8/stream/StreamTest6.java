package com.bz.jdk8.stream;

import java.util.Arrays;
import java.util.List;

public class StreamTest6 {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("hello", "world", "java");

        //map中的sout打印并不执行，因为还没进行终止操作,仍会返回一个流，即这个流并没有被关闭
        list.stream().map(item -> {
            String result = item.substring(0, 1).toUpperCase() + item.substring(1);
            System.out.println("是否执行");
            return  result;
        });

        //正确做法，需进行终止流的动作
        list.stream().map(item -> {
            String result = item.substring(0, 1).toUpperCase() + item.substring(1);
            System.out.println("是否执行");
            return  result;
        }).forEach(System.out::println);

//        list.stream().map(item -> item.substring(0, 1).toUpperCase() + item.substring(1)).forEach(System.out::println);

    }
}
