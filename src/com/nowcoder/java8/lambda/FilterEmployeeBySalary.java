package com.nowcoder.java8.lambda;

public class FilterEmployeeBySalary implements MyFilter<Employee> {
    @Override
    public boolean test(Employee e) {
        return e.getSalary() > 5000;
    }
}
