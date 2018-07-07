package com.deecheng.helloworld;


public class Ex0302_SwapElement<AnyType> extends MyLinkedList {

    // beforeP is the cell before the two adjacent cells that are to be swapped.
    // Error checks are omitted for clarity.
    public static void swapWithNext_singlyLinkedList( Node beforep ) {
        Node p, afterp;

        p = beforep.next;
        afterp = p.next; // Both p and afterp assumed not null.
        p.next = afterp.next;
        beforep.next = afterp;
        afterp.next = p;
    }

    // p and afterp are cells to be switched. Error checks as before.
    public static void swapWithNext_doublyLinkedList(Node p) {
        Node beforep, afterp;

        beforep = p.prev;
        afterp = p.next;
        beforep.next = afterp;
        afterp.next = p;
        p.next = afterp.next;
        afterp.next.prev = p;
        p.prev = afterp;
        afterp.prev = beforep;
    }
}
