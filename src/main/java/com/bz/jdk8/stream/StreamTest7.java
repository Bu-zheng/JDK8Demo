package com.bz.jdk8.stream;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

public class StreamTest7 {

    public static void main(String[] args) {

        //并发流 与 串行流
        List<String> list = new ArrayList<>(100000000);
        for (int i = 0; i < list.size(); i++) {
            list.add(UUID.randomUUID().toString());
        }

        System.out.println("开始排序");

        long startTime = System.nanoTime();
        //parallelStream 串行（多线程）  stream 并发（单线程）
        list.stream().sorted(Comparator.reverseOrder()).count();  //count() 用于终止流。不然sorted为流的中间操作，流没有终止，不会执行sorted（）
        long endTime = System.nanoTime();

        long millis = TimeUnit.NANOSECONDS.toMillis(endTime - startTime);
        System.out.println("执行时间为===》" + millis);



    }
}
