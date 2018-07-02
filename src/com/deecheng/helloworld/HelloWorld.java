package com.deecheng.helloworld;

import java.util.ArrayList;

public class HelloWorld {

    public static void printOut(int n) {

        if ( n >= 10 ) {
            printOut( n / 10);
        }
        printDigit( n % 10);
    }

    public static int ones(int n) {
        ArrayList<Integer> stack = new ArrayList<>();
        if (n < 2) {
            return n;
        }
        stack.add(n % 2 + ones(n / 2));
        for (Integer i : stack) {
            System.out.println(i);
        }
        return 0;
    }

    public static void printDigit(int digit) {
        System.out.println(digit);
    }

    public static void main(String[] args) {
        int i=5;
//        printOut(i);
        ones(i);
    }
}


