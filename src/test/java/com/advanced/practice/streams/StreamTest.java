package com.advanced.practice.streams;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.reducing;

public class StreamTest {

    private static boolean checkNotSam(Employee employee) {
        return !employee.getName().startsWith("D");
    }

    @Test
    public void mapToInt() {
        List<Employee> employees = Arrays.asList(
                new Employee("Alice",28,19500,5,"A"),
                new Employee("David",31,17000,8,"A"),
                new Employee("Smith",19,22700,7,"B"),
                new Employee("Billings",32,15000,6,"C"));

        int totalSalary = employees.stream().filter(employee -> employee.getAge()>30).collect(Collectors.summingInt(Employee::getSalary));
        System.out.println(totalSalary);
        employees.stream().map(p -> p.getHeight()).forEach(p->p.intValue());


        Comparator<Employee> byHeight = Comparator.comparing(e -> e.getHeight());

        reducing(BinaryOperator.minBy(byHeight));

        Map<String, Optional<Employee>> optionalMap = employees.stream().collect(groupingBy(Employee::getCity, reducing(BinaryOperator.minBy(byHeight))));

        System.out.println(optionalMap.get("A").get().getHeight());
        System.out.println(optionalMap.get("B").get().getHeight());
        System.out.println(optionalMap.get("C").get().getHeight());

        List<Integer> integers = Arrays.asList(1,2,4,5);

        int sum = integers.stream().reduce(10, Integer::sum);

        System.out.println(sum);

    }


    class Employee{

        int age;
        int salary;
        String name;
        int height;
        String city;

        public Employee(String name, int age, int salary, int height,  String city) {
            this.age = age;
            this.salary = salary;
            this.name = name;
            this.height = height;
            this.city = city;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public int getSalary() {
            return salary;
        }

        public void setSalary(int salary) {
            this.salary = salary;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getHeight() {
            return height;
        }

        public void setHeight(int height) {
            this.height = height;
        }


        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

    }
}
