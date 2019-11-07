package com.bz.jdk8.Test;

import com.bz.jdk8.model.Company;
import com.bz.jdk8.model.Employee;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class OptionalTest2 {
    public static void main(String[] args) {
        Employee employee = new Employee();
        employee.setName("张三");

        Employee employee1 = new Employee();
        employee1.setName("李四");

        Company company = new Company();
        company.setName("不正有限公司");

        List<Employee> employeeList = Arrays.asList(employee, employee1);
        company.setEmployeeList(employeeList);


        //Optional.ofNullable(company):判断company是否为空，为空直接new空对象，不为空将返回Optional对象
        //Optional.ofNullable(company).map(Company::getEmployeeList)：取company中EmployeeList（集合）的值
        //orElse(Collections.emptyList()):判断取company中EmployeeList（集合）是否为空，为空直接新建一个对象，不为空，返回传入的值，即返回EmployeeList（集合）
        List<Employee> employeeList1 = Optional.ofNullable(company).map(Company::getEmployeeList).
                orElse(Collections.emptyList());
        employeeList1.forEach(item -> System.out.println(item.getName()));
    }
}
