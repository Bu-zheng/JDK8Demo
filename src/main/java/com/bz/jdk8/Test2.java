package com.bz.jdk8;

public class Test2 {

    public void myTest(MyInterface myInterface){
        System.out.println(1);
        myInterface.test();
        System.out.println(2);

    }

    public static void main(String[] args) {
        Test2 test2 = new Test2();
        test2.myTest(new MyInterface() {
            @Override
            public void test() {
                System.out.println("hello world");
            }
        });

        test2.myTest(() -> {
            System.out.println("myTest");
        });
        //给接口定义函数
        MyInterface myInterface = () -> {
            System.out.println("xixixiix");
        };
        //使用定义的函数接口
        test2.myTest(myInterface);

        new Thread(() -> System.out.println("启动线程")).start();
    }
}
