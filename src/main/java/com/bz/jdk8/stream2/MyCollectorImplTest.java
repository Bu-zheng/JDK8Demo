package com.bz.jdk8.stream2;

import java.util.HashSet;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

public class MyCollectorImplTest<Student> implements Collector<Student, Set<Student>,  Set<Student>> {



    public static void main(String[] args) {
        Object o = new MyCollectorImplTest<>().supplier().get();
        System.out.println(o);
    }

    @Override
    public Supplier<Set<Student>> supplier() {
        Set<Student> set = new HashSet<Student>();

        return HashSet<Student>::new;
    }

    @Override
    public BiConsumer<Set<Student>, Student> accumulator() {
        return null;
    }

    @Override
    public BinaryOperator<Set<Student>> combiner() {
        return null;
    }

    @Override
    public Function<Set<Student>, Set<Student>> finisher() {
        return null;
    }

    @Override
    public Set<Characteristics> characteristics() {
        return null;
    }
}
