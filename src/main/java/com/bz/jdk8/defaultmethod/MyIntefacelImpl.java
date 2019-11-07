package com.bz.jdk8.defaultmethod;

import com.bz.jdk8.MyInterface;

public class MyIntefacelImpl implements MyInterface1 {

    public static void main(String[] args) {
        MyIntefacelImpl myInterfacel = new MyIntefacelImpl();
        myInterfacel.testMythod();
    }

    @Override
    public void testMythod() {
        System.out.println("继承的接口");
    }
}
