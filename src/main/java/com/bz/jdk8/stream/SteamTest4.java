package com.bz.jdk8.stream;

import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SteamTest4 {
    public static void main(String[] args) {
        Stream<String> stream = Stream.of("hello", "world", "java");
//        TreeSet<String> collect = stream.collect(Collectors.toCollection(TreeSet::new));
//        collect.forEach(System.out::println);

        //将流中的内容进行拼接
        String str = stream.collect(Collectors.joining());
        System.out.println(str);

        Stream<List<Integer>> stream1 = Stream.of(
                Arrays.asList(1),Arrays.asList(2,3),Arrays.asList(4,5,5)
        );

        stream1.flatMap(theList -> theList.stream()).map(item -> item * item).forEach(System.out::println);

    }
}
