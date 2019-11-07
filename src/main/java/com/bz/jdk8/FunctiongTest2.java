package com.bz.jdk8;

import java.util.BitSet;
import java.util.function.BiFunction;
import java.util.function.Function;

public class FunctiongTest2 {
    public static void main(String[] args) {
        FunctiongTest2 test2 = new FunctiongTest2();

        System.out.println(test2.compute(2, value -> value * 2, value -> value +1)); //结果是6
        System.out.println(test2.compute2(2, value -> value * 2, value -> value +1)); //结果是5

        //加法
        System.out.println( test2.compute3(2,3, (a, b) -> a+b));
        //减法
        System.out.println( test2.compute3(5,3, (a, b) -> a-b));
    }

    public int compute3(int a, int b, BiFunction<Integer, Integer, Integer> function){

        return function.apply(a,b);
    }

    public int compute(int a, Function<Integer, Integer> function1, Function<Integer, Integer> function2){

        return function1.compose(function2).apply(a);
    }


    public int compute2(int a, Function<Integer, Integer> function1, Function<Integer, Integer> function2){

        return function1.andThen(function2).apply(a);
    }


}
