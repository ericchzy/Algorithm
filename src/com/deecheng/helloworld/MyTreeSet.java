package com.deecheng.helloworld;


import org.omg.CORBA.Any;

import java.util.NoSuchElementException;

public class MyTreeSet<AnyType extends Comparable<? super AnyType>> {
    private int modCount;
    private BinaryNode<AnyType> root;
    private static class BinaryNode<Anytype> {
        BinaryNode(Anytype theElement) {
            this(theElement, null, null, null);
        }

        BinaryNode(Anytype theElement, BinaryNode<Anytype> lt, BinaryNode<Anytype> rt, BinaryNode<Anytype> pt) {
            element = theElement;
            left = lt;
            right = rt;
            parent = pt;

        }

        Anytype element;
        BinaryNode<Anytype> left;
        BinaryNode<Anytype> right;
        BinaryNode<Anytype> parent;
    }

    public java.util.Iterator<AnyType> iterator() {
        return new MyTreeSetIterator();
    }

    private class MyTreeSetIterator implements java.util.Iterator<AnyType> {
        private BinaryNode<AnyType> current = findMin(root);
        private BinaryNode<AnyType> previous;
        private int expectedModCount = modCount;
        private boolean okToRemove = false;
        private boolean atEnd = false;

        @Override
        public boolean hasNext() {
            return !atEnd;
        }

        @Override
        public AnyType next() {
            if (modCount != expectedModCount) {
                throw new UnderflowException();
            }
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            AnyType nextItem = current.element;
            previous = current;

            if (current.right != null) {
                current = findMin(current.right);
            } else {
                BinaryNode<AnyType> child = current;
                current = current.parent;
                while (current != null && current.left != child) {
                    child = current;
                    current = current.parent;
                }
                if (current == null) {
                    atEnd = true;
                }
            }
            okToRemove = true;

            return nextItem;
        }

        @Override
        public void remove() {
            if (modCount != expectedModCount) {
                throw new java.util.ConcurrentModificationException();
            }
            if (!okToRemove) {
                throw new IllegalStateException();
            }
            MyTreeSet.this.remove(previous.element);
            okToRemove = false;
        }
    }

    public MyTreeSet() {
        root = null;
    }

    public void makeEmpty() {
        modCount++;
        root = null;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public boolean contains(AnyType x) {
        return contains(x, root);
    }

    /**
     * If the TreeSet contains the item.
     * @param x the object
     * @param root the root of the TreeSet
     * @return true/false
     */
    public boolean contains(AnyType x, BinaryNode<AnyType> root) {

    }

    public AnyType findMin() throws UnderflowException {
        if (isEmpty()) {
            throw new UnderflowException();
        } else {
            return findMin(root).element;
        }
    }

    /**
     * Removes an node from this MyTreeSet.
     * @param x the object.
     */
    public void remove(AnyType x) {
        root = remove(x, root);
    }

    public void insert(AnyType x) {
        root = insert(x, root, null);
    }

    public AnyType findMax() throws UnderflowException {
        if (isEmpty()) {
            throw new UnderflowException();
        } else {
            return findMax(root).element;
        }
    }

    private BinaryNode<AnyType> findMin(BinaryNode<AnyType> t) throws UnderflowException {
        if (t == null) {
            return null;
        } else if (t.left == null) {
            return t;
        }
        return findMin(t.left);
    }

    private BinaryNode<AnyType> findMax(BinaryNode<AnyType> t) throws UnderflowException {
        if (t == null) {
            return null;
        } else if (t.right == null) {
            return t;
        }
        return findMax(t.right);
    }

    private BinaryNode<AnyType> insert(AnyType x, BinaryNode<AnyType> t, BinaryNode<AnyType> pt) {
        if (t == null) {
            modCount++;
            return new BinaryNode<AnyType>(x, null, null, pt);
        }
    }

    private BinaryNode<AnyType> remove(AnyType x, BinaryNode<AnyType> root) {

    }









}
