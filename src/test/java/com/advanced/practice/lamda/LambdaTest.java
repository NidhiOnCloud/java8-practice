package com.advanced.practice.lamda;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class LambdaTest {
    private static boolean notA_Or_B(String name) {
        return !name.equals("A") && !name.equals("B");
    }

    @Test
    public void firstNoDivisibleBy5Test() {
        List<Integer> numbers = Arrays.asList(60, 15, 20, 19, 34, 40, 80);
        for (int number : numbers) {
            if (number % 5 == 0) {
                System.out.println(+number + " :It is divisible by 6");
                return;
            }
        }
    }

    @Test
    public void lambdaLazyEvaluationTest() {
        List<Integer> numbers = Arrays.asList(60, 15, 20, 19, 34, 40, 80);
        Optional<Integer> firstDivisibleBy5 = numbers.stream().filter(integer -> integer%5==0).findFirst();
        System.out.println(firstDivisibleBy5.get());
    }
}

