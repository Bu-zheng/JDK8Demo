package com.bz.jdk8.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamTest1 {

    public static void main(String[] args) {
        //创建流方法一
        Stream stream1 = Stream.of("hello", "world", "java");

        //创建流方法二  通过数组创建
        String[] myArray = new String[]{"hello", "world", "java", "wai"};
        Stream stream2 = Stream.of(myArray);
        Stream stream3 = Arrays.stream(myArray);

        //创建流方法三 通过集合创建
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);
        Stream<Integer> stream = list.stream();

    }
}
