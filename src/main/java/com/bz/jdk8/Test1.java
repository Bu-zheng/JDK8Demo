package com.bz.jdk8;

import com.bz.jdk8.model.Employee;
import com.bz.jdk8.model.Student;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

public class Test1 {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);
      /*  //传统的
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

        //jdk5
        for (Integer integer : list) {
            System.out.println(integer);
        }*/

        //jdk8
       /* list.forEach(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                System.out.println(integer * 3);
            }
        });

        list.forEach(i -> {
            System.out.println(i);
        });*/

       /* List<Integer> list2 = new ArrayList<>();
        list.forEach(item -> list2.add(item + 1));
        list2.forEach(i2 -> {
            System.out.println("########################");
            System.out.println(i2);
        });
*/
        Function<String, String> function = String::toUpperCase;
        System.out.println(function.apply("hahah"));

        List<String> list1 = null;
        List<String> list3 = new ArrayList<>();
      /*  for (String s : list1) {
            System.out.println(s);
        }
        for (String s : list3) {
            System.out.println(s);
        }*/
//        for (int i = 0; i < list1.size(); i++) {
//            System.out.println(list1[i]);
//        }
        System.out.println("==========");
        Test1 test1 = new Test1();
        String hahah = test1.test("xiixi");
        System.out.println(hahah.toString());

    }


    public String test(String string) {


        return this.toString();
    }
}
