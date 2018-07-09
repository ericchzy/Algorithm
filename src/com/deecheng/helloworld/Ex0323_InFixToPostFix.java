package com.deecheng.helloworld;

import java.util.Scanner;
import java.util.Stack;

public class Ex0323_InFixToPostFix {
    static void InFixToPostFix() {
        Stack<Character> s = new Stack<>();
        String expression;
        Character token;
        int i=0;

        Scanner sc = new Scanner(System.in);
        expression = sc.nextLine();

        while ((token = expression.charAt(i++)) != '='){
            if (token >= 'a' && token <= 'z')
                System.out.print(token + " ");
            else {
                switch (token) {
                    case ')': while ( !s.empty() && s.peek() != '(' )
                            { System.out.print(s.pop() + " "); }
                            s.pop();
                            break;
                    case '(': s.push(token);
                            break;
                    case '^': while ( !s.empty() && !(s.peek() == '^' || s.peek() == '(') )
                            { System.out.print(s.pop()); }
                            s.push(token);
                            break;
                    case '*':
                    case '/': while ( !s.empty() && s.peek() != '+' && s.peek() != '-' && s.peek() != '(' )
                            { System.out.print(s.pop()); }
                            s.push(token);
                            break;
                    case '+':
                    case '-': while ( !s.empty() && s.peek() != '(' )
                            { System.out.print(s.pop() + " "); }
                            s.push(token);
                            break;
                }
            }
        }
        while (!s.empty())
        { System.out.print(s.pop()); }
        System.out.println();
    }

    public static void main(String[] args) {
        InFixToPostFix();
    }
}

/* Output:
1 + 2 + 3 * 5 =
+ *+
*///:~


