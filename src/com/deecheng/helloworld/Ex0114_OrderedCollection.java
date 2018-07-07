package com.deecheng.helloworld;


/* OrderedCollection keep the Comparable object in order. */

public class Ex0114_OrderedCollection {
    private int theSize;
    private Comparable[] storedValues;
    private static int DEFAULT_CAPACITY = 10;

    public Ex0114_OrderedCollection() {
        makeEmpty();
    }

    public int size() {
        return theSize;
    }

    public boolean isEmpty() {

        return size() == 0; // We ensure that para `theSize` is in the bound of array.
    }

    public void makeEmpty() {
        theSize = 0;
        ensureCapacity(DEFAULT_CAPACITY);
    }

    private void ensureCapacity(int newCapacity) {
        if (newCapacity < size()) {
            return;
        }
        Comparable[] oldStoredValue = storedValues;

        // java.base/[Ljava.lang.Object; cannot be cast to java.base/[Ljava.lang.Comparable
        storedValues = (Comparable[]) new Object[newCapacity];
        for (int i = 0; i < size(); i++) {
            storedValues[i] = oldStoredValue[i];
        }
    }

    public boolean insert(Comparable x) {
        insert(size(), x);
        return true;
    }

    public void insert(int idx, Comparable x) {
        if (storedValues.length == size()) {
            ensureCapacity(size() * 2 + 1);
        }
        for (int i = theSize; i > idx; i--) {
            storedValues[i] = storedValues[i - 1];
        }
        storedValues[idx] = x;

        theSize++;
    }

    /**
     * Removes an item from this collection.
     *
     * @param idx the index of the object.
     * @return the item was removed from the collection.
     * @throws ArrayIndexOutOfBoundsException if index is out of range.
     */
    // Low Performance implementation of remove method
    public Comparable remove(int idx) {
        Comparable removedItem = storedValues[idx];

        if (idx < 0 || idx >= size()) {
            throw new ArrayIndexOutOfBoundsException();
        }

        for (int i = idx; i < size() - 1; i++) {  // Notice: `size() - 1`
            storedValues[i] = storedValues[i + 1];
        }

        theSize--;
        return removedItem;
    }

    public Comparable findMax(Comparable[] arr) {
        int maxIndex = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i].compareTo(arr[maxIndex]) > 0) {
                maxIndex = i;
            }
        }

        return arr[maxIndex];
    }

    public Comparable findMin(Comparable[] arr) {
        int minIndex = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i].compareTo(arr[minIndex]) < 0) {
                minIndex = i;
            }
        }
        return arr[minIndex];
    }

    public static void main(String[] args) {
        Ex0114_OrderedCollection collection = new Ex0114_OrderedCollection();

        for (int i = 0; i < 10; i++)
            collection.insert(i);
        for (int i = 20; i < 30; i++)
            collection.insert(0, i);

        collection.remove(0);
        collection.remove(collection.size() - 1);

    }
}
