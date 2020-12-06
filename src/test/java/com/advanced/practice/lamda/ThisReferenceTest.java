package com.advanced.practice.lamda;

import org.junit.jupiter.api.Test;

public class ThisReferenceTest {

    @Test
    public void thisReferenceTest() {
        int a=10;
        doProcess(a, new Process() {
            @Override
            public void process(int i) {
                System.out.println("The value of i is "+i);
                System.out.println(this); // this reference points to the object of anonymous inner class.
            }

            public String toString(){
                return "This is Anonymous class";
            }
        });
    }

    @Test
    public void thisReferenceTestUsingLambda() {
        int a=10;
        int b=20; //effectively final. and the state is frozen.
        doProcess(a, i -> {
            System.out.println(this);  // this reference points to the caller of the lambda expression.
                                       // Here it is the caller object of thisReferenceTestUsingLambda(). which is
                                       // ThisReferenceTest class.

                                       //Which implies that lambda methods runs under isolation
                                       //and does'nt have create an instance of impl object for its interface.
        });
    }

    public static void doProcess(int i, Process p) {
        p.process(i);
    }

    interface Process {
        void process(int i);
    }
    public String toString(){
        return "This reference of the "+this.getClass();
    }
}