package com.deecheng.helloworld;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class Ex0305_Union {
    public static <AnyType extends Comparable<? super AnyType>>
    void union(List<AnyType> L1, List<AnyType> L2, List<AnyType> unionResult) {

        ListIterator<AnyType> iterL1 = L1.listIterator();
        ListIterator<AnyType> iterL2 = L2.listIterator();
        AnyType itemL1=null, itemL2=null;

        // get first item in each list
        if ( iterL1.hasNext() && iterL2.hasNext() )
        {
            itemL1 = iterL1.next();
            itemL2 = iterL2.next();
        }
        while ( itemL1 != null && itemL2 != null )
        {
            int compareResult = itemL1.compareTo(itemL2);
            if ( compareResult == 0 )
            {
                unionResult.add(itemL1);
                itemL1 = iterL1.hasNext()?iterL1.next():null;
                itemL2 = iterL2.hasNext()?iterL2.next():null;
            }
            else if ( compareResult < 0 )
            {
                unionResult.add(itemL1);
                itemL1 = iterL1.hasNext()?iterL1.next():null;
            }
            else
            {
                unionResult.add(itemL2);
                itemL2 = iterL2.hasNext()?iterL2.next():null;
            }
        }

        while (itemL1 != null) {
            unionResult.add(itemL1);
            itemL1 = iterL1.hasNext()?iterL1.next():null;
        }
        while (itemL2 != null) {
            unionResult.add(itemL2);
            itemL2 = iterL2.hasNext()?iterL2.next():null;
        }
    }

    public static void main(String[] args) {
        List<Integer> l1 = new ArrayList<>();
        List<Integer> l2 = new ArrayList<>();
        List<Integer> l3 = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            l1.add(i);
        }
        for (int i = 3; i < 10; i++) {
            l2.add(i * 2);
        }
        union(l1, l2, l3);
        System.out.println("l1: " + l1);
        System.out.println("l2: " + l2);
        System.out.println("union set: " + l3);
    }
}

/* Output:
l1: [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
l2: [6, 8, 10, 12, 14, 16, 18]
union set: [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 12, 14, 16, 18]
*///:~