package com.nowcoder.java8.lambda;

@FunctionalInterface
public interface MyFilter<T> {
    public boolean test(T t);
}
