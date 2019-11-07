package com.bz.jdk8.Test;

import com.bz.jdk8.model.Person;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

public class PersonTest {

    public static void main(String[] args) {
        Person person1 = new Person("ZHANGSAN", 21);
        Person person2 = new Person("LISI", 22);
        Person person3 = new Person("WANGWU", 23);
        List<Person> personList = Arrays.asList(person1, person2, person3);
        System.out.println("#######################");
        PersonTest personTest = new PersonTest();
        List<Person> persons = personTest.getPersonByUserName("ZHANGSAN", personList);
        persons.forEach(person -> System.out.println(person.getUserName()));

        System.out.println("#######################");
        List<Person> personByAge = personTest.getPersonByAge(20, personList);
        personByAge.forEach(person -> System.out.println(person.getUserName() + "\t" + person.getAge()));

        System.out.println("#######################");
        List<Person> list = personTest.getPersonByAge2(20, personList, (age, psersonList) ->
            psersonList.stream().filter(person -> person.getAge() > age).collect(Collectors.toList())
        );
        list.forEach(person -> System.out.println(person.getAge()));

    }

    public List<Person> getPersonByUserName(String userName, List<Person> personList) {

        return personList.stream().filter(person -> person.getUserName().equals(userName)).collect(Collectors.toList());
    }

    public List<Person> getPersonByAge(int age, List<Person> personList) {
        //1、先定义一个函数行为。
        BiFunction<Integer, List<Person>, List<Person>> biFunction = (agePerson, persons) ->
                personList.stream().filter(person -> person.getAge() > age).collect(Collectors.toList());

        //2、使用试下定义的函数行为
        return biFunction.apply(age, personList);
    }

    //传入参数，函数行为，在将传入的参数放入行为中进行执行
    public List<Person> getPersonByAge2(int age, List<Person> personList, BiFunction<Integer, List<Person>, List<Person>> biFunction) {
        return biFunction.apply(age, personList);
    }
}
