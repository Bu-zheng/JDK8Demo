package com.bz.jdk8.stream2;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class MySetCollect2<T> implements Collector<T, Set<T>, Map<T, T>> {
    @Override
    public Supplier<Set<T>> supplier() {
        System.out.println("supplier invoked");
//        return HashSet<T>::new;
        return () ->{
            System.out.println("------------");
            return new HashSet<T>();
        };
    }


    @Override
    public BiConsumer<Set<T>, T> accumulator() {
        System.out.println("accumulator invoked");
        return (set, item) -> {
//            System.out.println("thred===>"+set +","+Thread.currentThread().getName());
            set.add(item);
        };
    }

    @Override
    public BinaryOperator<Set<T>> combiner() {
        System.out.println("combiner invoked");
        return (set1, set2) -> {
            set1.addAll(set2);
            return set1;
        };
    }

    @Override
    public Function<Set<T>, Map<T, T>> finisher() {
        System.out.println("finisher invoked");
        return set -> {
            Map<T, T> map = new HashMap<>();
            set.forEach(item -> map.put(item, item));
            return map;
        };
    }

    @Override
    public Set<Characteristics> characteristics() {
        System.out.println("characteristics invoked");

        return Collections.unmodifiableSet(EnumSet.of(
                Characteristics.UNORDERED));
    }


    public static void main(String[] args) {

        for(int i = 0; i < 1; i++){
            //输入：set<t>
            //输出：map<t,t>
            List<String> list = Arrays.asList("wang", "lin", "weng", "huang","weng", "huang", "a", "b", "c");
            //串行
//        Map<String, String> collect = list.stream().collect(new MySetCollect2<>());
            //并行
            Map<String, String> collect = list.parallelStream().collect(new MySetCollect2<>());

            System.out.println("=======");
            System.out.println(collect);
        }



   /*     Set<String> set = new HashSet<>();
        set.addAll(list);
        System.out.println(set);*/



    }
}
