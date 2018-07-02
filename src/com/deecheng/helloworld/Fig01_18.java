/*
 * Copyright (c). All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by Dee Cheng<czyxyz@qq.com>, 2018.
 */

package com.deecheng.helloworld;

public class Fig01_18 {
    // Generic findMax, with a function object.
    // Precondition: a.size() > 0.

    /**
     * Find the maximum in the array
     * @param arr an array of the object
     * @param cmp Class Function that implements Comparator interface
     */
    public static <AnyType> AnyType findMax(AnyType [ ] arr, Comparator<? super AnyType> cmp) {
        int maxIndex = 0;

        for (int i = 0; i < arr.length; i++) {
            if (cmp.compare(arr[i], arr[maxIndex]) > 0) {
                maxIndex = i;
            }
        }

        return arr[maxIndex];
    }

    static class CaseInsensitiveCompare implements Comparator<String> {
        @Override
        public int compare(String lhs, String rhs) {
            return lhs.compareToIgnoreCase(rhs);
        }
    }
}

class TestProgram {
    public static void main(String[] args) {
        String [] arr = {"ZEBRA", "alligator", "crocodile"};
        System.out.println(Fig01_18.findMax(arr, new Fig01_18.CaseInsensitiveCompare()));
    }
}





