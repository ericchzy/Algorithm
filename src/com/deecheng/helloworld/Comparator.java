/*
 * Copyright (c). All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by Dee Cheng<zycheng.gm@gmail.com>, 2018.
 */

package com.deecheng.helloworld;

public interface Comparator<AnyType> {
    int compare(AnyType lhs, AnyType rhs);
}

/*
public interface Comparator<Shape> {
    int compare(Shape lhs, Shape rhs);
}
*/
