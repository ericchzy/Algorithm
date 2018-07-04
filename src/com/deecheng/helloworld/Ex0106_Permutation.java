/*
 * Copyright (c). All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * @Author cdee <zycheng.gm@gmail.com>, 2018.
 */

package com.deecheng.helloworld;

public class Ex0106_Permutation {
    public static void permute(char[] str, int low, int high) {
        if (high <= 1) {
            return;
        }
        if (low == high) {
            System.out.println(str);
        } else {
            for (int i = low; i <= high; i++) {
                swap(str, low, i);
                permute(str, low + 1, high);
                swap(str, i, low);
            }
        }
    }

    private static void swap(char[] str, int left, int right) {
        char tmp = str[left];
        str[left] = str[right];
        str[right] = tmp;
    }

    // Test Program
    public static void main(String[] args) {
        char[] charArray = {'a', 'b', 'c'};
        System.out.println(charArray.length);
        Ex0106_Permutation.permute(charArray, 0 , charArray.length-1);
    }
}

/* Output:
3
abc
acb
bac
bca
cba
cab
*///:~



