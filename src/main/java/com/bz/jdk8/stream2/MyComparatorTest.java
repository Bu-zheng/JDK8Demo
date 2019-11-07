package com.bz.jdk8.stream2;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class MyComparatorTest {

    public static void main(String[] args) {

        List<String> list = Arrays.asList("hello", "world", "java", "welcome");

        /**
         * 按照字符串长度进行排序
         */
        Collections.sort(list, (item1, item2) -> item1.length() - item2.length());
        Collections.sort(list, Comparator.comparingInt(String::length));
        System.out.println(list);
        System.out.println("===================");
        //降序
        Collections.sort(list, Comparator.comparingInt(String::length).reversed());
        Collections.sort(list, Comparator.comparingInt((String item) -> item.length()).reversed());
        System.out.println(list);
        System.out.println("===================");
        //等价于list.sort（）. 可以看到源码中 Collections.sort（）调用的就是list.sort
        list.sort(Comparator.comparingInt(String::length).reversed());

        System.out.println("===================");
        //两重比较
        //当比较器比较时有两个元素相等的时候，才会继续使用thenComparing继续排序，否则thenComparing不会被使用

        Collections.sort(list, Comparator.comparingInt(String::length).
                thenComparing(String.CASE_INSENSITIVE_ORDER));
        list.sort(Comparator.comparingInt(String::length).thenComparing(String.CASE_INSENSITIVE_ORDER));
        System.out.println(list);
        System.out.println("===================");

        //先按长度排序，在长度相等的按字母大小排序，最后将长度相等的单词反序
        list.sort(Comparator.comparingInt(String::length).thenComparing(String::toLowerCase, Comparator.reverseOrder()));
        System.out.println(list);

    }


}
