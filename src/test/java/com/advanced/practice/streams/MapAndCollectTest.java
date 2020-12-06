package com.advanced.practice.streams;

import com.advanced.practice.User;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MapAndCollectTest {
    private boolean isNotBob(String name) {
        return !name.equals("A");
    }

    @Test
    public void mapAndCollectTest() {
        List<String> names = Arrays.asList("Alice","Bob","Caroline","Danny");
        List<User> users = names.stream().filter(this::isNotBob)
                .map(User::new)
                .collect(Collectors.toList());
        for(User user : users){
            System.out.println(user.getName());
        }
    }
}
