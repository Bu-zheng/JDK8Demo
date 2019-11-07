package com.bz.jdk8.stream;

import java.util.stream.IntStream;

public class StreamTest2 {
    public static void main(String[] args) {

        IntStream.of(new int[]{1,2,3,4,5,6,7}).forEach(System.out::println);
        System.out.println("==========");

        //构造一个以3开始，8结尾的list
        IntStream.range(3, 8).forEach(System.out::println);//不包含8
        IntStream.rangeClosed(3, 8).forEach(System.out::println);//包含8

    }
}
