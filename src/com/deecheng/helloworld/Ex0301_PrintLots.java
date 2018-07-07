package com.deecheng.helloworld;

import java.util.Iterator;

public class Ex0301_PrintLots {
    public static <AnyType> void printLots(MyArrayList<AnyType> L, MyArrayList<Integer> P) {
        Iterator<AnyType> iterL = L.iterator();
        Iterator<Integer> iterP = P.iterator();

        AnyType itemL = null;
        Integer itemP = null;
        int start = 0;

        while (iterL.hasNext() && iterP.hasNext()) {
            itemP = iterP.next();

            System.out.println("Looking for the item in position: " + itemP);
            while (start < itemP && iterL.hasNext()) {
                start++;
                itemL = iterL.next();
            }
            System.out.println(itemL);
        }
    }

    public static void main(String[] args) {
        MyArrayList<Integer> l = new MyArrayList<>( );
        MyArrayList<Integer> p = new MyArrayList<>( );

        for( int i = 0; i < 10; i++ )
            l.add( i );

        System.out.println("The l list: " + l );

        for( int i = 0; i < 5; i++ )
            p.add( i * 2 );

        System.out.println("The p list: " + p );

        printLots(l,p);
    }
}
