/*
 * Copyright (c). All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * @Author cdee <zycheng.gm@gmail.com>, 2018.
 */

// This Collection implementation mostly base on `MyArrayList` in Chapter 3 with sightly differences.

package com.deecheng.helloworld;

import java.util.Iterator;

public class Ex0113_Collection<AnyType> implements Iterable<AnyType> {
    private static final int DEFAULT_CAPACITY = 256;
    private AnyType[] storedValue;
    private int size = 0;

    public Ex0113_Collection() {
        makeEmpty();
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        /*if (size != 0) {
            return false;
        } else {
            return true;
        }*/
        return getSize() == 0; // We ensure that para `size` is in the bound of array.
    }

    public void makeEmpty() {
        size = 0;
        ensureCapacity(DEFAULT_CAPACITY);
    }

    private void ensureCapacity(int newCapacity) {
        if (newCapacity < getSize()) {
            return;
        }
        AnyType[] oldStoredValue = storedValue;
        storedValue = (AnyType[]) new Object[newCapacity];
        for (int i = 0; i < getSize(); i++) {
            storedValue[i] = oldStoredValue[i];
        }

//        System.arraycopy(oldStoredValue, 0, storedValue, 0, getSize());  // ERROR: java.lang.NullPointerException
    }

    public AnyType get(int idx) {
        if (idx < 0 && idx >= size) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return storedValue[idx];
    }

    public AnyType set(int idx, AnyType newVal) {
        if (idx < 0 || idx >= getSize()) {
            throw new ArrayIndexOutOfBoundsException();
        }
        AnyType old = storedValue[idx];
        storedValue[idx] = newVal;
        return old;
    }

    public boolean insert(AnyType x) {
        insert(getSize(), x);
        return true;
    }

    public void insert(int idx, AnyType x) {
        if (storedValue.length == getSize()) {
            ensureCapacity(getSize() * 2 + 1);
        }
        for (int i = size; i > idx; i--) {
            storedValue[i] = storedValue[i - 1];
        }
        storedValue[idx] = x;

        size++;
    }

    public boolean isPresent(AnyType x) {
        for (AnyType object : storedValue) {
            if (x.equals(object)) {
                return true;
            }
        }
        return false;
    }

    // Low Performance implementation of remove
    public AnyType remove(int idx) {
        AnyType removedItem = storedValue[idx];

        for (int i = idx; i < getSize() - 1; i++) {  // Notice: `getSize() - 1`
            storedValue[i] = storedValue[i + 1];
        }

        size--;
        return removedItem;
    }

    @Override
    public Iterator<AnyType> iterator() {
        return new CollectionIterator();
    }

    private class CollectionIterator implements Iterator<AnyType> {
        private int current = 0;

/*        private myCollectionIterator (Ex0113_Collection list)
            { this.list = list; }*/

        @Override
        public boolean hasNext() {
            return current < getSize();
        }

        @Override
        public AnyType next() {
            if (!hasNext()) {
                throw new java.util.NoSuchElementException();
            }
            return storedValue[current++];
        }

        @Override
        public void remove() {
            Ex0113_Collection.this.remove(--current);
        }
    }

    // Test Program
    public static void main(String[] args) {
        Ex0113_Collection<Integer> collection = new Ex0113_Collection<>( );

        for( int i = 0; i < 10; i++ )
            collection.insert( i );
        for( int i = 20; i < 30; i++ )
            collection.insert( 0, i );

        collection.remove( 0 );
        collection.remove( collection.getSize( ) - 1 );
        for (Object x : collection) {
            System.out.print(x + " ");
        }

        for( int i = 0; i < 10; i++ ) {
            System.out.print(collection.isPresent( 9 ) + " ");
        }
//        System.out.println( collection );  // Output: com.deecheng.helloworld.Ex0113_Collection@50cbc42f
    }
}
/* Output:
28 27 26 25 24 23 22 21 20 0 1 2 3 4 5 6 7 8
 *///:~