package com.bz.jdk8.stream2;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamTest002 {
    public static void main(String[] args) {

        List<String> list = Arrays.asList("hello", "world", "java");
        String collect = list.stream().collect(Collectors.joining());


    }
}
