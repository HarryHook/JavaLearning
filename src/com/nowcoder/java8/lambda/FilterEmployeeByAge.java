package com.nowcoder.java8.lambda;

public class FilterEmployeeByAge implements MyFilter<Employee> {
    @Override
    public boolean test(Employee e) {
        return e.getAge() > 35;
    }
}
