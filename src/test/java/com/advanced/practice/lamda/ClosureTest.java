package com.advanced.practice.lamda;

import org.junit.jupiter.api.Test;

public class ClosureTest {

    @Test
    public void closureTest() {
        int a=10;
        int b=20; //effectively final. and the state is frozen.
        doProcess(a,i -> System.out.println(i+b));
    }

    public static void doProcess(int i, Process p) {
        p.process(i);
    }

    interface Process {
        void process(int i);
    }
}