package com.deecheng.helloworld;

public class Ex0103_printDouble {
    public static void main(String[] args) {
        output(-12345.6789);
    }

    static void output(double num){
        // Processing the negative sign
        if(num < 0){}
        System.out.print("-");

        // Processing the integer part
        long digit = Math.abs((long)num);
        if(digit < 1){
            System.out.print("0");
        }else{
            printDigit(digit);
        }

        // Processing the dot
        System.out.print(".");

        // Processing the decimal part
        double decimal = Math.abs(num-(long) num);
        if(decimal > 0){
            printDigit(decimal);
        }else{
            System.out.print("0");
        }
    }


    static void printDigit(double num){
        if(num > 1){
            printDigit( (long)(num/10) );
            System.out.print( (long) (num%10) );
        }else if(num > 0 && num < 1){
            long digit = (long) (num*10);
            System.out.print(digit);
            printDigit(num*10 - digit);
        }else if(num == 1){
            System.out.print("1");
        }
    }

}


