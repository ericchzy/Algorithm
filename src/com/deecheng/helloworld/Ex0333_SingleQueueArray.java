package com.deecheng.helloworld;

import java.util.ArrayList;

public class Ex0333_SingleQueueArray<AnyType> {

    // note: actually holds one less than given size
    public Ex0333_SingleQueueArray() {
        this(11);
    }
    public Ex0333_SingleQueueArray(int s) {
        maxSize = s;
        front = 0;
        rear = 0;
        elements = new ArrayList<AnyType> (maxSize);
    }
    void enqueue(AnyType x)
    {
        if ( !full() )
        {
            if (elements.size() < maxSize) // add elements until size is reached
                elements.add(x);
            else
                elements.set(rear, x); // after size is reached, use set
            rear = (rear + 1) % maxSize;
        }
    }
    public AnyType dequeue() {
        AnyType temp=null;
        if ( !empty() )
        {
            temp = elements.get(front);
            front = (front+1) % maxSize;
        }
        return temp;
    }
    boolean empty() {
        return front == rear;
    }
    boolean full() {
        return (rear + 1) % maxSize == front;
    }

    private int front, rear;
    private int maxSize;
    private ArrayList<AnyType> elements;
}

class TestProgram {
    public static void main(String[] args) {
        Ex0333_SingleQueueArray singleQueueArray = new Ex0333_SingleQueueArray();
        for (int i = 0; i < 20; i++) {
            singleQueueArray.enqueue(i);
        }
        for (int i = 0; i < 20; i++) {
            System.out.print(singleQueueArray.dequeue() + " ");
        }
    }
}