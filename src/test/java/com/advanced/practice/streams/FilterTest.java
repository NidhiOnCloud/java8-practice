package com.advanced.practice.streams;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Predicate;

class FilterTest {
    @Test
    public void filters_test() {
        List<String> names = Arrays.asList("A","B","C","D");
        names.stream().filter(new Predicate<String>() {
            @Override
            public boolean test(String name) {
                return !name.equals("A");
            }
        }).forEach(name->System.out.println(name));
    }
    @Test
    public void filters_test_using_lambda() {
        List<String> names = Arrays.asList("A","B","C","D");
        names.stream().filter(name -> !name.equals("A") && !name.equals("B") ).forEach(name->System.out.println(name));
    }

    @Test
    public void filters_using_lambda_method_refs() {
        List<String> names = Arrays.asList("A","B","C","D");
        names.stream().filter(this::filterByParams).forEach(System.out::println);
    }

    private boolean filterByParams(String name) {
        return !name.equals("A") && !name.equals("B");
    }
}