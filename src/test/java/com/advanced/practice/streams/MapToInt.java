package com.advanced.practice.streams;

import com.advanced.practice.User;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MapToInt {

    @Test
    public void mapToInt() {
        List<String> names = Arrays.asList("Alice","Bob","Caroline","Danny");
        List<User> users = names.stream().filter(this::isNotAlice)
                .map(User::new)
                .collect(Collectors.toList());
        int sum = users.stream().mapToInt(User::getAge).sum();
        System.out.println(sum);
    }

    private boolean isNotAlice(String name) {
        return !name.equals("Alice");
    }
}
