package com.bz.jdk8.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SteamTest9 {
    public static void main(String[] args) {

        List<String> sayList = Arrays.asList("hi", "hello", "你好");
        List<String> peopleList = Arrays.asList("刘备", "关羽", "张飞");

        //将sayList分别于peopleList拼接————》hi刘备，hi关羽，hi张飞
        List<String> result = sayList.stream().flatMap(item -> peopleList.stream().map(item2 -> item + " " + item2))
                .collect(Collectors.toList());
        result.forEach(System.out::println);
    }
}
