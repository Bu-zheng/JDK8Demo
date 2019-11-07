package com.bz.jdk8.stream;

import java.util.Arrays;
import java.util.List;

public class StreamTest8 {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("hello", "world", "hello world");

        //打印出长度为5的
        //错误的例子  输出为5
        list.stream().mapToInt(item -> item.length()).filter(length -> length == 5).
                findFirst().ifPresent(System.out::print);

        //错误例子 输出为 hello 5  原因，当寻找到集合中满足条件的第一个时就进行了短路操作输出结果
        list.stream().mapToInt(item ->{
            int length = item.length();
            System.out.println(item);
            return length;
        }).filter(length -> length == 5).findFirst().ifPresent(System.out::println);
    }
}
