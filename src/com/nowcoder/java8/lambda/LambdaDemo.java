package com.nowcoder.java8.lambda;

import org.junit.Test;

import java.util.*;
import java.util.stream.Stream;

public class LambdaDemo {
    public void test() {
        Comparator<Integer> cmp = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1, o2);
            }
        };
        TreeSet<Integer> treeSet = new TreeSet<>(cmp);
    }

    @Test
    public void test1() {
        Comparator<Integer> cmp = (x, y) -> Integer.compare(x, y);
        TreeSet<Integer> treeSet = new TreeSet<>(cmp);
    }

    List<Employee> employees = Arrays.asList(
            new Employee(18, "zhangsan", 15236.212),
            new Employee(25, "lsii", 6666.666),
            new Employee(36, "wangwu", 1525.21)
    );

    /*//获取员工中年龄大于35的所有信息
    public List<Employee> filterEmployee1(List<Employee> list) {
        List<Employee> emps = new ArrayList<>();
        for (Employee emp : list) {
            if (emp.getAge() > 35) {
                emps.add(emp);
            }
        }
        return emps;
    }
    //需求：需要得到当前公司工作大于5000的员工信息
    public List<Employee> filterEmployee2(List<Employee> list) {
        List<Employee> emps = new ArrayList<>();
        for (Employee emp : list) {
            if (emp.getSalary() > 35) {
                emps.add(emp);
            }
        }
        return emps;
    }*/
    /*@Test
    public void test3() {
        List<Employee> list = filterEmployee1(employees);
        for(Employee emp: list){
            System.out.println(emp.toString());
        }
    }*/

    public List<Employee> filterEmployee(List<Employee> list, MyFilter<Employee> mp) {
        List<Employee> emps = new ArrayList<>();
        for (Employee emp : list) {
            if (mp.test(emp)) {
                emps.add(emp);
            }
        }
        return emps;
    }

    //改进一：策略模式实现
    @Test
    public void test4() {
        List<Employee> list1 = filterEmployee(employees, new FilterEmployeeByAge());
        for (Employee emp : list1) {
            System.out.println(emp);
        }
        List<Employee> list2 = filterEmployee(employees, new FilterEmployeeBySalary());
        for (Employee emp : list2) {
            System.out.println(emp);
        }

    }

    //改进二：匿名内部类实现
    @Test
    public void test5() {
        List<Employee> list1 = filterEmployee(employees, new MyFilter<Employee>() {
            @Override
            public boolean test(Employee employee) {
                return employee.getName().equalsIgnoreCase("zhangsan");
            }
        });
        for (Employee emp : list1) {
            System.out.println(emp);
        }
    }

    //改进三：lambda表达式
    @Test
    public void test6() {
        List<Employee> list1 = filterEmployee(employees, e -> e.getSalary() > 5000);
        for (Employee emp : list1) {
            System.out.println(emp);
        }
    }

    //改进四：Stream API
    @Test
    public void test7() {
        Stream<Employee> stream = employees.stream().filter(e -> e.getSalary() > 5000);
        stream.limit(3).forEach(System.out::println);
    }
}
