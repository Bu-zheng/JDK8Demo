package com.bz.jdk8.Test;

import java.util.Comparator;
import java.util.function.BinaryOperator;

public class BinaryOperatorTest {
    public static void main(String[] args) {
        BinaryOperatorTest binaryOperatorTest = new BinaryOperatorTest();
        System.out.println(binaryOperatorTest.compute(1, 2, (a, b) -> a + b));
        System.out.println(binaryOperatorTest.compute(1, 2, (a, b) -> a * b));
        System.out.println("===========");

        int i = binaryOperatorTest.compute2(2, 3, Integer::compareTo);
        System.out.println(i);

    }


    public int compute(int a, int b, BinaryOperator<Integer> binaryOperator) {
        return binaryOperator.apply(a, b);
    }

    /**
     * 比较两个参数比较小的
     *      返回比较小的（也可以指长度）
     * @param a
     * @param b
     * @param comparable
     * @return
     */
    public int compute2(int a, int b, Comparator<Integer> comparable) {
        return BinaryOperator.minBy(comparable).apply(a, b);
    }
}
