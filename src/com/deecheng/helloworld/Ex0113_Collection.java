/*
 * Copyright (c). All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * @Author cdee <zycheng.gm@gmail.com>, 2018.
 */

package com.deecheng.helloworld;

public class Ex0113_Collection<Object> {
    private static final int MAX_SIZE = 256;
    private Object[] storedValue;
    private int size = 0;

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        if (size != 0) {
            return false;
        } else {
            return true;
        }
    }

    public void makeEmpty() {
        size = 0;
    }

    public void insert(Object x) {
        if (size < MAX_SIZE) {
            storedValue[size++] = x;
        }
    }

    public boolean isPresent(Object x) {
        for (Object object : storedValue) {
            if (x.equals(object)) {
                return true;
            }
        }
        return false;
    }

    // Low Performance implementation of remove
    public void remove(Object x) {
        Object[] tmpStoredValue;
        int indexOfInput;
        for (int i = 0; i < size; i++) {
            if (storedValue[i].equals(x)) {
                indexOfInput = i;
                break;
            }
        }
        //TODO: Copy the rest objects to the tmpStoredValue
    }

}
