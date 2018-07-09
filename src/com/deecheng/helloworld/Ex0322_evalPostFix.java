package com.deecheng.helloworld;

import java.util.Scanner;
import java.util.Stack;

public class Ex0322_evalPostFix {
    static double evalPostFix() {
        Stack<Double> s = new Stack<Double>();
        String token;
        Double a, b, result = 0.0;
        boolean isNumber;

        Scanner sc = new Scanner(System.in);
        token = sc.next();
        while (token.charAt(0) != '=') {
            try {
                isNumber = true;
                result = Double.parseDouble(token);
            } catch (Exception e) {
                isNumber = false;
            }
            if (isNumber) {
                s.push(result);
            } else {
                switch (token.charAt(0)) {
                    case '+':
                        a = s.pop();
                        b = s.pop();
                        s.push(a + b);
                        break;
                    case '-':
                        a = s.pop();
                        b = s.pop();
                        s.push(a - b);
                        break;
                    case '*':
                        a = s.pop();
                        b = s.pop();
                        s.push(a * b);
                        break;
                    case '/':
                        a = s.pop();
                        b = s.pop();
                        s.push(a / b);
                        break;
                    case '^':
                        a = s.pop();
                        b = s.pop();
                        s.push(a * Math.log(b));
                        break;

                }
            }
            token = sc.next();
        }
        return s.peek();
    }
}
