package com.deecheng.helloworld; /* Added by Eclipse.py */


public interface HashFamily<AnyType>
{
    int hash( AnyType x, int which );
    int getNumberOfFunctions( );
    void generateNewFunctions( );
}
