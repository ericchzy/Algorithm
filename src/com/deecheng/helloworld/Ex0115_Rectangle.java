/*
 * Copyright (c). All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * @Author cdee <zycheng.gm@gmail.com>, 2018.
 */

package com.deecheng.helloworld;

public class Ex0115_Rectangle {
    private int length;
    private int width;

    public Ex0115_Rectangle(int length, int width) {
        this.length = length;
        this.width = width;
    }

    public int getLength() {
        return length;
    }

    public int getWidth() {
        return width;
    }

    public int getSquare() {
        return length * width;
    }

    public int getRound() {
        return (length * 2 + width * 2);
    }

    static class SquareCompare implements Comparator<Ex0115_Rectangle> {
        @Override
        public int compare(Ex0115_Rectangle lrec, Ex0115_Rectangle rrec) {
            return (lrec.getSquare() - rrec.getSquare());
        }
    }

    static class RoundCompare implements Comparator<Ex0115_Rectangle> {
        @Override
        public int compare(Ex0115_Rectangle lrec, Ex0115_Rectangle rrec) {
            return (lrec.getRound() - rrec.getRound());
        }
    }

}

class Ex0115_RectangleTestProgram {
    public static void main(String[] args) {
        Ex0115_Rectangle[] arr = { new Ex0115_Rectangle(1,2),
                            new Ex0115_Rectangle(2,3),
                            new Ex0115_Rectangle(10,2) };
        System.out.println("The biggest rectangle in the array is: " + Fig01_18.findMax(arr, new Ex0115_Rectangle.SquareCompare()).getSquare());
        System.out.println("The longest rectangle in the array is: " + Fig01_18.findMax(arr, new Ex0115_Rectangle.RoundCompare()).getRound());
    }
}
