package com.bz.jdk8.stream;

import com.bz.jdk8.model.Person;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTest5 {
    public static void main(String[] args) {
//        List<Integer> intList = Arrays.asList(1, 2, 4, 5, 6);
//        intList.stream().findFirst().ifPresent(System.out::print);
//
//        Stream<String> stream = Stream.generate(UUID.randomUUID()::toString);
//        stream.findFirst().ifPresent(System.out::print);

        /**
         *        iterate: 第一个参数为 原始参数，即传入item 的。 第二个参数为一个function （t -> t）
         *        传入什么，传出什么。如果不加limit限制，那么这个流将会成为一个无限流。
         *        用于创建一个有条件的对象集合
         */
        //找出流中大于2的元素，然后将每个元素乘以2，然后忽略掉前两个元素，在取前两个元素，然后求总和
        //3  5  7  9
        int i = Stream.iterate(1, item -> item + 2).limit(7).
                filter(a -> a > 2).map(b -> b * 2).skip(2).limit(2).mapToInt(c -> c).sum();
        System.out.println("ce==="+i);

        System.out.println(Stream.iterate(1, item -> item + 2).limit(7).
                filter(a -> a > 2).mapToInt(b -> b * 2).skip(2).limit(2).sum()); //mapToInt 将其自动转成int


        Person person = new Person();
        Stream.iterate(person, model -> {

            model.setUserName(UUID.randomUUID().toString());

            return model;
        }).limit(3).collect(Collectors.toList()).forEach(item -> System.out.println(item.getUserName()));


    }
}
