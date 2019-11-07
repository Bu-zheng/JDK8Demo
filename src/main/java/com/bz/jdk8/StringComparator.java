package com.bz.jdk8;

import java.util.*;

public class StringComparator {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("zhangshan", "lisi", "wangwu", "zhaoliu");

        Collections.sort(names, Comparator.reverseOrder());
        Collections.sort(names, (s1, s2) ->  s2.compareTo(s1));
        System.out.println(names);

    }
}
